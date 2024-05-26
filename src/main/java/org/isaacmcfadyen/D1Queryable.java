package org.isaacmcfadyen;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class TableNameFinderNoSchema extends TablesNamesFinder {
    @Override
    protected String extractTableName(Table table) {
        // Ignore schema.
        return table.getName();
    }
}

public abstract class D1Queryable {
    D1Queryable(String apiToken, String accountId, String databaseId) {
        this.apiToken = apiToken;
        this.accountId = accountId;
        this.databaseId = databaseId;
    }

    protected String accountId;
    protected String databaseId;
    protected String apiToken;

    private D1ResultSet parseFromJson(JSONArray results) throws SQLException {
        if (results.isEmpty()) {
            return new D1ResultSet(
                    apiToken, accountId, databaseId,
                    Collections.emptyList(), Collections.emptyList(), Collections.emptyList()
            );
        }
        // Pull column names.
        List<String> columnNames = new ArrayList<>(results.getJSONObject(0).keySet());

        // Map to rows.
        List<List<Object>> rows = new ArrayList<>();
        for (int i = 0; i < results.length(); i++) {
            JSONObject row = results.getJSONObject(i);
            List<Object> rowList = new ArrayList<>();
            for (String columnName : columnNames) {
                rowList.add(row.get(columnName));
            }
            rows.add(rowList);
        }

        // Map to column schema based on JSON datatypes.
        List<JSONObject> columnSchema = new ArrayList<>();
        for (String columnName : columnNames) {
            JSONObject column = new JSONObject();
            Object value = results.getJSONObject(0).get(columnName);
            if (value instanceof String) {
                column.put("type", "TEXT");
            } else if (value instanceof Integer) {
                column.put("type", "INTEGER");
            } else if (value instanceof Double) {
                column.put("type", "REAL");
            } else if (value instanceof Boolean) {
                column.put("type", "BOOLEAN");
            } else if (value instanceof JSONObject) {
                column.put("type", "JSON");
            } else if (value instanceof JSONArray) {
                column.put("type", "JSON");
            } else {
                column.put("type", "TEXT");
            }
            columnSchema.add(column);
        }

        return new D1ResultSet(apiToken, accountId, databaseId, rows, columnNames, columnSchema);
    }

    protected D1ResultSet generateResultSet(JSONObject json, String query) throws SQLException {
        JSONArray results = json.getJSONArray("results");

        try {
            String tableName = TableNameFinderNoSchema.findTables(query).iterator().next();

            // Run a query to get the column schema.
            JSONObject columnSchemaQuery = queryDatabase(
                    "PRAGMA table_info(" + tableName + ")",
                    null
            );
            JSONArray columnSchemaArray = columnSchemaQuery.getJSONArray("results");
            List<JSONObject> columnSchema = new ArrayList<>();
            for (int i = 0; i < columnSchemaArray.length(); i++) {
                columnSchema.add(columnSchemaArray.getJSONObject(i));
            }

            // Map the name key in the columnSchemas to the column names.
            List<String> columnNames = new ArrayList<>();
            for (int i = 0; i < columnSchemaArray.length(); i++) {
                JSONObject columnSchemaObject = columnSchemaArray.getJSONObject(i);
                columnNames.add(columnSchemaObject.getString("name"));
            }

            // Map the rows to a list, making sure they are in the same order.
            List<List<Object>> rows = new ArrayList<>();
            for (int i = 0; i < results.length(); i++) {
                JSONArray row = results.getJSONArray(i);
                List<Object> rowList = new ArrayList<>();
                for (int j = 0; j < row.length(); j++) {
                    rowList.add(row.get(j));
                }
                rows.add(rowList);
            }

            D1ResultSet finalResults = new D1ResultSet(apiToken, accountId, databaseId, rows, columnNames, columnSchema);
            finalResults.setTableName(tableName);
            return finalResults;
        } catch (Exception e) {
            // Fall back to pure-JSON parsing.
            // This is non-ideal because it fails if there are 0 rows, but is required
            // for some queries that don't have a table name or have an invalid table name.
            System.err.println("Falling back to simple JSON schema parsing for query: " + query);
            return parseFromJson(results);
        }
    }

    private JSONObject preProcessQuery(String sql) {
        String lowered = sql.toLowerCase();

        // Not authorized to do this command so mock it.
        if (lowered.equals("pragma database_list")) {
            return new JSONObject()
                    .put(
                            "results",
                            new JSONArray()
                                    .put(
                                            new JSONObject()
                                                    .put("seq", 0)
                                                    .put("name", "main")
                                                    .put("file", "main")
                                    )
                    );
        }

        // Not authorized to do this command so mock it.
        if (lowered.equals("pragma collation_list")) {
            return new JSONObject()
                    .put(
                            "results",
                            new JSONArray()
                                    .put(
                                            new JSONObject()
                                                    .put("seq", 0)
                                                    .put("name", "decimal")
                                    )
                                    .put(
                                            new JSONObject()
                                                    .put("seq", 1)
                                                    .put("name", "uint")
                                    )
                                    .put(
                                            new JSONObject()
                                                    .put("seq", 2)
                                                    .put("name", "RTRIM")
                                    )
                                    .put(
                                            new JSONObject()
                                                    .put("seq", 3)
                                                    .put("name", "NOCASE")
                                    )
                                    .put(
                                            new JSONObject()
                                                    .put("seq", 4)
                                                    .put("name", "BINARY")
                                    )
                    );
        }

        // This is a special table used internally by Cloudflare and shouldn't be queried.
        // Reference: https://x.com/KentonVarda/status/1770241360722846120
        if (lowered.contains("_cf_kv")) {
            return new JSONObject().put("results", new JSONArray());
        }

        return null;
    }
    private JSONObject postProcessResults(String originalSql, JSONObject results) {
        String lowered = originalSql.toLowerCase();

        if(lowered.startsWith("select type, name, tbl_name, rootpage from")) {
            // Strip the _cf_KV table from results.
            JSONArray newResults = new JSONArray();
            JSONArray oldResults = results.getJSONArray("results");
            for (int i = 0; i < oldResults.length(); i++) {
                JSONObject row = oldResults.getJSONObject(i);
                if (row.getString("name").toLowerCase().contains("_cf_kv")) {
                    continue;
                }
                newResults.put(row);
            }
            return new JSONObject().put("results", newResults);
        }
        return results;
    }

    protected JSONObject queryDatabase(String sql, JSONArray params) throws SQLException {
        System.out.println("Querying database with query: " + sql);

        // We mock some queries because D1 doesn't allow them and the driver requires them to operate.
        JSONObject mocked = preProcessQuery(sql);
        if (mocked != null) return mocked;

        try {
            URL url = new URL("https://api.cloudflare.com/client/v4/accounts/" + accountId + "/d1/database/" + databaseId + "/query");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Authorization", "Bearer " + apiToken);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            JSONObject query = new JSONObject();
            query.put("sql", sql);
            query.put("params", params);
            connection.getOutputStream().write(query.toString().getBytes());
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            if (connection.getResponseCode() != 200) {
                if (connection.getResponseCode() == 404) {
                    throw new SQLException("Invalid D1 database ID.");
                } else if (connection.getResponseCode() == 400) {
                    InputStream errorStream = connection.getErrorStream();
                    String result = new BufferedReader(new InputStreamReader(errorStream))
                            .lines()
                            .parallel()
                            .collect(Collectors.joining("\n"));
                    JSONObject json = new JSONObject(result);
                    JSONArray errors = json.getJSONArray("errors");
                    String error = errors.getJSONObject(0).getString("message");
                    throw new SQLException(error);
                } else if (connection.getResponseCode() == 500) {
                    InputStream errorStream = connection.getErrorStream();
                    String result = new BufferedReader(new InputStreamReader(errorStream)).lines().parallel().collect(Collectors.joining("\n"));
                    throw new SQLException(result);
                }

                throw new SQLException(connection.getResponseMessage());
            }

            InputStream inputStream = connection.getInputStream();
            String result = new BufferedReader(new InputStreamReader(inputStream))
                    .lines()
                    .parallel()
                    .collect(Collectors.joining("\n"));
            JSONObject json = new JSONObject(result);

            if (!json.getBoolean("success")) {
                throw new SQLException(json.getJSONArray("result").getJSONObject(0).getString("error"));
            }

            JSONObject results = json.getJSONArray("result").getJSONObject(0);
            return postProcessResults(sql, results);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
}

package org.isaacmcfadyen;

import org.json.JSONObject;
import org.json.JSONArray;

import java.sql.*;
import java.util.*;
import java.util.regex.Pattern;

public class D1DatabaseMetaData extends D1Queryable implements DatabaseMetaData {
    private final D1Connection parentConnection;


    D1DatabaseMetaData(String ApiKey, String AccountId, String DatabaseUuid, D1Connection connection) {
        super(ApiKey, AccountId, DatabaseUuid);
        this.parentConnection = connection;
    }

    @Override
    public boolean allProceduresAreCallable() throws SQLException {
        return false;
    }

    @Override
    public boolean allTablesAreSelectable() throws SQLException {
        return true;
    }

    @Override
    public String getURL() throws SQLException {
        return String.format("jbdc:d1://%s", databaseId);
    }

    @Override
    public String getUserName() throws SQLException {
        throw new SQLException("Not implemented: getUserName()");
    }

    @Override
    public boolean isReadOnly() throws SQLException {
        return false;
    }

    @Override
    public boolean nullsAreSortedHigh() throws SQLException {
        return false;
    }

    @Override
    public boolean nullsAreSortedLow() throws SQLException {
        return false;
    }

    @Override
    public boolean nullsAreSortedAtStart() throws SQLException {
        return false;
    }

    @Override
    public boolean nullsAreSortedAtEnd() throws SQLException {
        return false;
    }

    @Override
    public String getDatabaseProductName() throws SQLException {
        return "SQLite";
    }

    @Override
    public String getDatabaseProductVersion() throws SQLException {
        return "3.45.1";
    }

    @Override
    public String getDriverName() throws SQLException {
        return "D1 JDBC Driver";
    }

    @Override
    public String getDriverVersion() throws SQLException {
        return "1.0";
    }

    @Override
    public int getDriverMajorVersion() {
        return 1;
    }

    @Override
    public int getDriverMinorVersion() {
        return 0;
    }

    @Override
    public boolean usesLocalFiles() throws SQLException {
        return true;
    }

    @Override
    public boolean usesLocalFilePerTable() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return true;
    }

    @Override
    public boolean storesUpperCaseIdentifiers() throws SQLException {
        return false;
    }

    @Override
    public boolean storesLowerCaseIdentifiers() throws SQLException {
        return false;
    }

    @Override
    public boolean storesMixedCaseIdentifiers() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsMixedCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    @Override
    public boolean storesUpperCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    @Override
    public boolean storesLowerCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    @Override
    public boolean storesMixedCaseQuotedIdentifiers() throws SQLException {
        return false;
    }

    @Override
    public String getIdentifierQuoteString() throws SQLException {
        return "\"";
    }

    @Override
    public String getSQLKeywords() throws SQLException {
        throw new SQLException("Not implemented: getSQLKeywords()");
    }

    @Override
    public String getNumericFunctions() throws SQLException {
        throw new SQLException("Not implemented: getNumericFunctions()");
    }

    @Override
    public String getStringFunctions() throws SQLException {
        throw new SQLException("Not implemented: getStringFunctions()");
    }

    @Override
    public String getSystemFunctions() throws SQLException {
        throw new SQLException("Not implemented: getSystemFunctions()");
    }

    @Override
    public String getTimeDateFunctions() throws SQLException {
        // Ref; https://github.com/xerial/sqlite-jdbc/blob/master/src/main/java/org/sqlite/jdbc3/JDBC3DatabaseMetaData.java
        return "DATE,TIME,DATETIME,JULIANDAY,STRFTIME";
    }

    @Override
    public String getSearchStringEscape() throws SQLException {
        return "\\";
    }

    @Override
    public String getExtraNameCharacters() throws SQLException {
        throw new SQLException("Not implemented: getExtraNameCharacters()");
    }

    @Override
    public boolean supportsAlterTableWithAddColumn() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsAlterTableWithDropColumn() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsColumnAliasing() throws SQLException {
        return true;
    }

    @Override
    public boolean nullPlusNonNullIsNull() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsConvert() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsConvert(int fromType, int toType) throws SQLException {
        return false;
    }

    @Override
    public boolean supportsTableCorrelationNames() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsDifferentTableCorrelationNames() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsExpressionsInOrderBy() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsOrderByUnrelated() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsGroupBy() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsGroupByUnrelated() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsGroupByBeyondSelect() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsLikeEscapeClause() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsMultipleResultSets() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsMultipleTransactions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsNonNullableColumns() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsMinimumSQLGrammar() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsCoreSQLGrammar() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsExtendedSQLGrammar() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsANSI92EntryLevelSQL() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsANSI92IntermediateSQL() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsANSI92FullSQL() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsIntegrityEnhancementFacility() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsOuterJoins() throws SQLException {
        return true;
    }

    @Override
    public boolean supportsFullOuterJoins() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsLimitedOuterJoins() throws SQLException {
        return false;
    }

    @Override
    public String getSchemaTerm() throws SQLException {
        return "schema";
    }

    @Override
    public String getProcedureTerm() throws SQLException {
        return "not_implemented";
    }

    @Override
    public String getCatalogTerm() throws SQLException {
        return "catalog";
    }

    @Override
    public boolean isCatalogAtStart() throws SQLException {
        return true;
    }

    @Override
    public String getCatalogSeparator() throws SQLException {
        return ".";
    }

    @Override
    public boolean supportsSchemasInDataManipulation() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSchemasInProcedureCalls() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSchemasInTableDefinitions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSchemasInIndexDefinitions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSchemasInPrivilegeDefinitions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsCatalogsInDataManipulation() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsCatalogsInProcedureCalls() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsCatalogsInTableDefinitions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsCatalogsInIndexDefinitions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsCatalogsInPrivilegeDefinitions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsPositionedDelete() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsPositionedUpdate() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSelectForUpdate() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsStoredProcedures() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSubqueriesInComparisons() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSubqueriesInExists() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSubqueriesInIns() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsSubqueriesInQuantifieds() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsCorrelatedSubqueries() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsUnion() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsUnionAll() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsOpenCursorsAcrossCommit() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsOpenCursorsAcrossRollback() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsOpenStatementsAcrossCommit() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsOpenStatementsAcrossRollback() throws SQLException {
        return false;
    }

    @Override
    public int getMaxBinaryLiteralLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxCharLiteralLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxColumnNameLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxColumnsInGroupBy() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxColumnsInIndex() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxColumnsInOrderBy() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxColumnsInSelect() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxColumnsInTable() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxConnections() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxCursorNameLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxIndexLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxSchemaNameLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxProcedureNameLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxCatalogNameLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxRowSize() throws SQLException {
        return 0;
    }

    @Override
    public boolean doesMaxRowSizeIncludeBlobs() throws SQLException {
        return false;
    }

    @Override
    public int getMaxStatementLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxStatements() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxTableNameLength() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxTablesInSelect() throws SQLException {
        return 0;
    }

    @Override
    public int getMaxUserNameLength() throws SQLException {
        return 0;
    }

    @Override
    public int getDefaultTransactionIsolation() throws SQLException {
        return 0;
    }

    @Override
    public boolean supportsTransactions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsTransactionIsolationLevel(int level) throws SQLException {
        return false;
    }

    @Override
    public boolean supportsDataDefinitionAndDataManipulationTransactions() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsDataManipulationTransactionsOnly() throws SQLException {
        return false;
    }

    @Override
    public boolean dataDefinitionCausesTransactionCommit() throws SQLException {
        return false;
    }

    @Override
    public boolean dataDefinitionIgnoredInTransactions() throws SQLException {
        return false;
    }

    @Override
    public ResultSet getProcedures(String catalog, String schemaPattern, String procedureNamePattern) throws SQLException {
        throw new SQLException("Not implemented: getProcedures(String catalog, String schemaPattern, String procedureNamePattern)");
    }

    @Override
    public ResultSet getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern) throws SQLException {
        throw new SQLException("Not implemented: getProcedureColumns(String catalog, String schemaPattern, String procedureNamePattern, String columnNamePattern)");
    }

    @Override
    public ResultSet getTables(String catalog, String schemaPattern, String tableNamePattern, String[] types) throws SQLException {
        JSONObject json = queryDatabase("PRAGMA table_list", null);
        JSONArray tables = json.getJSONArray("results");

        List<String> columnNames = Arrays.asList(
                "TABLE_CAT",
                "TABLE_SCHEM",
                "TABLE_NAME",
                "TABLE_TYPE",
                "REMARKS",
                "TYPE_CAT",
                "TYPE_SCHEM",
                "TYPE_NAME",
                "SELF_REFERENCING_COL_NAME",
                "REF_GENERATION"
        );

        List<List<Object>> rows = new ArrayList<>();
        for (int i = 0; i < tables.length(); i++) {
            List<Object> row = new ArrayList<>();
            JSONObject table = tables.getJSONObject(i);

            String tableSchema = table.getString("schema");
            String tableName = table.getString("name");

            // Ignore the table if it's not in the "main" schema.
            // Other schemas are SQLite internal and we don't need to expose them.
            if (!tableSchema.equals("main")) {
                continue;
            }

            // Ignore the _cf_KV table.
            // This is a special table used internally by Cloudflare and shouldn't be exposed to the user or queried.
            // Reference: https://x.com/KentonVarda/status/1770241360722846120
            if (tableName.equals("_cf_KV")) {
                continue;
            }

            // sqlite_sequence, sqlite_schema, and sqlite_temp_schema are system tables.
            String tableType = "TABLE";
            if (
                    tableName.equals("sqlite_sequence") ||
                            tableName.equals("sqlite_schema") ||
                            tableName.equals("sqlite_temp_schema")
            ) {
                tableType = "SYSTEM TABLE";
            }

            row.add(null); // TABLE_CAT
            row.add(null); // TABLE_SCHEM
            row.add(tableName); // TABLE_NAME
            row.add(tableType); // TABLE_TYPE
            row.add(null); // REMARKS
            row.add(null); // TYPE_CAT
            row.add(null); // TYPE_SCHEM
            row.add(null); // TYPE_NAME
            row.add(null); // SELF_REFERENCING_COL_NAME
            row.add(null); // REF_GENERATION

            rows.add(row);
        }

        List<JSONObject> columnSchema = Arrays.asList(
                new JSONObject().put("type", "TEXT"), // TABLE_CAT
                new JSONObject().put("type", "TEXT"), // TABLE_SCHEM
                new JSONObject().put("type", "TEXT"), // TABLE_NAME
                new JSONObject().put("type", "TEXT"), // TABLE_TYPE
                new JSONObject().put("type", "TEXT"), // REMARKS
                new JSONObject().put("type", "TEXT"), // TYPE_CAT
                new JSONObject().put("type", "TEXT"), // TYPE_SCHEM
                new JSONObject().put("type", "TEXT"), // TYPE_NAME
                new JSONObject().put("type", "TEXT"), // SELF_REFERENCING_COL_NAME
                new JSONObject().put("type", "TEXT") // REF_GENERATION
        );

        System.out.println("Tables: " + rows);
        return new D1ResultSet(apiToken, accountId, databaseId, rows, columnNames, columnSchema);
    }

    @Override
    public ResultSet getSchemas() throws SQLException {
        return D1ResultSet.empty(
                apiToken, accountId, databaseId,
                Arrays.asList("TABLE_SCHEM", "TABLE_CATALOG"),
                Arrays.asList(
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT")
                )
        );
    }

    @Override
    public ResultSet getCatalogs() throws SQLException {
        return D1ResultSet.empty(
                apiToken, accountId, databaseId,
                Collections.singletonList("TABLE_CAT"),
                Collections.singletonList(
                        new JSONObject().put("type", "TEXT")
                )
        );
    }

    @Override
    public ResultSet getTableTypes() throws SQLException {
        return new D1ResultSet(
                apiToken, accountId, databaseId,
                Arrays.asList(
                        Collections.singletonList("TABLE"),
                        Collections.singletonList("VIEW"),
                        Collections.singletonList("SYSTEM TABLE")
                ),
                Collections.singletonList("TABLE_TYPE"),
                Collections.singletonList(
                        new JSONObject().put("type", "TEXT")
                )
        );
    }

    // Ref: https://github.com/xerial/sqlite-jdbc/blob/master/src/main/java/org/sqlite/jdbc3/JDBC3DatabaseMetaData.java
    protected static final Pattern TYPE_INTEGER = Pattern.compile(".*(INT|BOOL).*");
    protected static final Pattern TYPE_VARCHAR = Pattern.compile(".*(CHAR|CLOB|TEXT|BLOB).*");
    protected static final Pattern TYPE_FLOAT = Pattern.compile(".*(REAL|FLOA|DOUB|DEC|NUM).*");

    @Override
    public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
        if (tableNamePattern.isEmpty()) {
            return null;
        }

        // Names are auto-escaped so unescape them.
        String unescapedName = tableNamePattern.replaceAll("\\\\", "");

        String command = "PRAGMA table_info(" + unescapedName + ")";
        System.out.println("Running introspection for: " + unescapedName);
        System.out.println(command);
        JSONObject json = queryDatabase(command, null);
        JSONArray results = json.getJSONArray("results");

        List<String> columnNames = Arrays.asList(
                "TABLE_CAT",
                "TABLE_SCHEM",
                "TABLE_NAME",
                "COLUMN_NAME",
                "DATA_TYPE",
                "TYPE_NAME",
                "COLUMN_SIZE",
                "BUFFER_LENGTH",
                "DECIMAL_DIGITS",
                "NUM_PREC_RADIX",
                "NULLABLE",
                "REMARKS",
                "COLUMN_DEF",
                "SQL_DATA_TYPE",
                "SQL_DATETIME_SUB",
                "CHAR_OCTET_LENGTH",
                "ORDINAL_POSITION",
                "IS_NULLABLE",
                "SCOPE_CATLOG",
                "SCOPE_SCHEMA",
                "SCOPE_TABLE",
                "SOURCE_DATA_TYPE",
                "IS_AUTOINCREMENT",
                "IS_GENERATEDCOLUMN"
        );

        List<List<Object>> rows = new ArrayList<>();
        for (int i = 0; i < results.length(); i++) {
            JSONObject column = results.getJSONObject(i);
            List<Object> row = new ArrayList<>();

            row.add(null); // TABLE_CAT
            row.add(null); // TABLE_SCHEM
            row.add(unescapedName); // TABLE_NAME
            row.add(column.getString("name")); // COLUMN_NAME

            // DATA_TYPE
            if (TYPE_INTEGER.matcher(column.getString("type")).matches()) {
                row.add(Types.INTEGER);
            } else if (TYPE_VARCHAR.matcher(column.getString("type")).matches()) {
                row.add(Types.VARCHAR);
            } else if (TYPE_FLOAT.matcher(column.getString("type")).matches()) {
                row.add(Types.DOUBLE);
            } else {
                row.add(Types.NUMERIC);
            }

            row.add(column.getString("type")); // TYPE_NAME
            row.add(null); // COLUMN_SIZE
            row.add(null); // BUFFER_LENGTH
            row.add(null); // DECIMAL_DIGITS
            row.add(null); // NUM_PREC_RADIX
            row.add(column.getInt("notnull") == 0 ? columnNullable : columnNoNulls); // NULLABLE
            row.add(null); // REMARKS

            // COLUMN_DEF
            Object columnDef = column.get("dflt_value");
            if (columnDef == JSONObject.NULL) {
                row.add(null);
            } else {
                String type = column.getString("type");
                if (TYPE_INTEGER.matcher(type).matches() || TYPE_FLOAT.matcher(type).matches()) {
                    row.add(columnDef.toString());
                } else {
                    row.add("'" + columnDef.toString() + "'");
                }
            }

            row.add(null); // SQL_DATA_TYPE
            row.add(null); // SQL_DATETIME_SUB
            row.add(null); // CHAR_OCTET_LENGTH
            row.add(i + 1); // ORDINAL_POSITION
            row.add(column.getInt("notnull") == 0 ? "YES" : "NO"); // IS_NULLABLE
            row.add(null); // SCOPE_CATLOG
            row.add(null); // SCOPE_SCHEMA
            row.add(null); // SCOPE_TABLE
            row.add(null); // SOURCE_DATA_TYPE
            row.add(""); // IS_AUTOINCREMENT
            row.add(""); // IS_GENERATEDCOLUMN

            rows.add(row);
        }

        List<JSONObject> columnSchema = Arrays.asList(
                new JSONObject().put("type", "TEXT"), // TABLE_CAT
                new JSONObject().put("type", "TEXT"), // TABLE_SCHEM
                new JSONObject().put("type", "TEXT"), // TABLE_NAME
                new JSONObject().put("type", "TEXT"), // COLUMN_NAME
                new JSONObject().put("type", "INTEGER"), // DATA_TYPE
                new JSONObject().put("type", "TEXT"), // TYPE_NAME
                new JSONObject().put("type", "INTEGER"), // COLUMN_SIZE
                new JSONObject().put("type", "INTEGER"), // BUFFER_LENGTH
                new JSONObject().put("type", "INTEGER"), // DECIMAL_DIGITS
                new JSONObject().put("type", "INTEGER"), // NUM_PREC_RADIX
                new JSONObject().put("type", "INTEGER"), // NULLABLE
                new JSONObject().put("type", "TEXT"), // REMARKS
                new JSONObject().put("type", "TEXT"), // COLUMN_DEF
                new JSONObject().put("type", "INTEGER"), // SQL_DATA_TYPE
                new JSONObject().put("type", "INTEGER"), // SQL_DATETIME_SUB
                new JSONObject().put("type", "INTEGER"), // CHAR_OCTET_LENGTH
                new JSONObject().put("type", "INTEGER"), // ORDINAL_POSITION
                new JSONObject().put("type", "TEXT"), // IS_NULLABLE
                new JSONObject().put("type", "TEXT"), // SCOPE_CATLOG
                new JSONObject().put("type", "TEXT"), // SCOPE_SCHEMA
                new JSONObject().put("type", "TEXT"), // SCOPE_TABLE
                new JSONObject().put("type", "INTEGER"), // SOURCE_DATA_TYPE
                new JSONObject().put("type", "TEXT"), // IS_AUTOINCREMENT
                new JSONObject().put("type", "TEXT") // IS_GENERATEDCOLUMN
        );

        return new D1ResultSet(apiToken, accountId, databaseId, rows, columnNames, columnSchema);
    }

    @Override
    public ResultSet getColumnPrivileges(String catalog, String schema, String table, String columnNamePattern) throws SQLException {
        throw new SQLException("Not implemented: getColumnPrivileges()");
    }

    @Override
    public ResultSet getTablePrivileges(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
        throw new SQLException("Not implemented: getTablePrivileges()");
    }

    @Override
    public ResultSet getBestRowIdentifier(String catalog, String schema, String table, int scope, boolean nullable) throws SQLException {
        throw new SQLException("Not implemented: getBestRowIdentifier()");
    }

    @Override
    public ResultSet getVersionColumns(String catalog, String schema, String table) throws SQLException {
        throw new SQLException("Not implemented: getVersionColumns()");
    }

    @Override
    public ResultSet getPrimaryKeys(String catalog, String schema, String table) throws SQLException {
        JSONObject results = queryDatabase("PRAGMA table_info(" + table + ")", null);
        JSONArray columns = results.getJSONArray("results");

        // Find the column labelled PrimaryKey.
        JSONObject primaryKeyColumn = null;
        for (int i = 0; i < columns.length(); i++) {
            JSONObject column = columns.getJSONObject(i);
            if (column.getInt("pk") == 1) {
                primaryKeyColumn = column;
                break;
            }
        }
        if (primaryKeyColumn == null) {
            return null;
        }

        List<String> columnNames = Arrays.asList(
                "TABLE_CAT",
                "TABLE_SCHEM",
                "TABLE_NAME",
                "COLUMN_NAME",
                "KEY_SEQ",
                "PK_NAME"
        );
        List<List<Object>> rows = Collections.singletonList(
                Arrays.asList(
                        null, // TABLE_CAT
                        null, // TABLE_SCHEM
                        table, // TABLE_NAME
                        primaryKeyColumn.getString("name"), // COLUMN_NAME
                        1, // KEY_SEQ
                        primaryKeyColumn.getString("name") // PK_NAME
                )
        );
        List<JSONObject> columnSchema = Arrays.asList(
                new JSONObject().put("type", "TEXT"), // TABLE_CAT
                new JSONObject().put("type", "TEXT"), // TABLE_SCHEM
                new JSONObject().put("type", "TEXT"), // TABLE_NAME
                new JSONObject().put("type", "TEXT"), // COLUMN_NAME
                new JSONObject().put("type", "INTEGER"), // KEY_SEQ
                new JSONObject().put("type", "TEXT") // PK_NAME
        );

        return new D1ResultSet(apiToken, accountId, databaseId, rows, columnNames, columnSchema);
    }

    @Override
    public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {
        return getCrossReference(null, null, null, catalog, schema, table);
    }

    @Override
    public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {
        return getCrossReference(null, null, null, catalog, schema, table);
    }

    @Override
    public ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable, String foreignCatalog, String foreignSchema, String foreignTable) throws SQLException {
        List<String> columnNames = Arrays.asList(
                "PKTABLE_CAT",
                "PKTABLE_SCHEM",
                "PKTABLE_NAME",
                "PKCOLUMN_NAME",
                "FKTABLE_CAT",
                "FKTABLE_SCHEM",
                "FKTABLE_NAME",
                "FKCOLUMN_NAME",
                "KEY_SEQ",
                "UPDATE_RULE",
                "DELETE_RULE",
                "FK_NAME",
                "PK_NAME"
        );

        List<JSONObject> columnSchema = Arrays.asList(
                new JSONObject().put("type", "TEXT"), // PKTABLE_CAT
                new JSONObject().put("type", "TEXT"), // PKTABLE_SCHEM
                new JSONObject().put("type", "TEXT"), // PKTABLE_NAME
                new JSONObject().put("type", "TEXT"), // PKCOLUMN_NAME
                new JSONObject().put("type", "TEXT"), // FKTABLE_CAT
                new JSONObject().put("type", "TEXT"), // FKTABLE_SCHEM
                new JSONObject().put("type", "TEXT"), // FKTABLE_NAME
                new JSONObject().put("type", "TEXT"), // FKCOLUMN_NAME
                new JSONObject().put("type", "INTEGER"), // KEY_SEQ
                new JSONObject().put("type", "INTEGER"), // UPDATE_RULE
                new JSONObject().put("type", "INTEGER"), // DELETE_RULE
                new JSONObject().put("type", "TEXT"), // FK_NAME
                new JSONObject().put("type", "TEXT") // PK_NAME
        );

        JSONObject stringType = new JSONObject();
        stringType.put("type", "TEXT");
        JSONObject intType = new JSONObject();
        intType.put("type", "INTEGER");

        JSONObject ruleType = new JSONObject();
        ruleType.put("NO ACTION", DatabaseMetaData.importedKeyNoAction);
        ruleType.put("CASCADE", DatabaseMetaData.importedKeyCascade);
        ruleType.put("SET NULL", DatabaseMetaData.importedKeySetNull);
        ruleType.put("SET DEFAULT", DatabaseMetaData.importedKeySetDefault);
        ruleType.put("RESTRICT", DatabaseMetaData.importedKeyRestrict);

        JSONObject results = queryDatabase("PRAGMA foreign_key_list(" + foreignTable + ")", null);
        JSONArray fkList = results.getJSONArray("results");

        List<List<Object>> rows = new ArrayList<>();
        for (int i = 0; i < fkList.length(); i++) {
            JSONObject fkItem = fkList.getJSONObject(i);

            List<Object> row = new ArrayList<>();
            row.add(null); // PKTABLE_CAT
            row.add(null); // PKTABLE_SCHEM
            row.add(fkItem.get("table")); // PKTABLE_NAME
            row.add(fkItem.get("to")); // PKCOLUMN_NAME
            row.add(null); // FKTABLE_CAT
            row.add(null); // FKTABLE_SCHEM
            row.add(foreignTable); // FKTABLE_NAME
            row.add(fkItem.get("from")); // FKCOLUMN_NAME
            row.add(fkItem.get("seq")); // KEY_SEQ
            row.add(ruleType.get(fkItem.get("on_update").toString())); // UPDATE_RULE
            row.add(ruleType.get(fkItem.get("on_delete").toString())); // DELETE_RULE

            // If null is set, #FAKE_<table>_<number> is set, so <foreignTable>_<id>_<seq> set
            row.add(foreignTable + "_" + fkItem.get("id").toString() + "_" + fkItem.get("seq").toString());
            row.add(null);

            rows.add(row);
        }

        return new D1ResultSet(apiToken, accountId, databaseId, rows, columnNames, columnSchema);
    }

    @Override
    public ResultSet getTypeInfo() throws SQLException {
        throw new SQLException("Not implemented: getTypeInfo()");
    }

    @Override
    public ResultSet getIndexInfo(String catalog, String schema, String table, boolean unique, boolean approximate) throws SQLException {
        throw new SQLException("Not implemented: getIndexInfo()");
    }

    @Override
    public boolean supportsResultSetType(int type) throws SQLException {
        return type == ResultSet.TYPE_FORWARD_ONLY;
    }

    @Override
    public boolean supportsResultSetConcurrency(int type, int concurrency) throws SQLException {
        return false;
    }

    @Override
    public boolean ownUpdatesAreVisible(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean ownDeletesAreVisible(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean ownInsertsAreVisible(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean othersUpdatesAreVisible(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean othersDeletesAreVisible(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean othersInsertsAreVisible(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean updatesAreDetected(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean deletesAreDetected(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean insertsAreDetected(int type) throws SQLException {
        return false;
    }

    @Override
    public boolean supportsBatchUpdates() throws SQLException {
        return false;
    }

    @Override
    public ResultSet getUDTs(String catalog, String schemaPattern, String typeNamePattern, int[] types) throws SQLException {
        throw new SQLException("Not implemented: getUDTs()");
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.parentConnection;
    }

    @Override
    public boolean supportsSavepoints() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsNamedParameters() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsMultipleOpenResults() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsGetGeneratedKeys() throws SQLException {
        return false;
    }

    @Override
    public ResultSet getSuperTypes(String catalog, String schemaPattern, String typeNamePattern) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getSuperTables(String catalog, String schemaPattern, String tableNamePattern) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getAttributes(String catalog, String schemaPattern, String typeNamePattern, String attributeNamePattern) throws SQLException {
        return D1ResultSet.empty(
                apiToken, accountId, databaseId,
                Arrays.asList(
                        "TYPE_CAT",
                        "TYPE_SCHEM",
                        "TYPE_NAME",
                        "ATTR_NAME",
                        "DATA_TYPE",
                        "ATTR_TYPE_NAME",
                        "ATTR_SIZE",
                        "DECIMAL_DIGITS",
                        "NUM_PREC_RADIX",
                        "NULLABLE",
                        "REMARKS",
                        "ATTR_DEF",
                        "SQL_DATA_TYPE",
                        "SQL_DATETIME_SUB",
                        "CHAR_OCTET_LENGTH",
                        "ORDINAL_POSITION",
                        "IS_NULLABLE",
                        "SCOPE_CATALOG",
                        "SCOPE_SCHEMA",
                        "SCOPE_TABLE",
                        "SOURCE_DATA_TYPE"
                ),
                Arrays.asList(
                        new JSONObject().put("type", "TEXT"), // TYPE_CAT
                        new JSONObject().put("type", "TEXT"), // TYPE_SCHEM
                        new JSONObject().put("type", "TEXT"), // TYPE_NAME
                        new JSONObject().put("type", "TEXT"), // ATTR_NAME
                        new JSONObject().put("type", "INTEGER"), // DATA_TYPE
                        new JSONObject().put("type", "TEXT"), // ATTR_TYPE_NAME
                        new JSONObject().put("type", "INTEGER"), // ATTR_SIZE
                        new JSONObject().put("type", "INTEGER"), // DECIMAL_DIGITS
                        new JSONObject().put("type", "INTEGER"), // NUM_PREC_RADIX
                        new JSONObject().put("type", "INTEGER"), // NULLABLE
                        new JSONObject().put("type", "TEXT"), // REMARKS
                        new JSONObject().put("type", "TEXT"), // ATTR_DEF
                        new JSONObject().put("type", "INTEGER"), // SQL_DATA_TYPE
                        new JSONObject().put("type", "INTEGER"), // SQL_DATETIME_SUB
                        new JSONObject().put("type", "INTEGER"), // CHAR_OCTET_LENGTH
                        new JSONObject().put("type", "INTEGER"), // ORDINAL_POSITION
                        new JSONObject().put("type", "TEXT"), // IS_NULLABLE
                        new JSONObject().put("type", "TEXT"), // SCOPE_CATALOG
                        new JSONObject().put("type", "TEXT"), // SCOPE_SCHEMA
                        new JSONObject().put("type", "TEXT"), // SCOPE_TABLE
                        new JSONObject().put("type", "INTEGER") // SOURCE_DATA_TYPE
                )
        );
    }

    @Override
    public boolean supportsResultSetHoldability(int holdability) throws SQLException {
        return false;
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return 0;
    }

    @Override
    public int getDatabaseMajorVersion() throws SQLException {
        return 0;
    }

    @Override
    public int getDatabaseMinorVersion() throws SQLException {
        return 0;
    }

    @Override
    public int getJDBCMajorVersion() throws SQLException {
        return 0;
    }

    @Override
    public int getJDBCMinorVersion() throws SQLException {
        return 0;
    }

    @Override
    public int getSQLStateType() throws SQLException {
        return 0;
    }

    @Override
    public boolean locatorsUpdateCopy() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsStatementPooling() throws SQLException {
        return false;
    }

    @Override
    public RowIdLifetime getRowIdLifetime() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
        return D1ResultSet.empty(
                apiToken, accountId, databaseId,
                Arrays.asList("TABLE_SCHEM", "TABLE_CATALOG"),
                Arrays.asList(
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT")
                )
        );
    }

    @Override
    public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public ResultSet getClientInfoProperties() throws SQLException {
        return null;
    }

    @Override
    public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) throws SQLException {
        return D1ResultSet.empty(
                apiToken, accountId, databaseId,
                Arrays.asList(
                        "FUNCTION_CAT",
                        "FUNCTION_SCHEM",
                        "FUNCTION_NAME",
                        "REMARKS",
                        "FUNCTION_TYPE",
                        "SPECIFIC_NAME"
                ),
                Arrays.asList(
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "TEXT")
                )
        );
    }

    @Override
    public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) throws SQLException {
        return D1ResultSet.empty(
                apiToken, accountId, databaseId,
                Arrays.asList(
                        "FUNCTION_CAT",
                        "FUNCTION_SCHEM",
                        "FUNCTION_NAME",
                        "COLUMN_NAME",
                        "COLUMN_TYPE",
                        "DATA_TYPE",
                        "TYPE_NAME",
                        "PRECISION",
                        "LENGTH",
                        "SCALE",
                        "RADIX",
                        "NULLABLE",
                        "REMARKS",
                        "CHAR_OCTET_LENGTH",
                        "ORDINAL_POSITION",
                        "IS_NULLABLE",
                        "SPECIFIC_NAME"
                ),
                Arrays.asList(
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "INTEGER"),
                        new JSONObject().put("type", "TEXT"),
                        new JSONObject().put("type", "TEXT")
                )
        );
    }

    @Override
    public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public boolean generatedKeyAlwaysReturned() throws SQLException {
        throw new SQLFeatureNotSupportedException();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}

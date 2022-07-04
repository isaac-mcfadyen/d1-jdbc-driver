package org.isaacmcfadyen;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.TablesNamesFinder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.sql.Array;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class D1ResultSetMetaData extends D1Queryable implements ResultSetMetaData {
    private final ArrayList<String> columnNames;
    private final ArrayList<ArrayList<Object>> rows;
    private JSONArray columnSchema = new JSONArray();

    D1ResultSetMetaData(
            String ApiKey,
            String AccountId,
            String DatabaseUuid,
            ArrayList<String> columns,
            ArrayList<ArrayList<Object>> rows,
            JSONArray columnSchema
    ) throws SQLException {
        super(ApiKey, AccountId, DatabaseUuid);
        this.columnNames = columns;
        this.rows = rows;
        this.columnSchema = columnSchema;
    }


    @Override
    public int getColumnCount() throws SQLException {
        return columnNames.size();
    }

    @Override
    public boolean isAutoIncrement(int column) throws SQLException {
        // TODO: check for primary key
        return false;
    }

    @Override
    public boolean isCaseSensitive(int column) throws SQLException {
        JSONObject columnSchema = this.columnSchema.getJSONObject(column - 1);
        String columnType = columnSchema.getString("type");
        return columnType.equals("TEXT")
                || columnType.contains("CHAR")
                || columnType.contains("CLOB");
    }

    @Override
    public boolean isSearchable(int column) throws SQLException {
        return true;
    }

    @Override
    public boolean isCurrency(int column) throws SQLException {
        return false;
    }

    @Override
    public int isNullable(int column) throws SQLException {
        JSONObject columnSchema = this.columnSchema.getJSONObject(column - 1);
        return columnSchema.getInt("notnull") == 0 ?
                ResultSetMetaData.columnNullable
                : ResultSetMetaData.columnNoNulls;
    }

    @Override
    public boolean isSigned(int column) throws SQLException {

        JSONObject columnSchema = this.columnSchema.getJSONObject(column - 1);
        String type = columnSchema.getString("type");
        return !Objects.equals(type, "TEXT")
                && !type.contains("CHAR")
                && !type.contains("BLOB")
                && type.length() > 0;
    }

    @Override
    public int getColumnDisplaySize(int column) throws SQLException {
        int longestLength = 0;
        for (ArrayList<Object> row : rows) {
            if (row.get(column).toString().length() > longestLength) {
                longestLength = row.get(column).toString().length();
            }
        }
        return longestLength;
    }

    @Override
    public String getColumnLabel(int column) throws SQLException {
        return columnNames.get(column - 1);
    }

    @Override
    public String getColumnName(int column) throws SQLException {
        return columnNames.get(column - 1);
    }

    @Override
    public String getSchemaName(int column) throws SQLException {
        return null;
    }

    @Override
    public int getPrecision(int column) throws SQLException {
        return 0;
    }

    @Override
    public int getScale(int column) throws SQLException {
        ArrayList<Object> row = rows.get(0);
        Object value = row.get(column - 1);
        Type type = value.getClass();

        if (type == Double.class) {
            return value.toString().split("\\.")[1].length();
        } else {
            return 0;
        }
    }

    @Override
    public String getTableName(int column) throws SQLException {
        return null;
    }

    @Override
    public String getCatalogName(int column) throws SQLException {
        return null;
    }

    @Override
    public int getColumnType(int column) throws SQLException {
        JSONObject columnSchema = this.columnSchema.getJSONObject(column - 1);
        String type = columnSchema.getString("type");

        if (type.contains("CHAR") || type.contains("CLOB") || type.contains("TEXT")) {
            return Types.VARCHAR;
        } else if (type.contains("INT")) {
            return Types.INTEGER;
        } else if (type.contains("REAL") || type.contains("DOB") || type.contains("FLOA")) {
            return Types.DOUBLE;
        } else if (type.contains("BLOB") || type.length() == 0) {
            return Types.BLOB;
        } else {
            return Types.NUMERIC;
        }
    }

    @Override
    public String getColumnTypeName(int column) throws SQLException {
        JSONObject columnSchema = this.columnSchema.getJSONObject(column - 1);
        return columnSchema.getString("type");
    }

    @Override
    public boolean isReadOnly(int column) throws SQLException {
        return false;
    }

    @Override
    public boolean isWritable(int column) throws SQLException {
        return true;
    }

    @Override
    public boolean isDefinitelyWritable(int column) throws SQLException {
        return true;
    }

    @Override
    public String getColumnClassName(int column) throws SQLException {
        throw new SQLException("Not implemented: getColumnClassName(int column)");
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

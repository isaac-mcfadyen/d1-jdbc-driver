package org.isaacmcfadyen;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return String.format("jbdc:d1://%s", DatabaseUuid);
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
        return "Cloudflare D1";
    }

    @Override
    public String getDatabaseProductVersion() throws SQLException {
        return null;
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
        return false;
    }

    @Override
    public boolean usesLocalFilePerTable() throws SQLException {
        return false;
    }

    @Override
    public boolean supportsMixedCaseIdentifiers() throws SQLException {
        return false;
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
        throw new SQLException("Not implemented: getTimeDateFunctions()");
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
        return null;
    }

    @Override
    public String getProcedureTerm() throws SQLException {
        return "Procedure";
    }

    @Override
    public String getCatalogTerm() throws SQLException {
        return null;
    }

    @Override
    public boolean isCatalogAtStart() throws SQLException {
        return false;
    }

    @Override
    public String getCatalogSeparator() throws SQLException {
        throw new SQLException("Not implemented: getCatalogSeparator()");
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
        JSONObject json = queryDatabase("PRAGMA table_list");
        JSONArray tables = json.getJSONArray("results");

        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<ArrayList<Object>> rows = new ArrayList<>();

        // Define the preset columns.
        columnNames.add("TABLE_CAT");
        columnNames.add("TABLE_SCHEM");
        columnNames.add("TABLE_NAME");
        columnNames.add("TABLE_TYPE");

        for (int i = 0; i < tables.length(); i++) {
            ArrayList<Object> row = new ArrayList<>();
            JSONObject table = tables.getJSONObject(i);

            String tableCatalog = null;
            String tableSchema = table.getString("schema");
            String tableName = table.getString("name");
            String tableType = table.getString("type");

            row.add(tableCatalog);
            row.add(tableSchema);
            row.add(tableName);
            row.add(tableType);

            rows.add(row);
        }

        JSONObject stringType = new JSONObject();
        stringType.put("type", "TEXT");
        JSONArray columnSchema = new JSONArray();
        columnSchema.put(stringType);
        columnSchema.put(stringType);
        columnSchema.put(stringType);
        columnSchema.put(stringType);

        return new D1ResultSet(ApiKey, AccountId, DatabaseUuid, columnNames, rows, columnSchema);
    }

    @Override
    public ResultSet getSchemas() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<ArrayList<Object>> rows = new ArrayList<>();

        columnNames.add("TABLE_SCHEM");
        columnNames.add("TABLE_CATALOG");

        ArrayList<Object> row = new ArrayList<>();
        row.add(null);
        row.add(null);
        rows.add(row);

        JSONObject stringType = new JSONObject();
        stringType.put("type", "TEXT");
        JSONArray columnSchema = new JSONArray();
        columnSchema.put(stringType);
        columnSchema.put(stringType);

        return new D1ResultSet(ApiKey, AccountId, DatabaseUuid, columnNames, rows, columnSchema);
    }

    @Override
    public ResultSet getCatalogs() throws SQLException {
        return null;
    }

    @Override
    public ResultSet getTableTypes() throws SQLException {
        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<ArrayList<Object>> rows = new ArrayList<>();

        columnNames.add("TABLE_TYPE");
        ArrayList<Object> row = new ArrayList<>();
        row.add("TABLE");
        rows.add(row);

        JSONObject stringType = new JSONObject();
        stringType.put("type", "TEXT");
        JSONArray columnSchema = new JSONArray();
        columnSchema.put(stringType);

        return new D1ResultSet(ApiKey, AccountId, DatabaseUuid, columnNames, rows, columnSchema);
    }

    @Override
    public ResultSet getColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
        if(tableNamePattern.length() == 0) {
            return null;
        }
        System.out.println(tableNamePattern);
        System.out.println("PRAGMA table_info(" + tableNamePattern.replaceAll("\\\\", "") + ")");
        String command = "PRAGMA table_info(" + tableNamePattern.replaceAll("\\\\", "") + ")";
        JSONObject json = queryDatabase(command);
        JSONArray results = json.getJSONArray("results");

        ArrayList<String> columnNames = new ArrayList<>();
        ArrayList<ArrayList<Object>> rows = new ArrayList<>();

        columnNames.add("TABLE_CAT");
        columnNames.add("TABLE_SCHEM");
        columnNames.add("TABLE_NAME");
        columnNames.add("COLUMN_NAME");
        columnNames.add("DATA_TYPE");
        columnNames.add("TYPE_NAME");
        columnNames.add("COLUMN_SIZE");
        columnNames.add("BUFFER_LENGTH");
        columnNames.add("DECIMAL_DIGITS");
        columnNames.add("NUM_PREC_RADIX");
        columnNames.add("NULLABLE");
        columnNames.add("REMARKS");
        columnNames.add("COLUMN_DEF");
        columnNames.add("SQL_DATA_TYPE");
        columnNames.add("SQL_DATETIME_SUB");
        columnNames.add("CHAR_OCTET_LENGTH");
        columnNames.add("ORDINAL_POSITION");
        columnNames.add("IS_NULLABLE");
        columnNames.add("SCOPE_CATLOG");
        columnNames.add("SCOPE_SCHEMA");
        columnNames.add("SCOPE_TABLE");
        columnNames.add("SOURCE_DATA_TYPE");
        columnNames.add("IS_AUTOINCREMENT");
        columnNames.add("IS_GENERATEDCOLUMN");

        for (int i = 0; i < results.length(); i++) {
            JSONObject column = results.getJSONObject(i);
            ArrayList<Object> row = new ArrayList<>();

            // TABLE_CAT
            row.add(null);
            // TABLE_SCHEM
            row.add(null);
            // TABLE_NAME
            row.add(tableNamePattern);
            // COLUMN_NAME
            row.add(column.getString("name"));
            // DATA_TYPE
            String type = column.getString("type");
            if (type.contains("CHAR") || type.contains("CLOB") || type.contains("TEXT")) {
                row.add(Types.VARCHAR);
            } else if (type.contains("INT")) {
                row.add(Types.INTEGER);
            } else if (type.contains("REAL") || type.contains("DOB") || type.contains("FLOA")) {
                row.add(Types.DOUBLE);
            } else if (type.contains("BLOB") || type.length() == 0) {
                row.add(Types.BLOB);
            } else {
                row.add(Types.NUMERIC);
            }
            // TYPE_NAME
            row.add(column.getString("type"));
            // COLUMN_SIZE
            row.add(null);
            // BUFFER_LENGTH
            row.add(null);
            // DECIMAL_DIGITS
            row.add(null);
            // NUM_PREC_RADIX
            row.add(null);
            // NULLABLE
            row.add(column.getInt("notnull") == 0 ? columnNullable : columnNoNulls);
            // REMARKS
            row.add(null);
            // COLUMN_DEF
            Object columnDef = column.get("dflt_value");
            if (columnDef == JSONObject.NULL) {
                row.add(null);
            } else {
                if(type.contains("REAL") || type.contains("DOB") || type.contains("FLOA") || type.contains("INT")) {
                    row.add(columnDef.toString());
                } else {
                    row.add("'" + columnDef.toString() + "'");
                }
            }
            // SQL_DATA_TYPE
            row.add(null);
            // SQL_DATETIME_SUB
            row.add(null);
            // CHAR_OCTET_LENGTH
            row.add(null);
            // ORDINAL_POSITION
            row.add(i + 1);
            // IS_NULLABLE
            row.add(column.getInt("notnull") == 0 ? "YES" : "NO");
            // SCOPE_CATLOG
            row.add(null);
            // SCOPE_SCHEMA
            row.add(null);
            // SCOPE_TABLE
            row.add(null);
            // SOURCE_DATA_TYPE
            row.add(null);
            // IS_AUTOINCREMENT
            row.add("");
            // IS_GENERATEDCOLUMN
            row.add("");

            rows.add(row);
        }

        JSONObject stringType = new JSONObject();
        stringType.put("type", "TEXT");
        JSONObject intType = new JSONObject();
        intType.put("type", "INTEGER");

        JSONArray columnSchema = new JSONArray();
        // TABLE_CAT
        columnSchema.put(stringType);
        // TABLE_SCHEM
        columnSchema.put(stringType);
        // TABLE_NAME
        columnSchema.put(stringType);
        // COLUMN_NAME
        columnSchema.put(stringType);
        // DATA_TYPE
        columnSchema.put(intType);
        // TYPE_NAME
        columnSchema.put(stringType);
        // COLUMN_SIZE
        columnSchema.put(intType);
        // BUFFER_LENGTH
        columnSchema.put(intType);
        // DECIMAL_DIGITS
        columnSchema.put(intType);
        // NUM_PREC_RADIX
        columnSchema.put(intType);
        // NULLABLE
        columnSchema.put(intType);
        // REMARKS
        columnSchema.put(stringType);
        // COLUMN_DEF
        columnSchema.put(stringType);
        // SQL_DATA_TYPE
        columnSchema.put(intType);
        // SQL_DATETIME_SUB
        columnSchema.put(intType);
        // CHAR_OCTET_LENGTH
        columnSchema.put(intType);
        // ORDINAL_POSITION
        columnSchema.put(intType);
        // IS_NULLABLE
        columnSchema.put(stringType);
        // SCOPE_CATLOG
        columnSchema.put(stringType);
        // SCOPE_SCHEMA
        columnSchema.put(stringType);
        // SCOPE_TABLE
        columnSchema.put(stringType);
        // SOURCE_DATA_TYPE
        columnSchema.put(intType);
        // IS_AUTOINCREMENT
        columnSchema.put(stringType);
        // IS_GENERATEDCOLUMN
        columnSchema.put(stringType);

        return new D1ResultSet(ApiKey, AccountId, DatabaseUuid, columnNames, rows, columnSchema);
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
        JSONObject results = queryDatabase("PRAGMA table_info(" + table + ")");
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

        if(primaryKeyColumn == null) {
            return null;
        }

        ArrayList<String> columnNames = new ArrayList<>();
        columnNames.add("TABLE_CAT");
        columnNames.add("TABLE_SCHEM");
        columnNames.add("TABLE_NAME");
        columnNames.add("COLUMN_NAME");
        columnNames.add("KEY_SEQ");
        columnNames.add("PK_NAME");

        ArrayList<ArrayList<Object>> rows = new ArrayList<>();
        ArrayList<Object> row = new ArrayList<>();
        row.add(null);
        row.add(null);
        row.add(table);
        row.add(primaryKeyColumn.getString("name"));
        row.add(1);
        row.add(primaryKeyColumn.getString("name"));
        rows.add(row);

        JSONObject stringType = new JSONObject();
        stringType.put("type", "TEXT");
        JSONObject intType = new JSONObject();
        intType.put("type", "INTEGER");

        JSONArray columnSchema = new JSONArray();
        // TABLE_CAT
        columnSchema.put(stringType);
        // TABLE_SCHEM
        columnSchema.put(stringType);
        // TABLE_NAME
        columnSchema.put(stringType);
        // COLUMN_NAME
        columnSchema.put(stringType);
        // KEY_SEQ
        columnSchema.put(intType);
        // PK_NAME
        columnSchema.put(stringType);

        return new D1ResultSet(ApiKey, AccountId, DatabaseUuid, columnNames, rows, columnSchema);
    }

    @Override
    public ResultSet getImportedKeys(String catalog, String schema, String table) throws SQLException {
        throw new SQLException("Not implemented: getImportedKeys()");
    }

    @Override
    public ResultSet getExportedKeys(String catalog, String schema, String table) throws SQLException {
        throw new SQLException("Not implemented: getExportedKeys()");
    }

    @Override
    public ResultSet getCrossReference(String parentCatalog, String parentSchema, String parentTable, String foreignCatalog, String foreignSchema, String foreignTable) throws SQLException {
        throw new SQLException("Not implemented: getCrossReference()");
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
        return false;
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
        return null;
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
        return null;
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
        return null;
    }

    @Override
    public ResultSet getSchemas(String catalog, String schemaPattern) throws SQLException {
        return null;
    }

    @Override
    public boolean supportsStoredFunctionsUsingCallSyntax() throws SQLException {
        return false;
    }

    @Override
    public boolean autoCommitFailureClosesAllResultSets() throws SQLException {
        return false;
    }

    @Override
    public ResultSet getClientInfoProperties() throws SQLException {
        return null;
    }

    @Override
    public ResultSet getFunctions(String catalog, String schemaPattern, String functionNamePattern) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getFunctionColumns(String catalog, String schemaPattern, String functionNamePattern, String columnNamePattern) throws SQLException {
        return null;
    }

    @Override
    public ResultSet getPseudoColumns(String catalog, String schemaPattern, String tableNamePattern, String columnNamePattern) throws SQLException {
        return null;
    }

    @Override
    public boolean generatedKeyAlwaysReturned() throws SQLException {
        return false;
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

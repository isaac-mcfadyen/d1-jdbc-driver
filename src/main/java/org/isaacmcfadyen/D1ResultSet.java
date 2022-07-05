package org.isaacmcfadyen;

import org.json.JSONObject;
import org.json.JSONArray;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

public class D1ResultSet extends D1Queryable implements java.sql.ResultSet {
    private boolean closed = false;
    private final ArrayList<String> columnNames = new ArrayList<>();
    private final ArrayList<ArrayList<Object>> rows = new ArrayList<>();
    private int currentRow = 0;

    private final JSONArray columnSchema;

    D1ResultSet(
            String ApiKey,
            String AccountId,
            String DatabaseUuid,
            ArrayList<String> columnNames,
            ArrayList<ArrayList<Object>> rows,
            JSONArray columnSchema
    ) {
        super(ApiKey, AccountId, DatabaseUuid);
        this.columnNames.addAll(columnNames);
        this.rows.addAll(rows);
        this.columnSchema = columnSchema;
    }

    @Override
    public boolean next() throws SQLException {
        if (currentRow >= rows.size()) {
            return false;
        }
        currentRow++;
        return true;
    }

    @Override
    public void close() throws SQLException {
        synchronized (this) {
            closed = true;
        }
    }

    @Override
    public boolean wasNull() throws SQLException {
        return false;
    }

    @Override
    public String getString(int columnIndex) throws SQLException {
        if (!JSONObject.NULL.equals(rows.get(currentRow - 1).get(columnIndex - 1))) {
            return (String) rows.get(currentRow - 1).get(columnIndex - 1);
        } else {
            return null;
        }
    }

    @Override
    public boolean getBoolean(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getBoolean(int columnIndex)");
    }

    @Override
    public byte getByte(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getByte(int columnIndex)");
    }

    @Override
    public short getShort(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getShort(int columnIndex)");
    }

    @Override
    public int getInt(int columnIndex) throws SQLException {
        if (!JSONObject.NULL.equals(rows.get(currentRow - 1).get(columnIndex - 1))) {
            return (int) rows.get(currentRow - 1).get(columnIndex - 1);
        } else {
            return 0;
        }
    }

    @Override
    public long getLong(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getLong(int columnIndex)");
    }

    @Override
    public float getFloat(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getFloat(int columnIndex)");
    }

    @Override
    public double getDouble(int columnIndex) throws SQLException {
        if (!JSONObject.NULL.equals(rows.get(currentRow - 1).get(columnIndex - 1))) {
            return (double) rows.get(currentRow - 1).get(columnIndex - 1);
        } else {
            return 0;
        }
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex, int scale) throws SQLException {
        throw new SQLException("Not implemented: getBigDecimal(int columnIndex, int scale)");
    }

    @Override
    public byte[] getBytes(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getBytes(int columnIndex)");
    }

    @Override
    public Date getDate(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getDate(int columnIndex)");
    }

    @Override
    public Time getTime(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getTime(int columnIndex)");
    }

    @Override
    public Timestamp getTimestamp(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getTimestamp(int columnIndex)");
    }

    @Override
    public InputStream getAsciiStream(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getAsciiStream(int columnIndex)");
    }

    @Override
    public InputStream getUnicodeStream(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getUnicodeStream(int columnIndex)");
    }

    @Override
    public InputStream getBinaryStream(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getBinaryStream(int columnIndex)");
    }

    @Override
    public String getString(String columnLabel) throws SQLException {
        if (!JSONObject.NULL.equals(rows.get(currentRow - 1).get(columnNames.indexOf(columnLabel)))) {
            return (String) rows.get(currentRow - 1).get(columnNames.indexOf(columnLabel));
        } else {
            return null;
        }
    }

    @Override
    public boolean getBoolean(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getBoolean(String columnLabel)");
    }

    @Override
    public byte getByte(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getByte(String columnLabel)");
    }

    @Override
    public short getShort(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getShort(String columnLabel)");
    }

    @Override
    public int getInt(String columnLabel) throws SQLException {
        if (!JSONObject.NULL.equals(rows.get(currentRow - 1).get(columnNames.indexOf(columnLabel)))) {
            return (int) rows.get(currentRow - 1).get(columnNames.indexOf(columnLabel));
        } else {
            return 0;
        }
    }

    @Override
    public long getLong(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getLong(String columnLabel)");
    }

    @Override
    public float getFloat(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getFloat(String columnLabel)");
    }

    @Override
    public double getDouble(String columnLabel) throws SQLException {
        if (!JSONObject.NULL.equals(rows.get(currentRow - 1).get(columnNames.indexOf(columnLabel)))) {
            return (double) rows.get(currentRow - 1).get(columnNames.indexOf(columnLabel));
        } else {
            return 0;
        }
    }

    @Override
    public BigDecimal getBigDecimal(String columnLabel, int scale) throws SQLException {
        throw new SQLException("Not implemented: getBigDecimal(String columnLabel, int scale)");
    }

    @Override
    public byte[] getBytes(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getBytes(String columnLabel)");
    }

    @Override
    public Date getDate(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getDate(String columnLabel)");
    }

    @Override
    public Time getTime(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getTime(String columnLabel)");
    }

    @Override
    public Timestamp getTimestamp(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getTimestamp(String columnLabel)");
    }

    @Override
    public InputStream getAsciiStream(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getAsciiStream(String columnLabel)");
    }

    @Override
    public InputStream getUnicodeStream(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getUnicodeStream(String columnLabel)");
    }

    @Override
    public InputStream getBinaryStream(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getBinaryStream(String columnLabel)");
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        throw new SQLException("Not implemented: getWarnings()");
    }

    @Override
    public void clearWarnings() throws SQLException {
        throw new SQLException("Not implemented: clearWarnings()");
    }

    @Override
    public String getCursorName() throws SQLException {
        throw new SQLException("Not implemented: getCursorName()");
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return new D1ResultSetMetaData(ApiKey, AccountId, DatabaseUuid, columnNames, rows, columnSchema);
    }

    @Override
    public Object getObject(int columnIndex) throws SQLException {
        ArrayList<Object> row = rows.get(currentRow - 1);
        return row.get(columnIndex - 1);
    }

    @Override
    public Object getObject(String columnLabel) throws SQLException {
        ArrayList<Object> row = rows.get(currentRow - 1);
        return row.get(columnNames.indexOf(columnLabel));
    }

    @Override
    public int findColumn(String columnLabel) throws SQLException {
        return columnNames.indexOf(columnLabel) + 1;
    }

    @Override
    public Reader getCharacterStream(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getCharacterStream(int columnIndex)");
    }

    @Override
    public Reader getCharacterStream(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getCharacterStream(String columnLabel)");
    }

    @Override
    public BigDecimal getBigDecimal(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getBigDecimal(int columnIndex)");
    }

    @Override
    public BigDecimal getBigDecimal(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getBigDecimal(String columnLabel)");
    }

    @Override
    public boolean isBeforeFirst() throws SQLException {
        return currentRow <= 0;
    }

    @Override
    public boolean isAfterLast() throws SQLException {
        return currentRow >= rows.size() + 1;
    }

    @Override
    public boolean isFirst() throws SQLException {
        return currentRow == 1;
    }

    @Override
    public boolean isLast() throws SQLException {
        return currentRow == rows.size();
    }

    @Override
    public void beforeFirst() throws SQLException {
        currentRow = 0;
    }

    @Override
    public void afterLast() throws SQLException {
        currentRow = rows.size() + 1;
    }

    @Override
    public boolean first() throws SQLException {
        if (rows.size() > 0) {
            currentRow = 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean last() throws SQLException {
        if (rows.size() > 0) {
            currentRow = rows.size();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getRow() throws SQLException {
        return currentRow;
    }

    @Override
    public boolean absolute(int row) throws SQLException {
        if (row > 0 && row <= rows.size()) {
            currentRow = row;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean relative(int rows) throws SQLException {
        if (currentRow + rows > 0 && currentRow + rows <= this.rows.size()) {
            currentRow += rows;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean previous() throws SQLException {
        throw new SQLException("Not implemented: previous()");
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        throw new SQLException("Not implemented: setFetchDirection(int direction)");
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return ResultSet.FETCH_FORWARD;
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        throw new SQLException("Not implemented: setFetchSize(int rows)");
    }

    @Override
    public int getFetchSize() throws SQLException {
        return 0;
    }

    @Override
    public int getType() throws SQLException {
        return ResultSet.TYPE_FORWARD_ONLY;
    }

    @Override
    public int getConcurrency() throws SQLException {
        throw new SQLException("Not implemented: getConcurrency()");
    }

    @Override
    public boolean rowUpdated() throws SQLException {
        throw new SQLException("Not implemented: rowUpdated()");
    }

    @Override
    public boolean rowInserted() throws SQLException {
        throw new SQLException("Not implemented: rowInserted()");
    }

    @Override
    public boolean rowDeleted() throws SQLException {
        throw new SQLException("Not implemented: rowDeleted()");
    }

    @Override
    public void updateNull(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: updateNull(int columnIndex)");
    }

    @Override
    public void updateBoolean(int columnIndex, boolean x) throws SQLException {
        throw new SQLException("Not implemented: updateBoolean(int columnIndex, boolean x)");
    }

    @Override
    public void updateByte(int columnIndex, byte x) throws SQLException {
        throw new SQLException("Not implemented: updateByte(int columnIndex, byte x)");
    }

    @Override
    public void updateShort(int columnIndex, short x) throws SQLException {
        throw new SQLException("Not implemented: updateShort(int columnIndex, short x)");
    }

    @Override
    public void updateInt(int columnIndex, int x) throws SQLException {
        throw new SQLException("Not implemented: updateInt(int columnIndex, int x)");
    }

    @Override
    public void updateLong(int columnIndex, long x) throws SQLException {
        throw new SQLException("Not implemented: updateLong(int columnIndex, long x)");
    }

    @Override
    public void updateFloat(int columnIndex, float x) throws SQLException {
        throw new SQLException("Not implemented: updateFloat(int columnIndex, float x)");
    }

    @Override
    public void updateDouble(int columnIndex, double x) throws SQLException {
        throw new SQLException("Not implemented: updateDouble(int columnIndex, double x)");
    }

    @Override
    public void updateBigDecimal(int columnIndex, BigDecimal x) throws SQLException {
        throw new SQLException("Not implemented: updateBigDecimal(int columnIndex, BigDecimal x)");
    }

    @Override
    public void updateString(int columnIndex, String x) throws SQLException {
        throw new SQLException("Not implemented: updateString(int columnIndex, String x)");
    }

    @Override
    public void updateBytes(int columnIndex, byte[] x) throws SQLException {
        throw new SQLException("Not implemented: updateBytes(int columnIndex, byte[] x)");
    }

    @Override
    public void updateDate(int columnIndex, Date x) throws SQLException {
        throw new SQLException("Not implemented: updateDate(int columnIndex, Date x)");
    }

    @Override
    public void updateTime(int columnIndex, Time x) throws SQLException {
        throw new SQLException("Not implemented: updateTime(int columnIndex, Time x)");
    }

    @Override
    public void updateTimestamp(int columnIndex, Timestamp x) throws SQLException {
        throw new SQLException("Not implemented: updateTimestamp(int columnIndex, Timestamp x)");
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, int length) throws SQLException {
        throw new SQLException("Not implemented: updateAsciiStream(int columnIndex, InputStream x, int length)");
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, int length) throws SQLException {
        throw new SQLException("Not implemented: updateBinaryStream(int columnIndex, InputStream x, int length)");
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, int length) throws SQLException {
        throw new SQLException("Not implemented: updateCharacterStream(int columnIndex, Reader x, int length)");
    }

    @Override
    public void updateObject(int columnIndex, Object x, int scaleOrLength) throws SQLException {
        throw new SQLException("Not implemented: updateObject(int columnIndex, Object x, int scaleOrLength)");
    }

    @Override
    public void updateObject(int columnIndex, Object x) throws SQLException {
        throw new SQLException("Not implemented: updateObject(int columnIndex, Object x)");
    }

    @Override
    public void updateNull(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: updateNull(String columnLabel)");
    }

    @Override
    public void updateBoolean(String columnLabel, boolean x) throws SQLException {
        throw new SQLException("Not implemented: updateBoolean(String columnLabel, boolean x)");
    }

    @Override
    public void updateByte(String columnLabel, byte x) throws SQLException {
        throw new SQLException("Not implemented: updateByte(String columnLabel, byte x)");
    }

    @Override
    public void updateShort(String columnLabel, short x) throws SQLException {
        throw new SQLException("Not implemented: updateShort(String columnLabel, short x)");
    }

    @Override
    public void updateInt(String columnLabel, int x) throws SQLException {
        throw new SQLException("Not implemented: updateInt(String columnLabel, int x)");
    }

    @Override
    public void updateLong(String columnLabel, long x) throws SQLException {
        throw new SQLException("Not implemented: updateLong(String columnLabel, long x)");
    }

    @Override
    public void updateFloat(String columnLabel, float x) throws SQLException {
        throw new SQLException("Not implemented: updateFloat(String columnLabel, float x)");
    }

    @Override
    public void updateDouble(String columnLabel, double x) throws SQLException {
        throw new SQLException("Not implemented: updateDouble(String columnLabel, double x)");
    }

    @Override
    public void updateBigDecimal(String columnLabel, BigDecimal x) throws SQLException {
        throw new SQLException("Not implemented: updateBigDecimal(String columnLabel, BigDecimal x)");
    }

    @Override
    public void updateString(String columnLabel, String x) throws SQLException {
        throw new SQLException("Not implemented: updateString(String columnLabel, String x)");
    }

    @Override
    public void updateBytes(String columnLabel, byte[] x) throws SQLException {
        throw new SQLException("Not implemented: updateBytes(String columnLabel, byte[] x)");
    }

    @Override
    public void updateDate(String columnLabel, Date x) throws SQLException {
        throw new SQLException("Not implemented: updateDate(String columnLabel, Date x)");
    }

    @Override
    public void updateTime(String columnLabel, Time x) throws SQLException {
        throw new SQLException("Not implemented: updateTime(String columnLabel, Time x)");
    }

    @Override
    public void updateTimestamp(String columnLabel, Timestamp x) throws SQLException {
        throw new SQLException("Not implemented: updateTimestamp(String columnLabel, Timestamp x)");
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x, int length) throws SQLException {
        throw new SQLException("Not implemented: updateAsciiStream(String columnLabel, InputStream x, int length)");
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x, int length) throws SQLException {
        throw new SQLException("Not implemented: updateBinaryStream(String columnLabel, InputStream x, int length)");
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader, int length) throws SQLException {
        throw new SQLException("Not implemented: updateCharacterStream(String columnLabel, Reader reader, int length)");
    }

    @Override
    public void updateObject(String columnLabel, Object x, int scaleOrLength) throws SQLException {
        throw new SQLException("Not implemented: updateObject(String columnLabel, Object x, int scaleOrLength)");
    }

    @Override
    public void updateObject(String columnLabel, Object x) throws SQLException {
        throw new SQLException("Not implemented: updateObject(String columnLabel, Object x)");
    }

    @Override
    public void insertRow() throws SQLException {
        throw new SQLException("Not implemented: insertRow()");
    }

    @Override
    public void updateRow() throws SQLException {
        throw new SQLException("Not implemented: updateRow()");
    }

    @Override
    public void deleteRow() throws SQLException {
        throw new SQLException("Not implemented: deleteRow()");
    }

    @Override
    public void refreshRow() throws SQLException {
        throw new SQLException("Not implemented: refreshRow()");
    }

    @Override
    public void cancelRowUpdates() throws SQLException {
        throw new SQLException("Not implemented: cancelRowUpdates()");
    }

    @Override
    public void moveToInsertRow() throws SQLException {
        throw new SQLException("Not implemented: moveToInsertRow()");
    }

    @Override
    public void moveToCurrentRow() throws SQLException {
        throw new SQLException("Not implemented: moveToCurrentRow()");
    }

    @Override
    public Statement getStatement() throws SQLException {
        throw new SQLException("Not implemented: getStatement()");
    }

    @Override
    public Object getObject(int columnIndex, Map<String, Class<?>> map) throws SQLException {
        throw new SQLException("Not implemented: getObject(int columnIndex, Map<String, Class<?>> map)");
    }

    @Override
    public Ref getRef(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getRef(int columnIndex)");
    }

    @Override
    public Blob getBlob(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getBlob(int columnIndex)");
    }

    @Override
    public Clob getClob(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getClob(int columnIndex)");
    }

    @Override
    public Array getArray(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getArray(int columnIndex)");
    }

    @Override
    public Object getObject(String columnLabel, Map<String, Class<?>> map) throws SQLException {
        throw new SQLException("Not implemented: getObject(String columnLabel, Map<String, Class<?>> map)");
    }

    @Override
    public Ref getRef(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getRef(String columnLabel)");
    }

    @Override
    public Blob getBlob(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getBlob(String columnLabel)");
    }

    @Override
    public Clob getClob(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getClob(String columnLabel)");
    }

    @Override
    public Array getArray(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getArray(String columnLabel)");
    }

    @Override
    public Date getDate(int columnIndex, Calendar cal) throws SQLException {
        throw new SQLException("Not implemented: getDate(int columnIndex, Calendar cal)");
    }

    @Override
    public Date getDate(String columnLabel, Calendar cal) throws SQLException {
        throw new SQLException("Not implemented: getDate(String columnLabel, Calendar cal)");
    }

    @Override
    public Time getTime(int columnIndex, Calendar cal) throws SQLException {
        throw new SQLException("Not implemented: getTime(int columnIndex, Calendar cal)");
    }

    @Override
    public Time getTime(String columnLabel, Calendar cal) throws SQLException {
        throw new SQLException("Not implemented: getTime(String columnLabel, Calendar cal)");
    }

    @Override
    public Timestamp getTimestamp(int columnIndex, Calendar cal) throws SQLException {
        throw new SQLException("Not implemented: getTimestamp(int columnIndex, Calendar cal)");
    }

    @Override
    public Timestamp getTimestamp(String columnLabel, Calendar cal) throws SQLException {
        throw new SQLException("Not implemented: getTimestamp(String columnLabel, Calendar cal)");
    }

    @Override
    public URL getURL(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getURL(int columnIndex)");
    }

    @Override
    public URL getURL(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getURL(String columnLabel)");
    }

    @Override
    public void updateRef(int columnIndex, Ref x) throws SQLException {
        throw new SQLException("Not implemented: updateRef(int columnIndex, Ref x)");
    }

    @Override
    public void updateRef(String columnLabel, Ref x) throws SQLException {
        throw new SQLException("Not implemented: updateRef(String columnLabel, Ref x)");
    }

    @Override
    public void updateBlob(int columnIndex, Blob x) throws SQLException {
        throw new SQLException("Not implemented: updateBlob(int columnIndex, Blob x)");
    }

    @Override
    public void updateBlob(String columnLabel, Blob x) throws SQLException {
        throw new SQLException("Not implemented: updateBlob(String columnLabel, Blob x)");
    }

    @Override
    public void updateClob(int columnIndex, Clob x) throws SQLException {
        throw new SQLException("Not implemented: updateClob(int columnIndex, Clob x)");
    }

    @Override
    public void updateClob(String columnLabel, Clob x) throws SQLException {
        throw new SQLException("Not implemented: updateClob(String columnLabel, Clob x)");
    }

    @Override
    public void updateArray(int columnIndex, Array x) throws SQLException {
        throw new SQLException("Not implemented: updateArray(int columnIndex, Array x)");
    }

    @Override
    public void updateArray(String columnLabel, Array x) throws SQLException {
        throw new SQLException("Not implemented: updateArray(String columnLabel, Array x)");
    }

    @Override
    public RowId getRowId(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getRowId(int columnIndex)");
    }

    @Override
    public RowId getRowId(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getRowId(String columnLabel)");
    }

    @Override
    public void updateRowId(int columnIndex, RowId x) throws SQLException {
        throw new SQLException("Not implemented: updateRowId(int columnIndex, RowId x)");
    }

    @Override
    public void updateRowId(String columnLabel, RowId x) throws SQLException {
        throw new SQLException("Not implemented: updateRowId(String columnLabel, RowId x)");
    }

    @Override
    public int getHoldability() throws SQLException {
        throw new SQLException("Not implemented: getHoldability()");
    }

    @Override
    public boolean isClosed() throws SQLException {
        return closed;
    }

    @Override
    public void updateNString(int columnIndex, String nString) throws SQLException {
        throw new SQLException("Not implemented: updateNString(int columnIndex, String nString)");
    }

    @Override
    public void updateNString(String columnLabel, String nString) throws SQLException {
        throw new SQLException("Not implemented: updateNString(String columnLabel, String nString)");
    }

    @Override
    public void updateNClob(int columnIndex, NClob nClob) throws SQLException {
        throw new SQLException("Not implemented: updateNClob(int columnIndex, NClob nClob)");
    }

    @Override
    public void updateNClob(String columnLabel, NClob nClob) throws SQLException {
        throw new SQLException("Not implemented: updateNClob(String columnLabel, NClob nClob)");
    }

    @Override
    public NClob getNClob(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getNClob(int columnIndex)");
    }

    @Override
    public NClob getNClob(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getNClob(String columnLabel)");
    }

    @Override
    public SQLXML getSQLXML(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getSQLXML(int columnIndex)");
    }

    @Override
    public SQLXML getSQLXML(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getSQLXML(String columnLabel)");
    }

    @Override
    public void updateSQLXML(int columnIndex, SQLXML xmlObject) throws SQLException {
        throw new SQLException("Not implemented: updateSQLXML(int columnIndex, SQLXML xmlObject)");
    }

    @Override
    public void updateSQLXML(String columnLabel, SQLXML xmlObject) throws SQLException {
        throw new SQLException("Not implemented: updateSQLXML(String columnLabel, SQLXML xmlObject)");
    }

    @Override
    public String getNString(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getNString(int columnIndex)");
    }

    @Override
    public String getNString(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getNString(String columnLabel)");
    }

    @Override
    public Reader getNCharacterStream(int columnIndex) throws SQLException {
        throw new SQLException("Not implemented: getNCharacterStream(int columnIndex)");
    }

    @Override
    public Reader getNCharacterStream(String columnLabel) throws SQLException {
        throw new SQLException("Not implemented: getNCharacterStream(String columnLabel)");
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        throw new SQLException("Not implemented: updateNCharacterStream(int columnIndex, Reader x, long length)");
    }

    @Override
    public void updateNCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLException("Not implemented: updateNCharacterStream(String columnLabel, Reader reader, long length)");
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x, long length) throws SQLException {
        throw new SQLException("Not implemented: updateAsciiStream(int columnIndex, InputStream x, long length)");
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x, long length) throws SQLException {
        throw new SQLException("Not implemented: updateBinaryStream(int columnIndex, InputStream x, long length)");
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x, long length) throws SQLException {
        throw new SQLException("Not implemented: updateCharacterStream(int columnIndex, Reader x, long length)");
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x, long length) throws SQLException {
        throw new SQLException("Not implemented: updateAsciiStream(String columnLabel, InputStream x, long length)");
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x, long length) throws SQLException {
        throw new SQLException("Not implemented: updateBinaryStream(String columnLabel, InputStream x, long length)");
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLException("Not implemented: updateCharacterStream(String columnLabel, Reader reader, long length)");
    }

    @Override
    public void updateBlob(int columnIndex, InputStream inputStream, long length) throws SQLException {
        throw new SQLException("Not implemented: updateBlob(int columnIndex, InputStream inputStream, long length)");
    }

    @Override
    public void updateBlob(String columnLabel, InputStream inputStream, long length) throws SQLException {
        throw new SQLException("Not implemented: updateBlob(String columnLabel, InputStream inputStream, long length)");
    }

    @Override
    public void updateClob(int columnIndex, Reader reader, long length) throws SQLException {
        throw new SQLException("Not implemented: updateClob(int columnIndex, Reader reader, long length)");
    }

    @Override
    public void updateClob(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLException("Not implemented: updateClob(String columnLabel, Reader reader, long length)");
    }

    @Override
    public void updateNClob(int columnIndex, Reader reader, long length) throws SQLException {
        throw new SQLException("Not implemented: updateNClob(int columnIndex, Reader reader, long length)");
    }

    @Override
    public void updateNClob(String columnLabel, Reader reader, long length) throws SQLException {
        throw new SQLException("Not implemented: updateNClob(String columnLabel, Reader reader, long length)");
    }

    @Override
    public void updateNCharacterStream(int columnIndex, Reader x) throws SQLException {
        throw new SQLException("Not implemented: updateNCharacterStream(int columnIndex, Reader x)");
    }

    @Override
    public void updateNCharacterStream(String columnLabel, Reader reader) throws SQLException {
        throw new SQLException("Not implemented: updateNCharacterStream(String columnLabel, Reader reader)");
    }

    @Override
    public void updateAsciiStream(int columnIndex, InputStream x) throws SQLException {
        throw new SQLException("Not implemented: updateAsciiStream(int columnIndex, InputStream x)");
    }

    @Override
    public void updateBinaryStream(int columnIndex, InputStream x) throws SQLException {
        throw new SQLException("Not implemented: updateBinaryStream(int columnIndex, InputStream x)");
    }

    @Override
    public void updateCharacterStream(int columnIndex, Reader x) throws SQLException {
        throw new SQLException("Not implemented: updateCharacterStream(int columnIndex, Reader x)");
    }

    @Override
    public void updateAsciiStream(String columnLabel, InputStream x) throws SQLException {
        throw new SQLException("Not implemented: updateAsciiStream(String columnLabel, InputStream x)");
    }

    @Override
    public void updateBinaryStream(String columnLabel, InputStream x) throws SQLException {
        throw new SQLException("Not implemented: updateBinaryStream(String columnLabel, InputStream x)");
    }

    @Override
    public void updateCharacterStream(String columnLabel, Reader reader) throws SQLException {
        throw new SQLException("Not implemented: updateCharacterStream(String columnLabel, Reader reader)");
    }

    @Override
    public void updateBlob(int columnIndex, InputStream inputStream) throws SQLException {
        throw new SQLException("Not implemented: updateBlob(int columnIndex, InputStream inputStream)");
    }

    @Override
    public void updateBlob(String columnLabel, InputStream inputStream) throws SQLException {
        throw new SQLException("Not implemented: updateBlob(String columnLabel, InputStream inputStream)");
    }

    @Override
    public void updateClob(int columnIndex, Reader reader) throws SQLException {
        throw new SQLException("Not implemented: updateClob(int columnIndex, Reader reader)");
    }

    @Override
    public void updateClob(String columnLabel, Reader reader) throws SQLException {
        throw new SQLException("Not implemented: updateClob(String columnLabel, Reader reader)");
    }

    @Override
    public void updateNClob(int columnIndex, Reader reader) throws SQLException {
        throw new SQLException("Not implemented: updateNClob(int columnIndex, Reader reader)");
    }

    @Override
    public void updateNClob(String columnLabel, Reader reader) throws SQLException {
        throw new SQLException("Not implemented: updateNClob(String columnLabel, Reader reader)");
    }

    @Override
    public <T> T getObject(int columnIndex, Class<T> type) throws SQLException {
        return null;
    }

    @Override
    public <T> T getObject(String columnLabel, Class<T> type) throws SQLException {
        return null;
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

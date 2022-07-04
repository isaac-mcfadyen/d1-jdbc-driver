package org.isaacmcfadyen;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

public class D1Driver implements Driver {
    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        String[] parts = url.split(":");
        String DatabaseUuid = parts[2].replace("//", "");
        String AccountId = info.getProperty("user");
        String ApiKey = info.getProperty("password");
        return new D1Connection(ApiKey, AccountId, DatabaseUuid);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.contains("d1://");
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return null;
    }

    @Override
    public int getMajorVersion() {
        return 1;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}

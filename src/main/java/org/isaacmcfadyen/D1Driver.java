package org.isaacmcfadyen;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D1Driver implements Driver {
    static {
        try {
            DriverManager.registerDriver(new D1Driver());
        } catch (SQLException e) {
            System.out.println("Could not register driver: " + e);
        }
    }

    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        // Only accept valid URLs with valid UUIDs.
        Pattern pattern = Pattern.compile("^jdbc:d1://([0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12})$");
        Matcher matcher = pattern.matcher(url);
        if (!matcher.find()) {
            throw new SQLException("Invalid URL. URLs must be in the format jdbc:d1://UUID");
        }

        // Make sure there's valid auth provided.
        String accountId = info.getProperty("user");
        String apiToken = info.getProperty("password");
        if (accountId == null || apiToken == null || accountId.isEmpty() || apiToken.isEmpty()) {
            throw new SQLException("Invalid credentials. Must specify Cloudflare Account ID as username and Cloudflare API Token as password.");
        }

        String databaseId = matcher.group(1);
        return new D1Connection(apiToken, accountId, databaseId);
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url.startsWith("jdbc:d1://");
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
        return 2;
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

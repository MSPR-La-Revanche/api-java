package com.mkyong.examples;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    //static final String DB_URL =  "jdbc:mysql://15.236.210.166:3306";

    Connection conn = null;
    Statement stmt = null;

    boolean connected = false;

    public void DBconnect(String user, String password) {

        try {
            // Open connection
            System.out.println("Connecting to database...");

            // Connection for prod database
            conn = DriverManager.getConnection("jdbc:mysql://sql4.freemysqlhosting.net:3306/sql4403036", user, password);
            // Connection for local database
            // conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/mspr", user, password);
            System.out.println("Connection success");
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
            System.out.println("SQLState: " + se.getSQLState());
            System.out.println("VendorError: " + se.getErrorCode());
        }
    }

    public void checkConnection() {
        if (!connected) {
            DBconnect("root", "mypass123");
            connected = true;
        }
    }

    public void InsertIntoDatabase(String table, int id, String name, String value) throws SQLException {
        checkConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO " + table + " VALUES ('" + id + "', '" + name + "', '" + value + "')");
    }

    public void deleteFromDatabase(String table, int id) throws SQLException {
        checkConnection();
        stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM " + table + " WHERE ID = " + id);
    }

    public int executeQuery(String query) throws SQLException {
        return conn.createStatement().executeUpdate(query);
    }
}

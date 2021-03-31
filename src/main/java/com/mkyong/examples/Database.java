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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/mspr", user, password);
            System.out.println("Connection success");
        } catch (SQLException se) {
            System.out.println("SQLException: " + se.getMessage());
            System.out.println("SQLState: " + se.getSQLState());
            System.out.println("VendorError: " + se.getErrorCode());
        }
    }

    public void InsertIntoDatabase(String table, int id, String name, String value) throws SQLException {
        if(!connected) {
            DBconnect("root", "mypass123");
            connected = true;
        }

        stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO " + table + " VALUES ('" + id + "', '" + name + "', '" + value + "')");

    }
}

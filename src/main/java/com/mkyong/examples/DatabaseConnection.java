package com.mkyong.examples;

import java.sql.*;

public class DatabaseConnection {

    // JDBC driver name and database url
    static final String JDBC_DRIVE = "com.mysql.jdbc.Drive";
    static final String DB_URL = "15.236.210.166";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "mypass123";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC Driver
            Class.forName("com.mysql.jdbc.Drive");

            // Open connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            System.out.println("Creating a statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, first, last, age FROM Employees"; // Change to match
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while(rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String desc = rs.getString("description");

                // Display values
                System.out.println("ID : " + id);
                System.out.println("Name : " + name);
                System.out.println("Description : " + desc);
            }
            // Clean up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se2) {
                se2.printStackTrace();
            } try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

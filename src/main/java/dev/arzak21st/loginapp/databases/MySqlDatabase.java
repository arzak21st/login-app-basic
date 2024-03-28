package dev.arzak21st.loginapp.databases;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDatabase {

    // MySQL database parameters
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/login_app_db";
    private static final String USERNAME = "root"; // Change to your MySQL username
    private static final String PASSWORD = "pass"; // Change to your MySQL password

    // Establishing a connection to the database
    public static Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }

        return connection;
    }

    // Testing the database connection
    public static void main(String[] args) {
        MySqlDatabase.getConnection();
    }
}

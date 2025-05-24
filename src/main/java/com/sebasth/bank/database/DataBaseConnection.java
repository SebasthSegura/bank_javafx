package com.sebasth.bank.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class DataBaseConnection {
    private String jbcUrl;
    private String username;
    private String password;

    public void main(String[] args) {
        // ejemplo de uso de la clase DataBaseConnection
        DataBaseConnection dbConnection = new DataBaseConnection("jdbc:mysql://localhost:3306/mydatabase", "user", "password");
        dbConnection.insertUser("John Doe", "");
        }

    public DataBaseConnection(String jbcUrl, String username, String password) {
        this.jbcUrl = jbcUrl;
        this.username = username;
        this.password = password;
    }
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(jbcUrl, username, password);
    }
    public void CloseConnection(Connection connection){
        if(connection != null){
            try {
                connection.close();
                System.out.println("Connection closed successfully.");
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }
    public void rollbackTransaction(Connection connection){
        if (connection != null){
            try {
                connection.rollback();
                System.out.println("Transaction rolled bacck successfully.");
            } catch (SQLException e) {
                System.out.println("Error rolling back transaction: " + e.getMessage());
            }
        }
    }
}

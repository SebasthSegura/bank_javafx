package com.sebasth.bank.database;

import com.sebasth.bank.objects.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class UserDAO {
    private Connection connection;
    private  String tableName = "users";

    public  UserDAO(Connection connection){
        this.connection = connection;
    }

    public User getUserByUsername(String username) throws SQLException {
        java.sql.PreparedStatement statement = null;
        java.sql.ResultSet resultSet = null;
        try {
            String sql = "SELECT id, username FROM " + tableName + " WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                return user;
            }
            return null;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
    }
}

package com.sebasth.bank.database;

import com.sebasth.bank.objects.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleDAO {
    private Connection connection;
    private String tableName = "roles";

    public RoleDAO(Connection connection) {
        this.connection = connection;
    }

    public Role getRoleById(int releId) throws SQLException {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM " + tableName + " WHERE id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, releId);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Role role = new Role();
                role.setRolId(resultSet.getInt("id"));
                role.setRolName(resultSet.getString("name"));
                return role;
            }
            return null;
        } finally {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
        }
    }
}

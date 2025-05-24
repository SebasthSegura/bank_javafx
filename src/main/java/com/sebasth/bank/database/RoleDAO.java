package com.sebasth.bank.database;

import com.sebasth.bank.objects.Role;

import java.sql.Connection;

public class RoleDAO {
    private Connection connection;
    private String tableName = "roles";

    public RoleDAO(Connection connection) {
        this.connection = connection;
    }
}

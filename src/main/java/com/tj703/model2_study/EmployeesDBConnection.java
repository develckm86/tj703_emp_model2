package com.tj703.model2_study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
public class EmployeesDBConnection {
//부서 crud model2
//사원 crud
    private final static String URL = "jdbc:mysql://localhost:3306/employees";
    private final static String USER = "root";
    private final static String PASSWORD = "mysqlmysql";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection conn;
    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws Exception {
        if(conn == null || conn.isClosed()) {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conn;
    }
}

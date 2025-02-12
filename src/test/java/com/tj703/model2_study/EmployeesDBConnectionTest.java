package com.tj703.model2_study;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesDBConnectionTest {

    @Test
    void getConnection() throws Exception {
        EmployeesDBConnection.getConnection();
    }
}
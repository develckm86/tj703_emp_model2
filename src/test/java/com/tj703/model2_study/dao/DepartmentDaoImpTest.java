package com.tj703.model2_study.dao;

import com.tj703.model2_study.dto.DepartmentDto;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DepartmentDaoImpTest {

    @Test
    void close() throws Exception {
        new DepartmentDaoImp().close();
    }

    @Test
    @Order(5)
    void findAll() throws Exception {
        assertNotNull(new DepartmentDaoImp().findAll());
    }

    @Test
    @Order(3)
    void findById() throws Exception {
        assertNotNull(new DepartmentDaoImp().findById("d777"));
    }

    @Test
    @Order(4)
    void deleteById() throws Exception {
        assertTrue(new DepartmentDaoImp().deleteById("d777")>0);
    }

    @Test
    @Order(2)
    void update() throws Exception {
        DepartmentDto dto=new DepartmentDto();
        dto.setDeptNo("d777");
        dto.setDeptName("테스트 부서");
        assertTrue(new DepartmentDaoImp().update(dto)>0);

    }

    @Test
    @Order(1)
    void insert() throws Exception {
        DepartmentDto dto=new DepartmentDto();
        dto.setDeptNo("d777");
        dto.setDeptName("태스트부서");
        assertTrue(new DepartmentDaoImp().insert(dto)>0);


    }

    @Test
    void findByDeptNoAndDeptName() throws Exception {
        DepartmentDto dto=new DepartmentDto();
        dto.setDeptNo("d001");
        dto.setDeptName("Marketing");
        System.out.println(new DepartmentDaoImp().findByDeptNoAndDeptName(dto));
    }
}
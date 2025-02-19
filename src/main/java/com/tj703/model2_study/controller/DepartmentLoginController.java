package com.tj703.model2_study.controller;

import com.tj703.model2_study.dao.DepartmentDao;
import com.tj703.model2_study.dao.DepartmentDaoImp;
import com.tj703.model2_study.dto.DepartmentDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dept/login.do")
public class DepartmentLoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptNo=req.getParameter("dept_no");
        String deptName=req.getParameter("dept_name");
        DepartmentDto detpDto=null;
        try {
            DepartmentDao departmentDao=new DepartmentDaoImp();
            detpDto=departmentDao.findById(deptNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}

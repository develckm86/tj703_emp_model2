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

@WebServlet("/dept/register.do")
public class DepartmentRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/dept/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int register=0;
        DepartmentDao deptDao=null;
        String deptNo=req.getParameter("dept_no");
        try {
            DepartmentDto deptDto = new DepartmentDto();
            deptDto.setDeptNo(deptNo);
            deptDto.setDeptName(req.getParameter("dept_name"));
            deptDao=new DepartmentDaoImp();
            register=deptDao.insert(deptDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(register==0){
            resp.sendRedirect("./register.do");
        }else{
            resp.sendRedirect("./detail.do?dept_no="+deptNo);
        }
    }
}

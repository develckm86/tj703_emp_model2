package com.tj703.model2_study.controller;

import com.tj703.model2_study.dao.DepartmentDao;
import com.tj703.model2_study.dao.DepartmentDaoImp;
import com.tj703.model2_study.dao.EmployeeDao;
import com.tj703.model2_study.dto.DepartmentDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/dept/list.do")
public class DepartmentListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DepartmentDao deptDao=null;
        List<DepartmentDto> deptList=null;
        try{
            deptDao=new DepartmentDaoImp();
            deptList=deptDao.findAll();
        } catch (Exception e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
            resp.sendError(500);
            return;
        }finally {
            if(deptDao!=null){deptDao.close();}
        }


        req.setAttribute("deptList", deptList);
        req.getRequestDispatcher("/WEB-INF/views/dept/list.jsp").forward(req, resp);


    }
}

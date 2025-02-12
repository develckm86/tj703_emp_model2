package com.tj703.model2_study.controller;

import com.tj703.model2_study.dao.DepartmentDao;
import com.tj703.model2_study.dao.DepartmentDaoImp;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dept/remove.do")
public class DepartmentRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptNo = req.getParameter("dept_no");
        if(deptNo == null || deptNo.isEmpty() || deptNo.length() >4) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        DepartmentDao dao = null;
        int remove=0;
        String successUrl=req.getContextPath()+"/dept/list.do";
        String failUrl=req.getContextPath()+"/dept/modify.do?dept_no="+deptNo;
        try {
            dao=new DepartmentDaoImp();
            remove=dao.deleteById(deptNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(remove>0){
            resp.sendRedirect(successUrl);
        }else{
            resp.sendRedirect(failUrl);
        }
    }
}

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

@WebServlet("/dept/modify.do")
public class DepartmentModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptNo=req.getParameter("dept_no");
        if(deptNo==null || deptNo.isEmpty() || deptNo.length()>4){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        DepartmentDao deptDao=null;
        DepartmentDto deptDto=null;
        try {
            deptDao=new DepartmentDaoImp();
            deptDto=deptDao.findById(deptNo);
        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }finally {
            if(deptDao!=null){deptDao.close();}
        }
        if(deptDto==null){
            resp.sendRedirect(req.getContextPath()+"/dept/list.do");
        }else{
            req.setAttribute("dept", deptDto);
            req.getRequestDispatcher("/WEB-INF/views/dept/modify.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int modfiy=0; //성공한 수
        String deptNo=req.getParameter("dept_no");
        String deptName=req.getParameter("dept_name");
        String successUrl="./detail.do?dept_no="+deptNo;
        String failUrl="./modify.do?dept_no="+deptNo;
        DepartmentDao deptDao=null;
        try{
            deptDao=new DepartmentDaoImp();
            DepartmentDto dept=new DepartmentDto();
            dept.setDeptNo(deptNo);
            dept.setDeptName(deptName);
            modfiy=deptDao.update(dept);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(deptDao!=null){deptDao.close();}
        }
        if(modfiy>0){
            resp.sendRedirect(successUrl);
        }else{
            resp.sendRedirect(failUrl);
        }

    }
}

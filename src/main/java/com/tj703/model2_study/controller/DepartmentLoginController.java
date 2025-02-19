package com.tj703.model2_study.controller;

import com.tj703.model2_study.dao.DepartmentDao;
import com.tj703.model2_study.dao.DepartmentDaoImp;
import com.tj703.model2_study.dto.DepartmentDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dept/login.do")
public class DepartmentLoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptNo=req.getParameter("dept_no");
        String deptName=req.getParameter("dept_name");
        DepartmentDto detpDto=null;
        try {
            DepartmentDao departmentDao=new DepartmentDaoImp();
            DepartmentDto parmaDto=new DepartmentDto();
            parmaDto.setDeptNo(deptNo);
            parmaDto.setDeptName(deptName);
            detpDto=departmentDao.findByDeptNoAndDeptName(parmaDto);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String msg;
        //로그인 성공
        HttpSession session=req.getSession();
        if(detpDto!=null){
            msg="로그인 성공";
            session.setAttribute("deptDto", detpDto);
            session.setAttribute("msg", msg);
        }else{
            msg="번호와 이름을 다시 확인하세요";
            session.setAttribute("msg", msg );
        }
        System.out.println(msg);
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}

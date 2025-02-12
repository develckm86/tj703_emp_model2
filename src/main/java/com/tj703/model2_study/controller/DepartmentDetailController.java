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

@WebServlet("/dept/detail.do")
public class DepartmentDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String deptNo = req.getParameter("dept_no");
        if (deptNo == null || deptNo.isEmpty() || deptNo.length() > 4) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        DepartmentDao deptDao=null;
        DepartmentDto dept=null;
        try  {
            deptDao=new DepartmentDaoImp();
            dept=deptDao.findById(deptNo);
        } catch (Exception e){
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }finally {
            if(deptDao!=null){deptDao.close();}
        }
        if(dept==null){
            // // http:localhost:8888/a/dept/list.do -> .detail.do
            // // http:localhost:8888/a/emp/list.do -> .detail.do
            resp.sendRedirect(req.getContextPath()+"/dept/list.do");
        }else {
            req.setAttribute("dept", dept);
            req.getRequestDispatcher("/WEB-INF/views/dept/detail.jsp").forward(req, resp);
        }

    }
}

package com.tj703.model2_study;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/setBanner.do")
public class SetBanner extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String isBanner = req.getParameter("isBanner");
        resp.setContentType("text/html;charset=utf-8");
        Cookie cookie = new Cookie("isBanner", isBanner);
        cookie.setMaxAge(60*60*24);
        resp.addCookie(cookie);
        PrintWriter out = resp.getWriter();
        out.println("<script>window.close()</script>");

    }
}

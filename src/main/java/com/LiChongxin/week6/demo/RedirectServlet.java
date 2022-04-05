package com.LiChongxin.week6.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. start without /
        System.out.println("before redirect");
        //http://localhost:8080/LiChongxin1128_war_exploded/redirect
        //response.sendRedirect("index.jsp");
        //http://localhost:8080/LiChongxin1128_war_exploded/index.jsp
        System.out.println("after redirect");
        //change redirect - > index.jsp

        //2. start with /
        //response.sendRedirect("/LiChongxin1 128_war_exploded/index.jsp");
        //http://localhost:8080/LiChongxin1128_war_exploded/redirect

        response.sendRedirect("https://www.baidu.com/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

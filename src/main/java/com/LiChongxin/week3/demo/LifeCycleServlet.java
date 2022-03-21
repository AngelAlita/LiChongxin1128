package com.LiChongxin.week3.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/life"})
public class LifeCycleServlet extends HttpServlet {
    Connection con = null;
    public LifeCycleServlet(){
        System.out.println("I am in constructor  --> LifeCycleServlet");
    }

    @Override
    public void init() throws ServletException {
        //#3.使用servletcontext
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection--> in JDBCDemoServlet " + con);
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
        System.out.println("I am in Init()" + con) ;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am in service() --> doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("I am in service() --> doPost()");
    }

    @Override
    public void destroy() {
        System.out.println("I am in destroy() ");
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

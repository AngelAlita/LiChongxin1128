package com.LiChongxin.week3.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {

    public LifeCycleServlet(){
        System.out.println("I am in constructor  --> LifeCycleServlet");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("I am in Init()");
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
    }
}

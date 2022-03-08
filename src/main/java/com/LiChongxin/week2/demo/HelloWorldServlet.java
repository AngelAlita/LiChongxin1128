package com.LiChongxin.week2.demo;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * The type Hello world servlet.
 */
public class HelloWorldServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Date datel = new Date();
        PrintWriter writer = resp.getWriter();
        writer.println("Hello Client !!!");
        writer.println("Name : Li Chongxin");
        writer.println("Id : 2020211001001128");
        writer.println("Date and Time :" +datel.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

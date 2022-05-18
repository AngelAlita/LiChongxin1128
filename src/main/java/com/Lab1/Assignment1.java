package com.Lab1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/assignment1")
public class Assignment1 extends HttpServlet {

    int count;
    public Assignment1(){
        System.out.println("I Am from default constructor");
    }
    @Override
    public void init() throws ServletException {
        super.init();
        count = 0;
        System.out.println("I Am in init()");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        count++;
        PrintWriter out = response.getWriter();
        out.println("since loding,this servlet has been accessed " + count + " times");
        System.out.println("I Am in servlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("I Am from destroy()");
    }
}

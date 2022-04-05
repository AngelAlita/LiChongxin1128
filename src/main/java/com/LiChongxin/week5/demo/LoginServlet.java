package com.LiChongxin.week5.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();

        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
            System.out.println("init() - > " + con);
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String sql = "Select * from usertable where username = ? and password = ?";
        try {
            PreparedStatement psmt = con.prepareStatement(sql);
            psmt.setString(1, username);
            psmt.setString(2, password);
            ResultSet rs = psmt.executeQuery();
            if (rs.next()){
                 out.print("Login Success!!! <br>");
                 out.print("Welcome,"+ username +" <br>");
            }else{
                  out.print("Login Error!!! <br>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

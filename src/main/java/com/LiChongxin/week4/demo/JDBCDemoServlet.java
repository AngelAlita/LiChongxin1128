package com.LiChongxin.week4.demo;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import jakarta.servlet.annotation.WebInitParam;

import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;


//其他更简单的方法@WebServlet
/*
@WebServlet(name = "JDBCDemoServlet",urlPatterns = {"/jdbc"},
        initParams = {
        @WebInitParam(name="driver",value="com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false"),
                @WebInitParam(name="username",value="sa"),
                @WebInitParam(name="password",value="20020912Planck")
        },
        loadOnStartup = 1
)
*/

// #3.复用driver,url,username,password 去连接数据库
@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1) //只有url 和load on startuo
public class JDBCDemoServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        /*
        这4个变量不应该在java class中，应该在web.xml中
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        String username = "sa";
        String password = "20020912Planck";
        */


        //1.获取servlet config
        /*ServletConfig config = getServletConfig();
        //2.获取param
        String driver = config.getInitParameter("driver");
        String url = config.getInitParameter("url");
        String username = config.getInitParameter("username");
        String password = config.getInitParameter("password");*/


        //#3.使用servletcontext
        ServletContext context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con =DriverManager.getConnection(url,username,password);
            System.out.println("Connection--> in JDBCDemoServlet " + con);
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

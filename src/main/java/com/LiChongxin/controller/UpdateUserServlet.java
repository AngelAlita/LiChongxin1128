package com.LiChongxin.controller;

import com.LiChongxin.dao.UserDao;
import com.LiChongxin.model.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 1: forward to WEB-INF/views/updateUser.jsp
        //TODO 2:create one jsp page - update User
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO 1:get all(6) request parameters
        //TODO 2:create an object of User Model
        //TODO 3:set all 6 request parameters values into User model -setXXX()
        //TODO 4:create an object of UserDao
        //TODO 5:Call updateUser() in UserDao
        int id = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        User user = new User();

        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirthDate(Date.valueOf(birthDate));

        UserDao userdao = new UserDao();
        ServletContext context = getServletContext();
        Connection con = (Connection) context.getAttribute("con");

        int flag = 1;
        try{
            flag = userdao.updateUser(con,user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TODO 6:forward to WEB-INF/views/userInfo.jsp
        if(flag == 0){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("accountDetails").forward(request,response);
        }else {
            
        }

    }
}

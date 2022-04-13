package com.LiChongxin.dao;

import com.LiChongxin.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserDao implements IUserDao{


    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert --- into usertable
        String sql = "insert into usertable values(?,?,?,?,?)";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,user.getUsername());
        psmt.setString(2,user.getPassword());
        psmt.setString(3,user.getEmail());
        psmt.setString(4,user.getGender());
        psmt.setDate(5,(java.sql.Date)user.getBirthDate());
        psmt.executeUpdate();
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete .... where id = ?
        String sql = "delete usertable from where id = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setInt(1,user.getId());
        psmt.executeUpdate();
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update .... where id = ?
        String sql = "update usertable set username = ? ,password = ?, email = ? ,gender = ? ,birthdate = ?  where id = ?";

        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, user.getUsername());
        psmt.setString(2,user.getPassword());
        psmt.setString(3,user.getEmail());
        psmt.setString(4,user.getGender());
        psmt.setDate(5, (java.sql.Date)user.getBirthDate());
        psmt.setInt(6,user.getId());
        psmt.executeUpdate();
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select ... where id = ?
        String sql = "Select * from usertable where id = ? ";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setInt(1,id);
        ResultSet rs = psmt.executeQuery();
        User user = null;
        if(rs.next())
        {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        //用于登陆
        //select ... where username = ? and password = ?
        String sql = "Select * from usertable where username = ? and password = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,username);
        psmt.setString(2,password);
        ResultSet rs = psmt.executeQuery();
        User user = null;
        if(rs.next())
        {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from usertable where username = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,username);
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from usertable where password = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,password);
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from usertable where email = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,email);
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from usertable where gender = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1,gender);
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from usertable where birthdate = ?";
        PreparedStatement psmt = con.prepareStatement(sql);
        psmt.setString(1, String.valueOf(birthDate));
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "select * from usertable ";
        PreparedStatement psmt = con.prepareStatement(sql);
        ResultSet rs = psmt.executeQuery();
        while(rs.next())
        {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }
}

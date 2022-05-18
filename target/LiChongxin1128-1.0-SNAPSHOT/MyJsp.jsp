<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Planck
  Date: 2022/5/18
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using Servlet</title>
</head>
<body>
<h2> I Am in MyJsp.jsp</h2>
<%
    String name = request.getParameter("name");
    String cla = request.getParameter("class");
    String id = request.getParameter("id");
    PrintWriter output = response.getWriter();
    output.println("name: " + name  );
    output.println("submit: " + "Send data to server");
    output.println("class: " + cla );
    output.println("id: " + id );
%>
<form method="post">
    Name :<input type="text" name="name"> <br/>
    Class :<input type="text" name="class"><br/>
    Id :<input type="text" name="id"><br/>
    <input type="submit" value="Send data to server">
</form>
</body>
</html>

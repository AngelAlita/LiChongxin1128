<%--
  Created by IntelliJ IDEA.
  User: Planck
  Date: 2022/5/18
  Time: 11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Using JSP And EL</title>
</head>
<body>
    <!--jsp !-->
    <h2>JSP</h2>
    name:<%=request.getParameter("name")%><br>
    submit:<%=request.getParameter("submit")%><br>
    class:<%=request.getParameter("cls")%><br>
    id:<%=request.getParameter("id")%><br>

    <!--EL !-->
    <h2>EL</h2>
    name:${param.name}<br>
    submit:${param.submit}<br>
    class:${param.cls}<br>
    id:${param.id}<br>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Planck
  Date: 2022/4/5
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    public void jspInit(){
        System.out.println("i am in jspinit()");
    }

%>

<html>
<head>
    <title>Life Cycle JSP</title>
</head>
<body>
<%System.out.println("i am in jspservice()");%>
</body>
</html>
<%!
    public void jspDestroy(){
        System.out.println("i am in jspDestroy()");
    }
%>

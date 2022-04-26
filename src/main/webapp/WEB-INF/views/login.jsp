<%@ page import="jakarta.servlet.http.Cookie" %><%--
  Created by IntelliJ IDEA.
  User: Planck
  Date: 2022/4/5
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (!(request.getAttribute("message")==null)) {
        out.print("<h3>" + request.getAttribute("message") + "</h3>");
    }
%>
<%
    Cookie[] allcookies = request.getCookies();
    String username = "",password = "",rememberMeVal="";
    if(allcookies != null){
        for(Cookie c:allcookies){
            if(c.getName().equals("cUsername")){
                username = c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password = c.getValue();
            }if(c.getName().equals("cRememberMe")){
                rememberMeVal = c.getValue();
            }
        }
    }
%>
<form method="post" action="<%=request.getContextPath()+"login"%>">
    UserName:<input type="text" name="username" value="<%=username%>"><br>
    Password:<input type="password" name="password" value="<%=password%>"><br>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeVal.equals("1") ?"checked":""%>checked/>RememberMe<br>
    <input type="submit" value="login">
</form>

<%@include file="footer.jsp"%>
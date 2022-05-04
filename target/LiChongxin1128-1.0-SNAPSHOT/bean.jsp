<%@ page import="com.LiChongxin.week10.demo.StringBean" %><%--
  Created by IntelliJ IDEA.
  User: Planck
  Date: 2022/5/3
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo-2-week 10</title>
</head>
<body>
<h1>Use java code to access String bean</h1>
<jsp:useBean id="bean" class="com.LiChongxin.week10.demo.StringBean"/>
<%
  //com.LiChongxin.week10.demo.StringBean bean = new StringBean();

  //bean.setMessage("Hello Mr bean - from java code");

%>
<jsp:setProperty name="bean" property="message" value='<%=request.getParameter("message")%>'/>
Message (using java code): <%=bean.getMessage()%>

<h2>Use usebean to access Stringbean class in jsp</h2>
message (using getProperty) : <jsp:getProperty name="bean" property="message"/>

</body>
</html>

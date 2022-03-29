<%--
  Created by IntelliJ IDEA.
  User: Planck
  Date: 2022/3/13
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>

<%@include file="header.jsp"%>
    <form method="post" action="register">
        username :<input type="text" name="username"> <br/>
        password :<input type="password" name="password"><br/>
        Email :<input type="text" name="email"><br/>
        Gender :<input type="radio" name="gender" value="male"> Male <input type="radio" name="gender" value="famale"> Female<br/>
        Date of Birth :<input type="text name" name="birthDate"><br/>
        <input type="submit" value="Register">
    </form>
<%@include file="footer.jsp"%>

<%@ page import="com.LiChongxin.week11.demo.Person" %>
<%@ page import="com.LiChongxin.week11.demo.Dog" %><%--
  Created by IntelliJ IDEA.
  User: Planck
  Date: 2022/5/15
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 2 - week11</title>
</head>
<body>

<%
    com.LiChongxin.week11.demo.Person person = new Person();
    person.setName("Tom");

    Dog dog = new Dog();
    dog.setName("Tommy");

    person.setDog(dog);

    request.setAttribute("personAtt",person);

%>
<h2> get person' dog name - using java code </h2>
<%
    Person p = (Person) pageContext.findAttribute("personAtt");
    Dog d = p.getDog();
    out.println(p.getName() + "s' Dog name --->" + d.getName());
%>

<h2> get person' dog name - using EL code </h2>

Person's Dog name : ${personAtt.name}'s Dog name ---- > ${personAtt.dog.name}

</body>
</html>

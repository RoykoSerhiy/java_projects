<%-- 
    Document   : form
    Created on : 30.09.2015, 18:49:13
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
    </head>
    <body>
        <sf:form method="POST" action="/spring2/user/create" modelAttribute="userForm">
            <div><sf:input path="name" /> <sf:label path="name">Name</sf:label> </div>
            <div><sf:input path="pass" /> <sf:label path="pass">Password</sf:label></div>
            <div><sf:input path="email" /> <sf:label path="email">Email</sf:label></div>
            <div><sf:input path="login" /> <sf:label path="login">Login</sf:label></div>
            <div><input type="submit" value="Create" /></div>
        </sf:form>
    </body>
</html>

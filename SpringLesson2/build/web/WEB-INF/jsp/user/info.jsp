<%-- 
    Document   : info
    Created on : 30.09.2015, 18:58:25
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>name: ${user.name}</div>
        <div>pass: ${user.pass}</div>
        <div>email: ${user.login}</div>
        <div>alias: ${user.email}</div>
        <div><a href="/spring2/user/create">Create new User</a></div>
    </body>
</html>

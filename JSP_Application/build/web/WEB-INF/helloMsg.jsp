<%-- 
    Document   : helloMsg
    Created on : 28.09.2015, 20:09:47
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
        <h1>You have a message:</h1>
        <div><%= request.getAttribute("message") %></div>
    </body>
</html>

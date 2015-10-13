<%-- 
    Document   : helloForm
    Created on : 28.09.2015, 20:06:03
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
        <h1>Hello World!</h1>
        <form action="/JSP_Application/helloForm" method="POST">
            <input type="text" name="target"/><br>
            <input type="submit" value="send to hello"/><br>
            
        </form>
    </body>
</html>

<%-- 
    Document   : form
    Created on : 30.09.2015, 10:53:40
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
    </head>
    <body>
        <form method="POST" action="/spring/formCtrl">
            <input name="login" type="text"/>
            <input name="password" type="text"/>
            <input type="submit" value="OK"/>
        </form>
        <div>
            Your login:${login} and password:${password}
        </div>
    </body>
</html>

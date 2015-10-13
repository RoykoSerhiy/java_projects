<%-- 
    Document   : jstl
    Created on : 28.09.2015, 20:23:53
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <div>
            <j:set var="a" value="10"/>
            <j:if test="${a == 10}">
                a equals 10
            </j:if>   
        </div>
    </body>
</html>

<%-- 
    Document   : home
    Created on : 06.10.2015, 18:10:21
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <j:if test="${isAuthorized == false}">
            <div><a href="auth/login">Login</a>&nbsp;<a href="auth/register">Register</a></div>
        </j:if>
        <j:if test="${isAuthorized != false}">
            <div><a href="user/profile">To Profile</a></div>
        </j:if>
        <j:forEach items="${posts}" var="post">
            
                <div><a href="user/profile?uid=${users.get(post.getUserId()).getId()}">${users.get(post.getUserId()).getName()} ${users.get(post.getUserId()).getSurname()}</a></div>
                <div>${post.getPublishedDate()} <a href="post/view?post=${post.getId()}&a=0">${post.getTheme()}</a></div>
                <div>${post.getDescription()}</div>
            </j:forEach>
    </body>
</html>

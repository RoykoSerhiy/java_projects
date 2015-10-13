<%-- 
    Document   : profile
    Created on : 05.10.2015, 19:22:24
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div><a href="../home">Home</a></div>
        <div class="profileInfo">
            ${user.getName()} ${user.getSurname()} [${user.getLogin()}] Email:${user.getEmail()}</br><j:if test="${authorized != false}"><a href="../auth/logout">Logout</a></j:if>
             <j:if test="${authorized != false}">
                <a href="../post/create?user=${user.getId()}" class="butt">New post<a/>
             </j:if>
        </div>
        <div>
            <j:forEach items="${posts}" var="post">
                <div>${post.getPublishedDate()} <a href="../post/view?post=${post.getId()}">${post.getTheme()}</a></div>
                <div>${post.getDescription()}</div>
            </j:forEach>
        </div>
    </body>
</html>

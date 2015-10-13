<%-- 
    Document   : view
    Created on : 08.10.2015, 9:04:36
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <div>
                <j:choose>
                    <j:when test="${authorized != false}">
                        <a href="user/profile">Back</a>
                    </j:when>
                    <j:otherwise>
                        <a href="../user/profile?uid=${user.getId()}">Back</a>
                    </j:otherwise>
                </j:choose>
            </div>
            <div>${user.getName()} ${user.getSurname()}[${user.getLogin()}] </div>
            <div>${post.getPublishedDate()} ${post.getTheme()} </div>
            <j:if test="${authorized != false}">
                <div>
                   <a href="../post/edit/${post.getId()}?user=${user.getId()}">edit</a>
                   <a href="../post/del/${post.getId()}">delete</a>
                </div>
            </j:if>
            <div>
                ${post.getDescription()}
            </div>
        </div>
        <j:if test="${authorized != false}">
            <div>
                <form method="POST" action="../comment/add">
                    <input type="hidden" value="${post.getId()}" name="post_id" />
                    <textarea name="description"></textarea>
                    <div>
                        <input type="submit" value="Add"/>
                    </div>
                </form>
                    
            </div>
            </j:if>
            <j:forEach items="${comments}" var="c">
                <div>
                    <div>${c.getDate()} ${users.get(c.getAuthorId()).getName()} ${users.get(c.getAuthorId()).getSurname()}</div>
                    <div>${c.getDescription()}</div>
                </div>
            </j:forEach>
        
    </body>
</html>

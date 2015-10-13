<%-- 
    Document   : create
    Created on : 08.10.2015, 9:03:50
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
			<sf:form method="POST" action="post/save" modelAttribute="post">
				<sf:hidden path="id" />			
				<input type="hidden" value="${userId}" name="user_id" />			
            <div class="form-field post-field">
                                <sf:input path="theme"/><br />
				<sf:textarea path="description" />
			</div>
			<div><input type="submit" name="Save" /></div>
			</sf:form>
        </div>
    </body>
</html>

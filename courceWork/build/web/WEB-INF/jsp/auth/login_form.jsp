<%-- 
    Document   : login_form
    Created on : 06.10.2015, 10:48:46
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign in</title>
    </head>
    <body>
        <div><a href="../home">Home</a></div>
       <h1>Authorization</h1>
		<c:if test="${incorrect == true}">
			<div class="formError">Incorrect login or password!</div>
		</c:if>
		
		<sf:form method="POST" action="login"  modelAttribute="user">
			 <div class="form-field">
				<sf:input path="login" /> <sf:label path="login">Login</sf:label>
			</div>
            <div class="form-field">
				<sf:input path="pass" /> <sf:label path="pass">Password</sf:label>
			</div>
            <div><input type="submit" name="Log in" /></div>
		</sf:form>
    </body>
</html>

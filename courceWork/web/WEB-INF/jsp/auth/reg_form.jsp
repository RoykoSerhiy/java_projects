<%-- 
    Document   : reg_form
    Created on : 06.10.2015, 10:48:25
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <div><a href="../home">Home</a></div>
        <h1>User registration</h1>
        <sf:form method="POST" action="register" modelAttribute="user">
            <div class="form-field">
				<sf:errors path="name" class="formError" /><br />
				<sf:input path="name" /> <sf:label path="name">Name</sf:label>
				
			</div>
            <div class="form-field">
				<sf:errors path="name" class="formError" /><br />
				<sf:input path="surname" /> <sf:label path="surname">Surame</sf:label>
				
			</div>
            <div class="form-field">
				<sf:errors path="login" class="formError" /><br />
				<sf:input path="login" /> <sf:label path="login">Login</sf:label>
			</div>
            <div class="form-field">
				<sf:errors path="pass" class="formError" /><br />
				<sf:input path="pass" /> <sf:label path="pass">Password</sf:label>
			</div>
            <div class="form-field">
				<sf:errors path="email" class="formError" /><br />
				<sf:input path="email" /> <sf:label path="email">Email</sf:label>
			</div>
            <div><input type="submit" name="Create" /></div>
        </sf:form>
    </body>
</html>

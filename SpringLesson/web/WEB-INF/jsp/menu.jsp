<%-- 
    Document   : menu
    Created on : 29.09.2015, 19:11:34
    Author     : Serhiy
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        
        <h1>Menu</h1>
       
        <% for(int i = 0;i<5;++i) {%>
            <%int pageNum = i+1;%>
            <a href="/spring/anek?page=<%=pageNum%>">Page<%= pageNum%></a>
        <%}%>
        <div>
             ${content}
        </div>
    </body>
</html>

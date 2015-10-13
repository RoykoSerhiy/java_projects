<%-- 
    Document   : jspMenu
    Created on : 28.09.2015, 19:02:19
    Author     : Serhiy
--%>

<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>test menu</title>
    </head>
    <body>
        <%
            String pageName = request.getParameter("page");
            pageName = pageName != null ? pageName : "1";
        %>
        <%!
            int x = 0;
        %>
        <%x++;%>
         <%!
            String[] arr = new String[]{"a"  ,"b" , "c"};
            List<String> strs = Arrays.asList(arr);
        %>
        <h1>Menu(<%=pageName%>)</h1>
        <div>x=<%=x%></div>
        <% for(int i = 0;i<strs.size();++i) {%>
            <%int pageNum = i+1;%>
            <a href="?page=<%=pageNum%>">Page<%= pageNum%></a>
        <%}%>
        <div>
            <%int pageIndex = Integer.parseInt(pageName) - 1;
                if(pageIndex >strs.size() - 1){
                    pageIndex = strs.size() - 1;
                }
                if(pageIndex < 0){
                    pageIndex = 0;
                }
            %>
            <%=strs.get(pageIndex)%>
            
        </div>
       
    </body>
</html>

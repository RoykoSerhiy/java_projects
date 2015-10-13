<%-- 
    Document   : cookieTest
    Created on : 30.09.2015, 20:03:00
    Author     : Serhiy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Test Cookie</h1>
        <div><a href="/spring2/user/cookie?word=qqqq">qqqq</a></div>
        <div><a href="/spring2/user/cookie?word=wwww">wwww</a></div>
        <div><a href="/spring2/user/cookie?word=eeee">eeee</a></div>
        <div><a href="/spring2/user/cookie?word=rrrr">rrrr</a></div>
        <div><a href="/spring2/user/cookie?word=tttt">tttt</a></div>
        <div>
            new val:${newValue}
            prev val:${oldValue}
        </div>
    </body>
</html>

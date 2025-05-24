<%-- 
    Document   : update
    Created on : May 24, 2025, 7:19:30 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${param.type}" method="GET">
            <input type="number" name="id" value="${param.id}" readonly=""/><br>
            <input type="text" name="name" value="" placeholder="name" required=""/><br>
            <input type="text" name="price" value="" placeholder="price" required=""/><br>
            <input type="text" name="unit" value="" placeholder="unit" required=""/><br>
            <input type="hidden" name="action" value="update"/>
            <input type="submit" value="SAVE" />
            <h2 style="color: red;">${errMsg}</h2>
        </form>
    </body>
</html>

<%-- 
    Document   : add
    Created on : May 24, 2025, 11:17:50 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="${param.type}" method="GET">
            <input type="number" name="id" value="" placeholder="id" required=""/><br>
            <input type="text" name="name" value="" placeholder="name" required=""/><br>
            <input type="text" name="price" value="" placeholder="price" required=""/><br>
            <input type="text" name="unit" value="" placeholder="unit" required=""/><br>
            <input type="hidden" name="action" value="add"/>
            <input type="submit" value="ADD" />
            <h2 style="color: red;">${errMsg}</h2>
        </form>
    </body>
</html>

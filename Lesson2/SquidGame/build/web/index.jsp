<%-- 
    Document   : newjsp
    Created on : May 9, 2025, 1:23:32 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Cal+Sans&display=swap" rel="stylesheet">
        <title>Squid Game</title>
    </head>
    <body>
        <div class="container">
            <p>Become a billionaire rightnow!</p>
            <form action="random" method="GET">
                <label for="user"> - Enter your lucky number - </label>
                <input type="text" name="userInput" id="user" placeholder="Only input 1 - 5">
                <input type="submit" value="Roll">
            </form>
            <h1>${requestScope.msg}</h1>
        </div>
    </body>
</html>

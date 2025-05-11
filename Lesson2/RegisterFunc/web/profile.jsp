<%-- 
    Document   : profile
    Created on : May 9, 2025, 10:32:59 PM
    Author     : ADMIN
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PROFILE PAGE</title>
    </head>
    <body>
        <%
            User user = (User) request.getAttribute("userInfor");
            String[] parts = user.getFullName().split(" ");
            String name = parts[parts.length - 1];
        %>
        <h1>Welcome, <%=name%></h1>
        <table border="2">
            <tbody>
                <tr>
                    <td>FULL NAME</td>
                    <td><%= user.getFullName() %></td>
                </tr>
                <tr>
                    <td>USER NAME</td>
                    <td><%= user.getUserName()%></td>
                </tr>
                <tr>
                    <td>PASSWORD</td>
                    <td><%= user.getPassword()%></td>
                </tr>
                <tr>
                    <td>GMAIL</td>
                    <td><%= user.getGmail()%></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>

<%-- 
    Document   : food
    Created on : May 24, 2025, 3:34:46 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="food" method="GET">
            <label for="">Search</label>
            <input type="hidden" name="action" value="search"/>
            <input type="text" name="search" value="" placeholder="search">
            <button type="submit"><span><ion-icon name="search-outline"></ion-icon></span></button>
        </form>
        <table class="data-table" border="1" style="font-size: large;">
            <tr class="title">
                <td>ID</td>
                <td>NAME</td>
                <td>PRICE</td>
                <td>UNIT</td>
                <td></td>
                <td></td>
            </tr>
            <c:forEach var="i" items="${requestScope.list}">
                <tr>
                    <td>${i.getId()}</td>
                    <td>${i.getName()}</td>
                    <td>${i.getPrice()}</td>
                    <td>${i.getUnit()}</td>
                    <td>
                        <a href="food?action=delete&id=${i.getId()}"><button>DELETE</button></a>
                    </td>
                    <td>
                        <a href="update.jsp?type=food&id=${i.getId()}"><button>UPDATE</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="add.jsp?type=food"><button type="button" style="font-size: 20px;">Add new</button></a>
        <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
        <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>
    </body>
</html>

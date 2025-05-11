<%-- 
    Document   : index
    Created on : May 8, 2025, 2:55:04 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OneTwoThree Game</title>
        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
                font-size: 40px;

            }

            body{
                height: 100vh;
            }

            .container{
                width: 40%;
                height: 100vh;
                border: 1px solid black;
                margin: 0 auto;
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-content: center;
                gap: 30px;
            }

            input[type='submit']{
                width: 40%;
                margin: 0 auto;
            }

            p{
                text-align: center;
            }


        </style>
    </head>
    <body>
        <div class="container">
            <form id="main-form" action="RandomController" method="GET">
                <label for="userChoice">YOU CHOOSE: </label>
                <select name="userChoice" id="userChoice">
                    <c:choose>
                        <c:when test="${requestScope.userChoice == 1}"><option hidden="" value = "1" selected="">PAPER</option></c:when>
                        <c:when test="${requestScope.userChoice == 2}"><option hidden="" value = "2" selected="">ROCK</option></c:when>
                        <c:when test="${requestScope.userChoice == 3}"><option hidden="" value = "3" selected="">SCISSORS</option></c:when>
                    </c:choose>
                    <option value="1">PAPER</option>
                    <option value="2">ROCK</option>
                    <option value="3">SCISSORS</option>
                </select>
            </form>
            <div>
                <label for="machineChoice">MACHINE CHOOSE: </label>
                <select name="machineChoice" id="machineChoice">
                    <c:choose>
                        <c:when test="${requestScope.machineChoice == 1}"><option disabled="" selected="">PAPER</option></c:when>
                        <c:when test="${requestScope.machineChoice == 2}"><option disabled="" selected="">ROCK</option></c:when>
                        <c:when test="${requestScope.machineChoice == 3}"><option disabled="" selected="">SCISSORS</option></c:when>
                    </c:choose>
                </select>
            </div>
            <input type="submit" value="PLAY" form="main-form"/>
            <p>${requestScope.result}</p>
        </div>
    </body>
</html>

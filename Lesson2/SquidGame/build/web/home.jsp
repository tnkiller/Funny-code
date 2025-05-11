<%-- Document : home Created on : May 9, 2025, 1:25:58 AM Author : ADMIN --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HOME</title>
        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            body {
                height: 100vh;
                display: flex;
                flex-flow: column wrap;
                justify-content: center;
                align-items: center;
                background-color: rgb(210, 208, 160);
            }

            p {
                text-align: center;
                color: white;
                text-shadow: 4px 4px 10px rgba(0, 0, 0, 0.25);
                font-size: 50px;
            }
        </style>
    </head>

    <body>
        <p>LUCKY NUMBER TODAY : ${requestScope.luckyNum}</p>
        <p>${requestScope.msg}</p>
    </body>

</html>
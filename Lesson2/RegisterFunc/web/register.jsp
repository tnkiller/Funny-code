<%-- 
    Document   : index
    Created on : May 9, 2025, 10:22:54 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link rel="stylesheet" href="style.css">-->
        <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/2.6.0/uicons-regular-rounded/css/uicons-regular-rounded.css'>
        <link rel='stylesheet' href='https://cdn-uicons.flaticon.com/2.6.0/uicons-solid-rounded/css/uicons-solid-rounded.css'>
        <title>Register</title>
    </head>
    <body>
    <body>
        <div class="container">
            <i class="fi fi-rr-user"></i>
            <form action="RegisterController" method="POST">
                <div>
                    <label for="full_name"><i class="fi fi-sr-circle-a"></i></label>
                    <input type="text" name="fullname" id="full_name" placeholder="fullname">
                </div>

                <div>
                    <label for="username"><i class="fi fi-sr-user"></i></label>
                    <input type="text" name="username" id="username" placeholder="username">
                </div>

                <div>
                    <label for="password"><i class="fi fi-sr-lock"></i></label>
                    <input type="password" name="password" id="password" placeholder="password">
                </div>

                <div>
                    <label for="mail"><i class="fi fi-sr-envelope"></i></label>
                    <input type="text" name="email" id="mail" placeholder="email">
                </div>
                <input type="submit" value="register">
                <%
                    String msg = (String) request.getAttribute("errMsg");
                %>
                <h2><%= (msg != null) ? msg : ""%></h2>
            </form>

        </div>
    </body>
</body>
</html>

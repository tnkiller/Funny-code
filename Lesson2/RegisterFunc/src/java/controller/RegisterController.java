package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

@WebServlet(urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fullName = request.getParameter("fullname");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        //handle exception from user
        if (fullName.isEmpty() || userName.isEmpty() || password.isEmpty() || email.isEmpty()) {
            request.setAttribute("errMsg", "Please fulfill all fields in form!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        if (!email.endsWith("@gmail.com")) {
            request.setAttribute("errMsg", "Please enter correct format of email(ex: abcxyz@gmail.com)");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
        User u = new User(fullName, userName, password, email);
        request.setAttribute("userInfor", u);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }

}

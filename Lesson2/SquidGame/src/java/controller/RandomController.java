/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Random;

@WebServlet(name = "mainController", urlPatterns = {"/random"})
public class RandomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int luckyNum = new Random().nextInt(1, 6);
        int userNumber = 0;

        //handle exception from user
        String userInput = request.getParameter("userInput");
        if (userInput.isEmpty()) {
            request.setAttribute("msg", "Please don't input empty string!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        try {
            userNumber = Integer.parseInt(userInput);
            if (userNumber < 1 || userNumber > 5) {
                request.setAttribute("msg", "Only input from 1 to 5! OK? ");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (NumberFormatException nfe) {
            request.setAttribute("msg", "Are you kidding me, please input a number bro!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        //main processing
        if (userNumber == luckyNum) {
            request.setAttribute("msg", "Amazing! Lucky boy!");
        } else {
            request.setAttribute("msg", "Oops! No luck for you! :<");
        }
        request.setAttribute("luckyNum", luckyNum);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

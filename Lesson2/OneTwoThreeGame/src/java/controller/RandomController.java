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

@WebServlet(name = "RandomController", urlPatterns = {"/RandomController"})
public class RandomController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int userChoice = Integer.parseInt(request.getParameter("userChoice"));
        int machineChoice = new Random().nextInt(1, 4);

        //compare result -> decision
        if (userChoice == machineChoice) {
            request.setAttribute("result", "DRAW");
        } else {
            switch (userChoice) {
                case 1 -> {
                    request.setAttribute("result", (machineChoice == 3) ? "YOU LOSE" : "YOU WIN");
                }
                case 2 -> {
                    request.setAttribute("result", (machineChoice == 1) ? "YOU LOSE" : "YOU WIN");
                }
                case 3 -> {
                    request.setAttribute("result", (machineChoice == 2) ? "YOU LOSE" : "YOU WIN");
                }
            }
        }
        request.setAttribute("userChoice", userChoice);
        request.setAttribute("machineChoice", machineChoice);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}

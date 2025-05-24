/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import constant.Message;
import constant.PageLink;
import dal.FoodDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Food;

@WebServlet(name = "FoodController", urlPatterns = {"/food"})
public class FoodController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchFood(request, response);
                break;
            case "add":
                addNewFood(request, response);
                break;
            case "delete":
                deleteFood(request, response);
                break;
            case "update":
                updateFood(request, response);
                break;
            default:
                showAllFoods(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //show all
    private void showAllFoods(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", new FoodDAO().getAllFoods());
        request.getRequestDispatcher(PageLink.FOOD_PAGE).forward(request, response);
    }

    //add
    private void addNewFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRaw = request.getParameter("id");
        String nameRaw = request.getParameter("name");
        String priceRaw = request.getParameter("price");
        String unitRaw = request.getParameter("unit");

        Food o = new Food();
        o.setId(Integer.parseInt(idRaw));
        FoodDAO dr = new FoodDAO();

        if (dr.getFoodById(o) != null) {
            request.setAttribute("errMsg", "This ID existed!Please try another");
            request.getRequestDispatcher(PageLink.ADD_PAGE).forward(request, response);
            return;
        }
        try {
            double price = Double.parseDouble(priceRaw);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errMsg", Message.NUMBER_FORMAT_ERR);
            request.getRequestDispatcher(PageLink.ADD_PAGE).forward(request, response);
            return;
        }
        dr.createFood(new Food(Integer.parseInt(idRaw), nameRaw, Double.parseDouble(priceRaw), unitRaw));
        showAllFoods(request, response);
    }

    //delete
    private void deleteFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Food o = new Food();
        o.setId(Integer.parseInt(id));
        new FoodDAO().deleteFood(o);
        showAllFoods(request, response);
    }

    //update
    private void updateFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameRaw = request.getParameter("name");
        String priceRaw = request.getParameter("price");
        String unitRaw = request.getParameter("unit");
        String id = request.getParameter("id");

        FoodDAO dr = new FoodDAO();

        try {
            double price = Double.parseDouble(priceRaw);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errMsg", Message.NUMBER_FORMAT_ERR);
            request.getRequestDispatcher(PageLink.UPDATE_PAGE).forward(request, response);
            return;
        }
        dr.updateFood(new Food(Integer.parseInt(id), nameRaw, Double.parseDouble(priceRaw), unitRaw));
        showAllFoods(request, response);
    }

    //search
    private void searchFood(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("search");
        FoodDAO dr = new FoodDAO();
        request.setAttribute("list", dr.getFoodsByName(searchName));
        request.getRequestDispatcher("Food.jsp").forward(request, response);
    }

}

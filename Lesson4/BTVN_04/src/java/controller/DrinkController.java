/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import constant.Message;
import constant.PageLink;
import dal.DrinkDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Drink;

@WebServlet(name = "DrinkController", urlPatterns = {"/drink"})
public class DrinkController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                searchDrink(request, response);
                break;
            case "add":
                addNewDrink(request, response);
                break;
            case "delete":
                deleteDrink(request, response);
                break;
            case "update":
                updateDrink(request, response);
                break;
            default:
                showAllDrinks(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    //show all
    private void showAllDrinks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", new DrinkDAO().getAllDrinks());
        request.getRequestDispatcher(PageLink.DRINK_PAGE).forward(request, response);
    }

    //add
    private void addNewDrink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idRaw = request.getParameter("id");
        String nameRaw = request.getParameter("name");
        String priceRaw = request.getParameter("price");
        String unitRaw = request.getParameter("unit");

        Drink o = new Drink();
        o.setId(Integer.parseInt(idRaw));
        DrinkDAO dr = new DrinkDAO();

        if (dr.getDrinkById(o) != null) {
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
        dr.createDrink(new Drink(Integer.parseInt(idRaw), nameRaw, Double.parseDouble(priceRaw), unitRaw));
        showAllDrinks(request, response);
    }

    //delete
    private void deleteDrink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Drink o = new Drink();
        o.setId(Integer.parseInt(id));
        new DrinkDAO().deleteDrink(o);
        showAllDrinks(request, response);
    }

    //update
    private void updateDrink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameRaw = request.getParameter("name");
        String priceRaw = request.getParameter("price");
        String unitRaw = request.getParameter("unit");
        String id = request.getParameter("id");

        DrinkDAO dr = new DrinkDAO();

        try {
            double price = Double.parseDouble(priceRaw);
        } catch (NumberFormatException nfe) {
            request.setAttribute("errMsg", Message.NUMBER_FORMAT_ERR);
            request.getRequestDispatcher(PageLink.UPDATE_PAGE).forward(request, response);
            return;
        }
        dr.updateDrink(new Drink(Integer.parseInt(id), nameRaw, Double.parseDouble(priceRaw), unitRaw));
        showAllDrinks(request, response);
    }

    //search
    private void searchDrink(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchName = request.getParameter("search");
        DrinkDAO dr = new DrinkDAO();
        request.setAttribute("list", dr.getDrinksByName(searchName));
        request.getRequestDispatcher("drink.jsp").forward(request, response);
    }
}

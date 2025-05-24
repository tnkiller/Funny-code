/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Drink;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DrinkDAO extends DBConnect {

    private final String GET_ALL_DRINKS_SQL = "SELECT * FROM Drink";
    private final String GET_DRINK_SQL = "SELECT * FROM Drink WHERE id = ?";
    private final String CREATE_DRINK_SQL = "INSERT INTO Drink VALUES (?,?,?,?)";
    private final String DELETE_DRINK_SQL = "DELETE FROM Drink WHERE id = ?";
    private final String UPDATE_DRINK_SQL = "UPDATE Drink SET name = ?, price = ?, unit = ? WHERE id = ?";
    private final String SEARCH_DRINK_SQL = "SELECT * FROM Drink WHERE name LIKE ?";

    //CRUD
    public List<Drink> getAllDrinks() {
        List<Drink> result = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement(GET_ALL_DRINKS_SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Drink(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("unit")));
            }
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }

    public List<Drink> getDrinksByName(String name) {
        List<Drink> result = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement(SEARCH_DRINK_SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Drink(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("unit")));
            }
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Drink getDrinkById(Drink o) {
        try {
            PreparedStatement ps = c.prepareStatement(GET_DRINK_SQL);
            ps.setInt(1, o.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Drink(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("unit"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int createDrink(Drink o) {
        try {
            PreparedStatement ps = c.prepareStatement(CREATE_DRINK_SQL);
            ps.setInt(1, o.getId());
            ps.setString(2, o.getName());
            ps.setDouble(3, o.getPrice());
            ps.setString(4, o.getUnit());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int deleteDrink(Drink o) {
        try {
            PreparedStatement ps = c.prepareStatement(DELETE_DRINK_SQL);
            ps.setInt(1, o.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int updateDrink(Drink o) {
        try {
            PreparedStatement ps = c.prepareStatement(UPDATE_DRINK_SQL);
            ps.setString(1, o.getName());
            ps.setDouble(2, o.getPrice());
            ps.setString(3, o.getUnit());
            ps.setInt(4, o.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

}

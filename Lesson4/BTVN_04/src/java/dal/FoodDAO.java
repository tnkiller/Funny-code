/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Drink;
import model.Food;

/**
 *
 * @author ADMIN
 */
public class FoodDAO extends DBConnect {

    private final String GET_ALL_FOODS_SQL = "SELECT * FROM Food";
    private final String GET_FOOD_SQL = "SELECT * FROM Food WHERE id = ?";
    private final String CREATE_FOOD_SQL = "INSERT INTO Food VALUES (?,?,?,?)";
    private final String DELETE_FOOD_SQL = "DELETE FROM Food WHERE id = ?";
    private final String UPDATE_FOOD_SQL = "UPDATE Food SET name = ?, price = ?, unit = ? WHERE id = ?";
    private final String SEARCH_FOOD_SQL = "SELECT * FROM Food WHERE name LIKE ?";

    //CRUD
    public List<Food> getAllFoods() {
        List<Food> result = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement(GET_ALL_FOODS_SQL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("unit")));
            }
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public List<Food> getFoodsByName(String name) {
        List<Food> result = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement(SEARCH_FOOD_SQL);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Food(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("unit")));
            }
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }

    public Food getFoodById(Food o) {
        try {
            PreparedStatement ps = c.prepareStatement(GET_FOOD_SQL);
            ps.setInt(1, o.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Food(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getString("unit"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int createFood(Food o) {
        try {
            PreparedStatement ps = c.prepareStatement(CREATE_FOOD_SQL);
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

    public int deleteFood(Food o) {
        try {
            PreparedStatement ps = c.prepareStatement(DELETE_FOOD_SQL);
            ps.setInt(1, o.getId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public int updateFood(Food o) {
        try {
            PreparedStatement ps = c.prepareStatement(UPDATE_FOOD_SQL);
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

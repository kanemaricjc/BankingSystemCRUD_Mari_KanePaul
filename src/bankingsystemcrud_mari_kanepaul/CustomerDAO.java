/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankingsystemcrud_mari_kanepaul;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Kane
 */
public class CustomerDAO {
    
    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (first_name, last_name, email, phone_number) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, customer.getFname());
            stmt.setString(2, customer.getLname());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhonenumber());
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        return false;
        }
    }
    
    public List<Customer> getAllCustomers() {
    List<Customer> customers = new ArrayList<>();
    String sql = "SELECT * FROM customer";
    try (Connection conn = DBConnection.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            Customer customer = new Customer();
            customer.setCustomerid(rs.getInt("customer_id"));
            customer.setFname(rs.getString("first_name"));
            customer.setLname(rs.getString("last_name"));
            customer.setEmail(rs.getString("email"));
            customer.setPhonenumber(rs.getString("phone_number"));
            customers.add(customer);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return customers;
}
    
    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE Customer SET first_name=?, last_name=?, email=?, phone_number=? WHERE customer_id=?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, customer.getFname());
            stmt.setString(2, customer.getLname());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getPhonenumber());
            stmt.setInt(5, customer.getCustomerid());
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteCustomer(int customerid) {
        String sql = "DELETE FROM Customer WHERE customer_id = ?";
        try (Connection conn = DBConnection.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, customerid);
            int rowsAffected = stmt.executeUpdate();
            
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}

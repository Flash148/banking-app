package com.bank.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.bank.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer create(Customer customer) {
        Customer createdCustomer = null;
        String query = "INSERT INTO customers (first_name, last_name, username, password_hash) VALUES (?, ?, ?, ?) RETURNING customer_id";


        try (java.sql.Connection conn = com.bank.util.ConnectionUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, customer.getFirstName());
                    ps.setString(2, customer.getLastName());
                    ps.setString(3, customer.getUsername());
                    ps.setString(4, customer.getPasswordHash());
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        int generatedId = rs.getInt("customer_id");
                        createdCustomer = findById(generatedId);
                    }
                    return createdCustomer;
                } catch (java.sql.SQLException e) {
                    throw new RuntimeException("Error creating customer", e);
                }
        
    }

    @Override 
    public Customer findById(int customerId) {
        Customer foundCustomer = null;
        String query = "SELECT * FROM customers WHERE customer_id = ?";
        try (java.sql.Connection conn = com.bank.util.ConnectionUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                foundCustomer = new Customer();
                foundCustomer.setCustomerId(rs.getInt("customer_id"));
                foundCustomer.setFirstName(rs.getString("first_name"));
                foundCustomer.setLastName(rs.getString("last_name"));
                foundCustomer.setUsername(rs.getString("username"));
                foundCustomer.setPasswordHash(rs.getString("password_hash"));
            }
        } catch (java.sql.SQLException e) {
            throw new RuntimeException("Error finding customer by ID", e);
        }
        return foundCustomer;
    }


    @Override
    public Customer findByUsername(String username) {
        Customer foundCustomer = null;
        String query = "SELECT * FROM customers WHERE username = ?";
        try (java.sql.Connection conn = com.bank.util.ConnectionUtil.getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {
                    ps.setString(1, username);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        int customerId = rs.getInt("customer_id");
                        foundCustomer = findById(customerId);
                    }
                } catch (java.sql.SQLException e) {
                    throw new RuntimeException("Error finding customer by username", e);
                }
        return foundCustomer;
    }


    @Override
    public void update(Customer customer) {
        
    }


    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }
}

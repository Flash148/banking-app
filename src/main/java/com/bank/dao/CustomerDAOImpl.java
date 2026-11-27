package com.bank.dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.bank.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public Customer create(Customer customer) {
        Customer createdCustomer = null;
        String query = "INSERT INTO customers (firstName, lastName, username, passwordHash) VALUES (?, ?, ?, ?)";


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
        return null;
    }


    @Override
    public Customer findByUsername(String username) {
        return null;
    }


    @Override
    public void update(Customer customer) {
        
    }


    @Override
    public List<Customer> searchByName(String name) {
        return null;
    }
}

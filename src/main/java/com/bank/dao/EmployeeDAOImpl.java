package com.bank.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.model.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override 
    public Employee create(Employee employee) {
        Employee emp = null;
        String query = "INSERT INTO employees (first_name, last_name, username, password_hash) VALUES (?, ?, ?, ?) RETURNING employee_id";

        try (java.sql.Connection conn = com.bank.util.ConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, employee.getFirstName());
            ps.setString(2, employee.getLastName());
            ps.setString(3, employee.getUsername());
            ps.setString(4, employee.getPasswordHash());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int generatedId = rs.getInt("employee_id");
                emp = findById(generatedId);
            }
            return emp;
        } catch (java.sql.SQLException e) {
            throw new RuntimeException("Error creating employee: " + employee.getUsername(), e);
        }
    }
    
    @Override 
    public Employee findById(int employeeId) {
        Employee emp = null;
        String query = "SELECT * FROM employees WHERE employee_id = ?";

        try (Connection conn = com.bank.util.ConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new Employee();
                emp.setEmployeeId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setUsername(rs.getString("username"));
                emp.setPasswordHash(rs.getString("password_hash"));
                return emp;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding employee: " + employeeId, e);
        }
    }


    @Override 
    public Employee findByUsername(String username) {
        Employee emp = null;
        String query = "SELECT * FROM employees WHERE username = ?";

        try (Connection conn = com.bank.util.ConnectionUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp = new Employee();
                emp.setEmployeeId(rs.getInt("employee_id"));
                emp.setFirstName(rs.getString("first_name"));
                emp.setLastName(rs.getString("last_name"));
                emp.setUsername(rs.getString("username"));
                emp.setPasswordHash(rs.getString("password_hash"));
                return emp;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error finding employee by username: " + username, e);
        }
    }
}

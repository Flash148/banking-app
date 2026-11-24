package com.bank.model;
import java.time.LocalDateTime;



public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String passwordHash;
    private String username;


    public Employee(int employeeId, String firstName, String lastName, String passwordHash, String username, LocalDateTime createdAt) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }


    public int getEmployeeId() {
        return employeeId;
    }


    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getPasswordHash() {
        return passwordHash;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}

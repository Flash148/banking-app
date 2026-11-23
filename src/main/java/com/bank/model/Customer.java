package com.bank.model;
import java.time.LocalDateTime;


public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private String passwordHash;
    private String username;
    private LocalDateTime createdAt;


    public Customer(int customerId, String firstName, String lastName, String passwordHash, String username, LocalDateTime createdAt) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.username = username;
        this.createdAt = createdAt;
    }

    public Customer(String firstName, String lastName, String passwordHash, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passwordHash = passwordHash;
        this.username = username;
    }


    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

   public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getUsername() {
        return username;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

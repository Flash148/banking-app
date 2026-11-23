package com.bank.account;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Account {
    private int accountNum;
    private int customerId;
    private AccountType accountType;
    private AccountStatus status;
    private BigDecimal balance;
    private LocalDateTime createdAt;

    public Account(int accountNum, int customerId, AccountType accountType, AccountStatus status, BigDecimal balance,
            LocalDateTime createdAt) {
        this.accountNum = accountNum;
        this.customerId = customerId;
        this.accountType = accountType;
        this.status = status;
        this.balance = balance;
        this.createdAt = createdAt;
    }

    public Account() {
    }
    
    public int getAccountNum() {
        return accountNum;
    }

    public int getCustomerId() {
        return customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    
}

package com.bank.model;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class Transaction {
    private int transactionId;
    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime createdAt;
    private Integer initiatedByEmployeeId;
    private int accountNum;
    private BigDecimal resultingBalance;

    public Transaction(int transactionId, TransactionType transactionType, BigDecimal amount, LocalDateTime createdAt, Integer initiatedByEmployeeId, int accountNum, BigDecimal resultingBalance) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
        this.createdAt = createdAt;
        this.initiatedByEmployeeId = initiatedByEmployeeId;
        this.accountNum = accountNum;
        this.resultingBalance = resultingBalance;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public Integer getInitiatedByEmployeeId() {
        return initiatedByEmployeeId;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public BigDecimal getResultingBalance() {
        return resultingBalance;
    }

}
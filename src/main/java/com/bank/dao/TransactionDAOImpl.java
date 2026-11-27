package com.bank.dao;

import java.math.BigDecimal;
import java.util.List;

import com.bank.model.Transaction;
import com.bank.model.TransactionType;

public class TransactionDAOImpl implements TransactionDAO {
    @Override 
    public Transaction create(Transaction transaction) {
        return null;
    }

    @Override 
    public List<Transaction> findByAccountNum(int accountNum) {
        return null;
    }

    @Override 
    public List<Transaction> findByAccountNumAndType(int accountNum, TransactionType type) {
        return null;
    }

    @Override 
    public void transfer(int fromAccountNum, int toAccountNum, BigDecimal amount, Integer initiatedByEmployeeId) {
        // Implementation for transferring funds between accounts
    }
    
}

package com.bank.dao;
import java.math.BigDecimal;
import java.util.List;

import com.bank.model.Transaction;


public interface TransactionDAO {

    Transaction create(Transaction transaction);

    List<Transaction> findByAccountNum(int accountNum);

    List<Transaction> findByAccountNumAndType(int accountNum, String type);

    void transfer(int fromAccountNum, int toAccountNum, BigDecimal amount, Integer initiatedByEmployeeId);
    
}

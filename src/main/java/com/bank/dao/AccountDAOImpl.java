package com.bank.dao;
import java.math.BigDecimal;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.AccountStatus;

public class AccountDAOImpl implements AccountDAO {
    @Override 
    public Account create(Account account) {
        return null;
    }

    @Override 
    public Account findById(int accountNum) {
        return null;
    }

    @Override 
    public List<Account> findByCustomerId(int customerId) {
        return null;
    }

    @Override 
    public void changeStatus(int accountNum, AccountStatus status) {
        
    }

    @Override 
    public void changeBalance(int accountNum, BigDecimal balance) {
    
    }
    
}

package com.bank.dao;
import java.math.BigDecimal;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.AccountStatus;

public interface AccountDAO {

    // create an account and save it
    Account create(Account account);

    //Find one account by its number
    Account findById(int accountNum);

    //Find all accounts for a specific customer
    List<Account> findByCustomerId(int customerId);

    //Change account's status
    void changeStatus(int accountNum, AccountStatus status);

    //Change an account's balance
    void changeBalance(int accountNum, BigDecimal balance);
    
}

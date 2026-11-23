package com.bank.dao;
import java.util.List;

import com.bank.model.Account;

public interface AccountDAO {

    // create an account and save it
    Account create(Account account);

    //Find one account by its number
    Account findBYId(int accountId);

    //Find all accounts for a specific customer
    List<Account> findByCustomerId(int customerId);

    //Change account's status
    Account changeStatus(int accountId, String status);

    //Change an account's balance
    Account changeBalance(int accountId, double balance);
    
}

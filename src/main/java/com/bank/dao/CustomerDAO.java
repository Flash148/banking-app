package com.bank.dao;
import java.util.List;

import com.bank.model.Customer;



public interface CustomerDAO {

    //US-01: Create a new customer record
    Customer create(Customer customer);

    //US-01: Check if username is taken US-02: customer login. Return null if not found
    Customer findByUsername(String username); 

    //US-20: employee looks upa customer - return null if not found. 
    Customer findById(int customerId);

    //US-03: Customer can save profile changes
    void update(Customer customer);

    //US-20: employee searches customer by name
    List<Customer> searchByName(String name);


    //boolean delete(int customerId);

}

package com.bank.dao;
import com.bank.model.Employee;

public interface EmployeeDAO {

    Employee create(Employee employee);

    Employee findById(int employeeId);

    Employee findByUsername(String username);

}

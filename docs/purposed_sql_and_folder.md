# Start of planning
## Database
- PostgreSQL
    
    ** Since customers can self serve or have an employee aided transaction and that should kept track of that,
    i think one user table for both is a better setup. furthermore they share almost all the same columns.

    - users table                       ** customers and employees in one table
        - user_id (PK)
        - user_name                     ** unique
        - first_name
        - last_name
        - phone
        - address
        - role                          ** customer or employee
        - status                        ** active or disabled
        - created_at
        - created_by_user_id (FK, null) ** null if self registered
        - password_hash

    - accounts table                    ** one customer many accounts
        - account_id (PK)
        - user_id (FK)                  ** account owner, must be customer
        - created_at
        - created_by_user_id (FK)       ** customer or employee who opened account
        - account_type                  ** checking or savings
        - balance                       ** numeric(15,2), cannot be negative
        - status                        ** active, closed or frozen

    - transactions table                ** one account one record, transfers create two records
        - transaction_id (PK)
        - related_transaction_id (FK, null)     ** links both sides of transfer
        - account_id (FK)                       ** account affected by this record
        - source_account_id (FK, null)          ** null for external deposit
        - destination_account_id (FK, null)     ** null for external withdraw
        - type                                  ** dep, with, transfer_in, transfer_out, wire_in, wire_out
        - amount                                ** numeric(15,2), positive for incoming, negative for outgoing
        - created_at
        - created_by_user_id (FK)               ** customer or employee who initiated transaction
        - resulting_balance                     ** balance of account_id after transaction

## folder layout

- src/main/java/com/brokebankapp/
    - Main.java
    
    - config/                       ** Config layer
        - ...
    
    - customer/
        - Customer.java             ** Model layer
        - CustomerDao.Java          ** Data Access layer
        - JdbcCustomerDao.Java      ** Data Access layer
        - CustomerService.java      ** service layer
        - CustomerMenu.java         ** Presentation layer
    
    - employee/
        - Employee.java              ** Model layer
        - EmployeeDao.java           ** Data Access layer
        - JdbcEmployeeDao.java       ** Data Access layer
        - EmployeeService.java       ** Service layer
        - EmployeeMenu.java          ** Presentation layer

    - account/
        - Account.java               ** Model layer
        - AccountDao.java            ** Data Access layer
        - JdbcAccountDao.java        ** Data Access layer
        - AccountService.java        ** Service layer
        - AccountMenu.java           ** Presentation layer

    - transaction/
        - Transaction.java           ** Model layer
        - TransactionDao.java        ** Data Access layer
        - JdbcTransactionDao.java    ** Data Access layer
        - TransactionService.java    ** Service layer
        - TransactionMenu.java       ** Presentation layer
    - note/
        - ...
    
    - audit/
        - ...

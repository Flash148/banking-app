CREATE TABLE IF NOT EXISTS Accounts (
    Account_num INT PRIMARY KEY REFERENCES Customers(customer_id), 
    Account_balance DECIMAl(10, 2) CHECK (Account_balance >= 0),
    Account__type VARCHAR(50) NOT NULL CHECK (Account_type IN ('Checking', 'Savings')),
    Account_status VARCHAR(20) NOT NULL DEFAULT 'Active', CHECK (Account_status IN ('Active', 'Frozen', 'Closed')),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS Customers (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
);


CREATE TABLE IF NOT EXISTS Employees (
    employee_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL UNIQUE,
);


CREATE TABLE IF NOT EXISTS Transactions (
    transaction_id INT PRIMARY KEY,
    account_num INT NOT NULL REFERENCES Accounts(account_num),
    transaction_amount DECIMAL(10, 2) NOT NULL CHECK (transaction_amount >= 0),
    account_type VARCHAR(50) NOT NULL CHECK (account_type IN ('Checking', 'Savings')),
    account_status VARCHAR(20) NOT NULL DEFAULT 'Active',
    CONSTRAINT account_status_fk
    FOREIGN KEY (account_status) REFERENCES Accounts(account_status) CHECK (account_status = 'Active'), 
    initiated_by INT NOT NULL REFERENCES Employees(employee_id)
);
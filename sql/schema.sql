CREATE TABLE IF NOT EXISTS customers (
    customer_id    SERIAL PRIMARY KEY,
    username       VARCHAR(50)  NOT NULL UNIQUE,
    first_name     VARCHAR(50)  NOT NULL,
    last_name      VARCHAR(50)  NOT NULL,
    password_hash  VARCHAR(255) NOT NULL,
    created_at     TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS employees (
    employee_id    SERIAL PRIMARY KEY,
    username       VARCHAR(50)  NOT NULL UNIQUE,
    first_name     VARCHAR(50)  NOT NULL,
    last_name      VARCHAR(50)  NOT NULL,
    password_hash  VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts (
    account_num    SERIAL PRIMARY KEY,
    customer_id    INT            NOT NULL,
    account_type   VARCHAR(20)    NOT NULL CHECK (account_type IN ('CHECKING', 'SAVINGS')),
    balance        NUMERIC(15, 2) NOT NULL DEFAULT 0 CHECK (balance >= 0),
    status         VARCHAR(20)    NOT NULL DEFAULT 'ACTIVE'
                                  CHECK (status IN ('ACTIVE', 'FROZEN', 'CLOSED')),
    created_at     TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_accounts_customer
        FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE IF NOT EXISTS transactions (
    transaction_id            SERIAL PRIMARY KEY,
    account_num               INT            NOT NULL,
    transaction_type          VARCHAR(20)    NOT NULL
                              CHECK (transaction_type IN ('DEPOSIT', 'WITHDRAWAL',
                                                          'TRANSFER_IN', 'TRANSFER_OUT',
                                                          'WIRE_IN', 'WIRE_OUT')),
    amount                    NUMERIC(15, 2) NOT NULL CHECK (amount > 0),
    resulting_balance         NUMERIC(15, 2) NOT NULL CHECK (resulting_balance >= 0),
    initiated_by_employee_id  INT,           -- NULL = the customer did it themselves
    created_at                TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_transactions_account
        FOREIGN KEY (account_num) REFERENCES accounts(account_num),
    CONSTRAINT fk_transactions_employee
        FOREIGN KEY (initiated_by_employee_id) REFERENCES employees(employee_id)
);
INSERT INTO Customers
VALUES (
    1,
    'John Doe',
    TO_DATE('1955-05-15','YYYY-MM-DD'),
    12000,
    SYSDATE,
    'FALSE'
);

INSERT INTO Customers
VALUES (
    2,
    'Jane Smith',
    TO_DATE('1990-07-20','YYYY-MM-DD'),
    1500,
    SYSDATE,
    'FALSE'
);

INSERT INTO Customers
VALUES (
    3,
    'Robert King',
    TO_DATE('1948-10-05','YYYY-MM-DD'),
    18000,
    SYSDATE,
    'FALSE'
);

INSERT INTO Accounts
VALUES (
    1,
    1,
    'Savings',
    12000,
    SYSDATE
);

INSERT INTO Accounts
VALUES (
    2,
    2,
    'Checking',
    1500,
    SYSDATE
);

INSERT INTO Accounts
VALUES (
    3,
    3,
    'Savings',
    18000,
    SYSDATE
);

INSERT INTO Transactions
VALUES (
    1,
    1,
    SYSDATE,
    200,
    'Deposit'
);

INSERT INTO Transactions
VALUES (
    2,
    2,
    SYSDATE,
    300,
    'Withdrawal'
);

INSERT INTO Transactions
VALUES (
    3,
    3,
    SYSDATE,
    1000,
    'Deposit'
);

INSERT INTO Loans
VALUES (
    1,
    1,
    5000,
    5,
    SYSDATE,
    SYSDATE + 20
);

INSERT INTO Loans
VALUES (
    2,
    2,
    8000,
    7,
    SYSDATE,
    ADD_MONTHS(SYSDATE,24)
);

INSERT INTO Loans
VALUES (
    3,
    3,
    15000,
    6,
    SYSDATE,
    SYSDATE + 10
);

INSERT INTO Employees
VALUES (
    1,
    'Alice Johnson',
    'Manager',
    70000,
    'HR',
    TO_DATE('2015-06-15','YYYY-MM-DD')
);

INSERT INTO Employees
VALUES (
    2,
    'Bob Brown',
    'Developer',
    60000,
    'IT',
    TO_DATE('2017-03-20','YYYY-MM-DD')
);

COMMIT;
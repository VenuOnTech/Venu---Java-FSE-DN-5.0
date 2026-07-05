/* Package Specification */

CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customerId NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    );

    PROCEDURE UpdateCustomer(
        p_customerId NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_customerId NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/

/* Package Body */

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customerId NUMBER,
        p_name VARCHAR2,
        p_dob DATE,
        p_balance NUMBER
    )
    AS
    BEGIN
        INSERT INTO Customers
        VALUES (
            p_customerId,
            p_name,
            p_dob,
            p_balance,
            SYSDATE
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Customer Added Successfully.');
    END AddCustomer;


    PROCEDURE UpdateCustomer(
        p_customerId NUMBER,
        p_name VARCHAR2,
        p_balance NUMBER
    )
    AS
    BEGIN
        UPDATE Customers
        SET Name = p_name,
            Balance = p_balance,
            LastModified = SYSDATE
        WHERE CustomerID = p_customerId;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Customer Updated Successfully.');
    END UpdateCustomer;


    FUNCTION GetCustomerBalance(
        p_customerId NUMBER
    )
    RETURN NUMBER
    AS
        v_balance NUMBER;
    BEGIN
        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE CustomerID = p_customerId;

        RETURN v_balance;
    END GetCustomerBalance;

END CustomerManagement;
/
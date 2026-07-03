CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customerId IN NUMBER,
    p_name       IN VARCHAR2,
    p_dob        IN DATE,
    p_balance    IN NUMBER
)
AS
BEGIN
    INSERT INTO Customers (
        CustomerID,
        Name,
        DOB,
        Balance,
        LastModified,
        IsVIP
    )
    VALUES (
        p_customerId,
        p_name,
        p_dob,
        p_balance,
        SYSDATE,
        'FALSE'
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer added successfully.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: Customer ID already exists.');

    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/
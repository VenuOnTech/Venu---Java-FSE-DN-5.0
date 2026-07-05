/* Package Specification */

CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountId NUMBER,
        p_customerId NUMBER,
        p_accountType VARCHAR2,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_accountId NUMBER
    );

    FUNCTION GetTotalBalance(
        p_customerId NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/

/* Package Body */

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_accountId NUMBER,
        p_customerId NUMBER,
        p_accountType VARCHAR2,
        p_balance NUMBER
    )
    AS
    BEGIN

        INSERT INTO Accounts
        VALUES(
            p_accountId,
            p_customerId,
            p_accountType,
            p_balance,
            SYSDATE
        );

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Account Opened Successfully.');

    END OpenAccount;


    PROCEDURE CloseAccount(
        p_accountId NUMBER
    )
    AS
    BEGIN

        DELETE FROM Accounts
        WHERE AccountID = p_accountId;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Account Closed Successfully.');

    END CloseAccount;


    FUNCTION GetTotalBalance(
        p_customerId NUMBER
    )
    RETURN NUMBER
    AS
        v_total NUMBER;
    BEGIN

        SELECT SUM(Balance)
        INTO v_total
        FROM Accounts
        WHERE CustomerID = p_customerId;

        RETURN NVL(v_total,0);

    END GetTotalBalance;

END AccountOperations;
/
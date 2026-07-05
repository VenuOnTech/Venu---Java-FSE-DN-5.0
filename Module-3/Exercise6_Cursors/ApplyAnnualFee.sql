SET SERVEROUTPUT ON;

DECLARE
    v_fee NUMBER := 200;

    CURSOR ApplyAnnualFee IS
        SELECT AccountID, Balance
        FROM Accounts
        FOR UPDATE;

    rec ApplyAnnualFee%ROWTYPE;

BEGIN
    OPEN ApplyAnnualFee;

    LOOP
        FETCH ApplyAnnualFee INTO rec;
        EXIT WHEN ApplyAnnualFee%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee
        WHERE CURRENT OF ApplyAnnualFee;

        DBMS_OUTPUT.PUT_LINE(
            'Annual fee deducted from Account ID: ' ||
            rec.AccountID
        );
    END LOOP;

    CLOSE ApplyAnnualFee;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Annual fee applied successfully.');
END;
/
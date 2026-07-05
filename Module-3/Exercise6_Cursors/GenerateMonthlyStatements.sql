SET SERVEROUTPUT ON;

DECLARE
    CURSOR GenerateMonthlyStatements IS
        SELECT
            C.CustomerID,
            C.Name,
            T.TransactionID,
            T.TransactionDate,
            T.Amount,
            T.TransactionType
        FROM Customers C
        JOIN Accounts A
            ON C.CustomerID = A.CustomerID
        JOIN Transactions T
            ON A.AccountID = T.AccountID
        WHERE EXTRACT(MONTH FROM T.TransactionDate) =
              EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM T.TransactionDate) =
              EXTRACT(YEAR FROM SYSDATE);

    rec GenerateMonthlyStatements%ROWTYPE;

BEGIN
    OPEN GenerateMonthlyStatements;

    LOOP
        FETCH GenerateMonthlyStatements INTO rec;
        EXIT WHEN GenerateMonthlyStatements%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('----------------------------------------');
        DBMS_OUTPUT.PUT_LINE('Customer ID      : ' || rec.CustomerID);
        DBMS_OUTPUT.PUT_LINE('Customer Name    : ' || rec.Name);
        DBMS_OUTPUT.PUT_LINE('Transaction ID   : ' || rec.TransactionID);
        DBMS_OUTPUT.PUT_LINE('Transaction Date : ' || rec.TransactionDate);
        DBMS_OUTPUT.PUT_LINE('Amount           : ' || rec.Amount);
        DBMS_OUTPUT.PUT_LINE('Type             : ' || rec.TransactionType);
    END LOOP;

    CLOSE GenerateMonthlyStatements;
END;
/
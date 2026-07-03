BEGIN
    FOR rec IN (
        SELECT C.Name,
               L.LoanID,
               L.EndDate
        FROM Loans L
        JOIN Customers C
        ON L.CustomerID = C.CustomerID
        WHERE L.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    )
    LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Reminder: Dear '
            || rec.Name
            || ', your Loan ID '
            || rec.LoanID
            || ' is due on '
            || TO_CHAR(rec.EndDate, 'DD-MON-YYYY')
        );

    END LOOP;
END;
/
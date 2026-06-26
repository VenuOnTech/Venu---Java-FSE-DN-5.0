BEGIN
    FOR rec IN (
        SELECT L.LoanID,
               L.InterestRate,
               C.DOB
        FROM Loans L
        JOIN Customers C
        ON L.CustomerID = C.CustomerID
    )
    LOOP
        IF FLOOR(MONTHS_BETWEEN(SYSDATE, rec.DOB)/12) > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = rec.LoanID;

            DBMS_OUTPUT.PUT_LINE(
                'Interest updated for Loan ID: ' || rec.LoanID
            );
        END IF;
    END LOOP;

    COMMIT;
END;
/
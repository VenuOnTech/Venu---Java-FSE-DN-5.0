SET SERVEROUTPUT ON;

DECLARE
    CURSOR UpdateLoanInterestRates IS
        SELECT LoanID, InterestRate
        FROM Loans
        FOR UPDATE;

    rec UpdateLoanInterestRates%ROWTYPE;

BEGIN
    OPEN UpdateLoanInterestRates;

    LOOP
        FETCH UpdateLoanInterestRates INTO rec;
        EXIT WHEN UpdateLoanInterestRates%NOTFOUND;

        UPDATE Loans
        SET InterestRate = InterestRate - 0.5
        WHERE CURRENT OF UpdateLoanInterestRates;

        DBMS_OUTPUT.PUT_LINE(
            'Loan ID ' || rec.LoanID ||
            ' updated to new Interest Rate: ' ||
            (rec.InterestRate - 0.5) || '%'
        );
    END LOOP;

    CLOSE UpdateLoanInterestRates;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Loan interest rates updated successfully.');
END;
/
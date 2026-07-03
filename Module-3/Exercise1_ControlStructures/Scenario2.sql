ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);

BEGIN
    FOR rec IN (
        SELECT CustomerID,
               Name,
               Balance
        FROM Customers
    )
    LOOP
        IF rec.Balance > 10000 THEN

            UPDATE Customers
            SET IsVIP = 'TRUE'
            WHERE CustomerID = rec.CustomerID;

            DBMS_OUTPUT.PUT_LINE(
                rec.Name || ' promoted to VIP.'
            );

        ELSE

            UPDATE Customers
            SET IsVIP = 'FALSE'
            WHERE CustomerID = rec.CustomerID;

        END IF;
    END LOOP;

    COMMIT;
END;
/
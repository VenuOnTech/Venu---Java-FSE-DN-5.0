CREATE OR REPLACE FUNCTION HasSufficientBalance (
    p_accountId IN NUMBER,
    p_amount    IN NUMBER
)
RETURN BOOLEAN
AS
    v_balance NUMBER;
BEGIN
    SELECT Balance
    INTO v_balance
    FROM Accounts
    WHERE AccountID = p_accountId;

    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
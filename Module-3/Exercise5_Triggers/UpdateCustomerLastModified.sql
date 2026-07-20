CREATE OR REPLACE TRIGGER UpdateCustomerLastModified 
BEFORE UPDATE OF CustomerName, Email ON Customers 
FOR EACH ROW 
BEGIN 
    :NEW.LastModified := SYSDATE; 
END;
/
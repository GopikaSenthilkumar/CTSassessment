SET SERVEROUTPUT ON;
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER(10, 2)
);
CREATE TABLE ErrorLogs (
    ErrorID NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    ErrorMessage VARCHAR2(400),
    LoggedAt TIMESTAMP DEFAULT SYSTIMESTAMP
);
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    Balance NUMBER(10, 2)
);
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Salary NUMBER(10, 2)
);
-- Scenario 1: Customers should be able to transfer funds between their accounts
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_FromAccountID IN NUMBER,
    p_ToAccountID IN NUMBER,
    p_Amount IN NUMBER
)
IS
    v_Balance NUMBER;
BEGIN
    SELECT Balance INTO v_Balance FROM Accounts WHERE AccountID = p_FromAccountID;

    IF v_Balance < p_Amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;
    UPDATE Accounts SET Balance = Balance - p_Amount WHERE AccountID = p_FromAccountID;
    UPDATE Accounts SET Balance = Balance + p_Amount WHERE AccountID = p_ToAccountID;
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Transfer successful.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        EXECUTE IMMEDIATE 'INSERT INTO ErrorLogs(ErrorMessage) VALUES (:1)'
        USING 'Transfer error: ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/
-- Scenario 2: Manage errors when updating employee salaries
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_EmployeeID IN NUMBER,
    p_Percent IN NUMBER
)
IS
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Percent / 100)
    WHERE EmployeeID = p_EmployeeID;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'No such employee found.');
    END IF;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        EXECUTE IMMEDIATE 'INSERT INTO ErrorLogs(ErrorMessage) VALUES (:1)'
        USING 'Salary update error: ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE('Update failed: ' || SQLERRM);
END;
/
-- Scenario 3: Manage errors when updating employee salaries
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_CustomerID IN NUMBER,
    p_Name IN VARCHAR2,
    p_Age IN NUMBER,
    p_Balance IN NUMBER
)
IS
BEGIN
    INSERT INTO Customers(CustomerID, Name, Age, Balance)
    VALUES (p_CustomerID, p_Name, p_Age, p_Balance);

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Customer ' || p_Name || ' added.');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        ROLLBACK;
        EXECUTE IMMEDIATE 'INSERT INTO ErrorLogs(ErrorMessage) VALUES (:1)'
        USING 'Duplicate customer ID for ' || p_Name;
        DBMS_OUTPUT.PUT_LINE('Customer already exists: ' || p_Name);
    WHEN OTHERS THEN
        ROLLBACK;
        EXECUTE IMMEDIATE 'INSERT INTO ErrorLogs(ErrorMessage) VALUES (:1)'
        USING 'Customer insert error: ' || SQLERRM;
        DBMS_OUTPUT.PUT_LINE('Insert failed: ' || SQLERRM);
END;
/
-- Execution to test
INSERT INTO Accounts (AccountID, CustomerID, Balance) VALUES (101, 1, 5000); 
INSERT INTO Accounts (AccountID, CustomerID, Balance) VALUES (102, 2, 4000);
INSERT INTO Employees (EmployeeID, Name, Salary) VALUES (201, 'Radha', 35000);
INSERT INTO Employees (EmployeeID, Name, Salary) VALUES (202, 'Gopika', 42000);
COMMIT;
EXEC SafeTransferFunds(101, 102, 1000);
EXEC UpdateSalary(202, 10);
EXEC AddNewCustomer(6, 'Geetha', 40, 12000);
EXEC AddNewCustomer(1, 'Praveen', 60, 9000);
SELECT * FROM Accounts;
SELECT * FROM Employees;
SELECT * FROM Customers;
SELECT * FROM ErrorLogs;
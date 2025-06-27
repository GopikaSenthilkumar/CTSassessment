CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER(10, 2)
);
CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Department VARCHAR2(50),
    Salary NUMBER(10, 2)
);
INSERT INTO Accounts VALUES (1001, 1, 'Savings', 10000);
INSERT INTO Accounts VALUES (1002, 2, 'Current', 5000);
INSERT INTO Accounts VALUES (1003, 3, 'Savings', 15000);
INSERT INTO Accounts VALUES (1004, 4, 'Savings', 8000);
COMMIT;
INSERT INTO Employees VALUES (1, 'Praveen', 'HR', 40000);
INSERT INTO Employees VALUES (2, 'Geetha', 'Finance', 45000);
INSERT INTO Employees VALUES (3, 'Gopika', 'HR', 42000);
INSERT INTO Employees VALUES (4, 'Radha', 'IT', 48000);
COMMIT;
-- Scenario 1: The bank needs to process monthly interest for all savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    FOR rec IN (
        SELECT AccountID, Balance
        FROM Accounts
        WHERE AccountType = 'Savings'
    ) LOOP
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01)
        WHERE AccountID = rec.AccountID;
        
        DBMS_OUTPUT.PUT_LINE('Interest added for AccountID ' || rec.AccountID);
    END LOOP;
END;
/
-- Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department IN VARCHAR2,
    p_bonus_percent IN NUMBER
) AS
BEGIN
    FOR rec IN (
        SELECT EmployeeID, Salary
        FROM Employees
        WHERE Department = p_department
    ) LOOP
        UPDATE Employees
        SET Salary = Salary + (Salary * p_bonus_percent / 100)
        WHERE EmployeeID = rec.EmployeeID;
        
        DBMS_OUTPUT.PUT_LINE('Bonus added for EmployeeID ' || rec.EmployeeID);
    END LOOP;
END;
/
-- Scenario 3: Customers should be able to transfer funds between their accounts
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account IN NUMBER,
    p_to_account IN NUMBER,
    p_amount IN NUMBER
) AS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    DBMS_OUTPUT.PUT_LINE('Transferred ' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account);
END;
/
--Execution to test
EXEC ProcessMonthlyInterest;
EXEC UpdateEmployeeBonus('HR', 10);
EXEC TransferFunds(1001, 1002, 2000);
SELECT * FROM Accounts;
SELECT * FROM Employees;
SET SERVEROUTPUT ON;

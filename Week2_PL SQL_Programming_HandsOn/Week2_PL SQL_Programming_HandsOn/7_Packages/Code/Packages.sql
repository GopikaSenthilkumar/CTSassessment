SET SERVEROUTPUT ON;
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Accounts CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Employees CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Customers CASCADE CONSTRAINTS';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Balance NUMBER
);
CREATE TABLE Employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(100),
  Salary NUMBER
);
CREATE TABLE Accounts (
  AccountID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  Balance NUMBER,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
BEGIN
  EXECUTE IMMEDIATE 'DROP PACKAGE CustomerManagement';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
--Scenario 1: Group all customer-related procedures and functions into a package
CREATE OR REPLACE PACKAGE CustomerManagement IS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2);
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/
CREATE OR REPLACE PACKAGE BODY CustomerManagement IS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers (CustomerID, Name, Balance)
    VALUES (p_id, p_name, p_balance);
    DBMS_OUTPUT.PUT_LINE('Customer added.');
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE Customers SET Name = p_name WHERE CustomerID = p_id;
    DBMS_OUTPUT.PUT_LINE('Customer updated.');
  END;
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
    RETURN v_balance;
  END;
END CustomerManagement;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP PACKAGE EmployeeManagement';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
--Scenario 2: Create a package to manage employee data
CREATE OR REPLACE PACKAGE EmployeeManagement IS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2);
  FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/
CREATE OR REPLACE PACKAGE BODY EmployeeManagement IS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_salary NUMBER) IS
  BEGIN
    INSERT INTO Employees (EmployeeID, Name, Salary)
    VALUES (p_id, p_name, p_salary);
    DBMS_OUTPUT.PUT_LINE('Employee hired.');
  END;
  PROCEDURE UpdateEmployee(p_id NUMBER, p_name VARCHAR2) IS
  BEGIN
    UPDATE Employees SET Name = p_name WHERE EmployeeID = p_id;
    DBMS_OUTPUT.PUT_LINE('Employee updated.');
  END;
  FUNCTION CalculateAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
  END;
END EmployeeManagement;
/
BEGIN
  EXECUTE IMMEDIATE 'DROP PACKAGE AccountOperations';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/
--Scenario 3: Group all account-related operations into a package
CREATE OR REPLACE PACKAGE AccountOperations IS
  PROCEDURE OpenAccount(p_accID NUMBER, p_custID NUMBER, p_balance NUMBER);
  PROCEDURE CloseAccount(p_accID NUMBER);
  FUNCTION GetTotalBalance(p_custID NUMBER) RETURN NUMBER;
END AccountOperations;
/
CREATE OR REPLACE PACKAGE BODY AccountOperations IS
  PROCEDURE OpenAccount(p_accID NUMBER, p_custID NUMBER, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, Balance)
    VALUES (p_accID, p_custID, p_balance);
    DBMS_OUTPUT.PUT_LINE('Account opened.');
  END;

  PROCEDURE CloseAccount(p_accID NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_accID;
    DBMS_OUTPUT.PUT_LINE('Account closed.');
  END;

  FUNCTION GetTotalBalance(p_custID NUMBER) RETURN NUMBER IS
    v_total NUMBER := 0;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_custID;
    RETURN NVL(v_total, 0);
  END;
END AccountOperations;
/
--Execution to Test
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Testing CustomerManagement ---');
  CustomerManagement.AddCustomer(2, 'Geetha', 6500);
  CustomerManagement.UpdateCustomer(2, 'Geetha K');
  DBMS_OUTPUT.PUT_LINE('Customer Balance: ' || CustomerManagement.GetCustomerBalance(2));
END;
/
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Testing EmployeeManagement ---');
  EmployeeManagement.HireEmployee(101, 'Midhun', 25000);
  EmployeeManagement.UpdateEmployee(101, 'Midhun Ragav');
  DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || EmployeeManagement.CalculateAnnualSalary(101));
END;
/
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Testing AccountOperations ---');
  AccountOperations.OpenAccount(2001, 2, 3000);
  AccountOperations.OpenAccount(2002, 2, 7000);
  DBMS_OUTPUT.PUT_LINE('Total Balance: ' || AccountOperations.GetTotalBalance(2));
  AccountOperations.CloseAccount(2001);
END;
/

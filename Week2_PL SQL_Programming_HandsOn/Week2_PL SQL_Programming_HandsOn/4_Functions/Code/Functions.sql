SET SERVEROUTPUT ON;
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE
);
CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER REFERENCES Customers(CustomerID),
    Balance NUMBER(10,2)
);
INSERT INTO Customers (CustomerID, Name, DOB)
VALUES (1, 'Praveen', TO_DATE('01-JAN-1960', 'DD-MON-YYYY'));
INSERT INTO Customers (CustomerID, Name, DOB)
VALUES (2, 'Geetha', TO_DATE('15-JUN-1980', 'DD-MON-YYYY'));
INSERT INTO Customers (CustomerID, Name, DOB)
VALUES (3, 'Gopika', TO_DATE('03-MAY-2005', 'DD-MON-YYYY'));
INSERT INTO Accounts (AccountID, CustomerID, Balance) VALUES (1001, 1, 5000);
INSERT INTO Accounts (AccountID, CustomerID, Balance) VALUES (1002, 2, 2500);
INSERT INTO Accounts (AccountID, CustomerID, Balance) VALUES (1003, 3, 10000);
COMMIT;
--Scenario 1: Calculate the age of customers for eligibility checks
CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE)
RETURN NUMBER IS
    v_age NUMBER;
BEGIN
    v_age := FLOOR(MONTHS_BETWEEN(SYSDATE, p_dob) / 12);
    RETURN v_age;
END;
/
--Scenario 2: The bank needs to compute the monthly installment for a loan
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_amount NUMBER,
    p_annual_rate NUMBER,
    p_years NUMBER
) RETURN NUMBER IS
    v_monthly_rate NUMBER := p_annual_rate / 12 / 100;
    v_months NUMBER := p_years * 12;
    v_emi NUMBER;
BEGIN
    IF v_monthly_rate = 0 THEN
        v_emi := p_amount / v_months;
    ELSE
        v_emi := p_amount * v_monthly_rate * POWER(1 + v_monthly_rate, v_months) /
                 (POWER(1 + v_monthly_rate, v_months) - 1);
    END IF;

    RETURN ROUND(v_emi, 2);
END;
/
--Scenario 3: Check if a customer has sufficient balance before making a transaction
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id NUMBER,
    p_amount NUMBER
) RETURN BOOLEAN IS
    v_balance NUMBER;
BEGIN
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    RETURN v_balance >= p_amount;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN FALSE;
END;
/
--Execution to test
BEGIN
    FOR rec IN (SELECT CustomerID, Name, DOB FROM Customers) LOOP
        DBMS_OUTPUT.PUT_LINE('Customer: ' || rec.Name || ' | Age: ' || CalculateAge(rec.DOB));
    END LOOP;
END;
/
BEGIN
    DBMS_OUTPUT.PUT_LINE('EMI for ₹5,00,000 @ 8.5% for 5 years: ₹' || 
        CalculateMonthlyInstallment(500000, 8.5, 5));
END;
/
BEGIN
    IF HasSufficientBalance(1001, 3000) THEN
        DBMS_OUTPUT.PUT_LINE('Account 1001 has sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Account 1001 does NOT have sufficient balance.');
    END IF;

    IF HasSufficientBalance(1002, 3000) THEN
        DBMS_OUTPUT.PUT_LINE('Account 1002 has sufficient balance.');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Account 1002 does NOT have sufficient balance.');
    END IF;
END;
/
SELECT * FROM Customers;
SELECT * FROM Accounts;
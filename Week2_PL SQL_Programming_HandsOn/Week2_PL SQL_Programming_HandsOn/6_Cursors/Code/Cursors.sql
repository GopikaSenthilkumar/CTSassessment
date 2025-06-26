SET SERVEROUTPUT ON;
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'Gopika K S', TO_DATE('2002-08-10', 'YYYY-MM-DD'), 10000, SYSDATE);
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 10000, SYSDATE);
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (201, 1, 50000, 8.5, SYSDATE, ADD_MONTHS(SYSDATE, 24));
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (201, 1, SYSDATE, 1500, 'Deposit');
COMMIT;
--Scenario 1: Generate Monthly Statements for All Customers
DECLARE
    CURSOR transaction_cursor IS
        SELECT c.CustomerID, c.Name, t.TransactionDate, t.Amount, t.TransactionType
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
          AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY c.CustomerID, t.TransactionDate;

    v_customerID Customers.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
    v_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
    v_type Transactions.TransactionType%TYPE;
BEGIN
    DBMS_OUTPUT.PUT_LINE('--- Monthly Statements ---');
    OPEN transaction_cursor;
    LOOP
        FETCH transaction_cursor INTO v_customerID, v_name, v_date, v_amount, v_type;
        EXIT WHEN transaction_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer: ' || v_name || ', Date: ' || v_date ||
                             ', Type: ' || v_type || ', Amount: ' || v_amount);
    END LOOP;
    CLOSE transaction_cursor;
END;
/
-- Scenario 2: Apply Annual Fee to All Accounts
DECLARE
    CURSOR account_cursor IS
        SELECT AccountID, Balance FROM Accounts;

    v_accountID Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_fee CONSTANT NUMBER := 500; 
BEGIN
    OPEN account_cursor;
    LOOP
        FETCH account_cursor INTO v_accountID, v_balance;
        EXIT WHEN account_cursor%NOTFOUND;

        UPDATE Accounts
        SET Balance = Balance - v_fee,
            LastModified = SYSDATE
        WHERE AccountID = v_accountID;

        DBMS_OUTPUT.PUT_LINE('Annual fee of ' || v_fee || ' applied to Account ID: ' || v_accountID);
    END LOOP;
    CLOSE account_cursor;
END;
/
-- Scenario 3: Update the Interest Rate for All Loans
DECLARE
    CURSOR loan_cursor IS
        SELECT LoanID, InterestRate FROM Loans;

    v_loanID Loans.LoanID%TYPE;
    v_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO v_loanID, v_rate;
        EXIT WHEN loan_cursor%NOTFOUND;
        UPDATE Loans
        SET InterestRate = InterestRate + 1.5
        WHERE LoanID = v_loanID;

        DBMS_OUTPUT.PUT_LINE('Loan ID: ' || v_loanID || ' interest rate updated from ' ||
                             v_rate || ' to ' || (v_rate + 1.5));
    END LOOP;
    CLOSE loan_cursor;
END;
/
--To view Tables
SELECT * FROM Customers;
SELECT * FROM Accounts;
SELECT * FROM Transactions;
SELECT * FROM AuditLog;
SELECT * FROM Loans;

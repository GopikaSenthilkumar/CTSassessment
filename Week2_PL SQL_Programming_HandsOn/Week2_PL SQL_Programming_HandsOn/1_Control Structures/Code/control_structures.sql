SET SERVEROUTPUT ON;
CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Age NUMBER,
    Balance NUMBER(10,2),
    IsVIP CHAR(1) DEFAULT 'N'
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER REFERENCES Customers(CustomerID),
    InterestRate NUMBER(5,2),
    DueDate DATE
);
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (1, 'Praveen', 65, 12000, 'N');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (2, 'Geetha', 45, 9500, 'N');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (3, 'Gopika', 20, 15000, 'N');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (4, 'Radha', 50, 8000, 'N');
INSERT INTO Customers (CustomerID, Name, Age, Balance, IsVIP) VALUES (5, 'Midhun', 18, 13000, 'N');

INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (1, 1, 9.5, TO_DATE('10-JUL-2025', 'DD-MON-YYYY'));
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (2, 2, 10.0, TO_DATE('15-JUL-2025', 'DD-MON-YYYY'));
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (3, 3, 11.0, TO_DATE('05-JUL-2025', 'DD-MON-YYYY'));
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (4, 4, 10.5, TO_DATE('25-AUG-2025', 'DD-MON-YYYY'));
INSERT INTO Loans (LoanID, CustomerID, InterestRate, DueDate) VALUES (5, 5, 9.0, TO_DATE('01-JUL-2025', 'DD-MON-YYYY'));
COMMIT;
-- Scenario 1: A customer can be promoted to VIP status based on their balance 
BEGIN
    FOR rec IN (
        SELECT c.CustomerID, c.Name, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE c.Age > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = InterestRate - 1
        WHERE LoanID = rec.LoanID;

        DBMS_OUTPUT.PUT_LINE('1% discount applied to LoanID ' || rec.LoanID || ' for customer ' || rec.Name || '.');
    END LOOP;
END;
/
-- Scenario 2: A customer can be promoted to VIP status based on their balance
BEGIN
    FOR rec IN (
        SELECT CustomerID, Name FROM Customers WHERE Balance > 10000
    ) LOOP
        UPDATE Customers
        SET IsVIP = 'Y'
        WHERE CustomerID = rec.CustomerID;

        DBMS_OUTPUT.PUT_LINE('Customer ' || rec.Name || ' (ID: ' || rec.CustomerID || ') promoted to VIP.');
    END LOOP;
END;
/
-- Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days
BEGIN
    FOR rec IN (
        SELECT l.LoanID, c.Name, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || rec.LoanID || ' for customer ' ||
                             rec.Name || ' is due on ' || TO_CHAR(rec.DueDate, 'DD-MON-YYYY'));
    END LOOP;
END;
/


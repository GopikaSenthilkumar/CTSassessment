package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class BankAccountTest {
	private BankAccount account;
    @BeforeEach
    void setUp() {
        account = new BankAccount("Gopika", 1000.0);
        System.out.println("Test setup complete");
    }
    @AfterEach
    void tearDown() {
        account = null;
        System.out.println("Test teardown complete");
    }
    @Test
    void testDeposit() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance(), 0.001);
    }
    @Test
    void testWithdraw() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance(), 0.001);
    }
    @Test
    void testWithdrawOverBalance() {
        account.withdraw(1200.0);
        assertEquals(1000.0, account.getBalance(), 0.001); 
    }
    @Test
    void testGetHolderName() {
        String name = account.getHolderName();
        assertEquals("Gopika", name);
    }
    @Test
    void testDepositNegativeAmount() {
        account.deposit(-100.0);
        assertEquals(1000.0, account.getBalance(), 0.001); 
    }
}
  
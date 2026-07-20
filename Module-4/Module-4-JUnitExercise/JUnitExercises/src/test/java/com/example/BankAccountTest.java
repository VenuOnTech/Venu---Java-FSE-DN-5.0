package com.example;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {

    private BankAccount account;

    // Setup Method
    @Before
    public void setUp() {
        account = new BankAccount(1000);
        System.out.println("Setup: Bank Account Created");
    }

    // Teardown Method
    @After
    public void tearDown() {
        System.out.println("Teardown: Test Completed");
    }

    @Test
    public void testDeposit() {

        // Arrange
        double depositAmount = 500;

        // Act
        account.deposit(depositAmount);

        // Assert
        assertEquals(1500, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {

        // Arrange
        double withdrawAmount = 200;

        // Act
        account.withdraw(withdrawAmount);

        // Assert
        assertEquals(800, account.getBalance(), 0.001);
    }
}
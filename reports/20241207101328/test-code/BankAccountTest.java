package net.mooctest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class BankAccountTest {

    private BankAccount account;

    @Before
    public void setUp() {
        account = new BankAccount("1234567890", 100.0);
    }

    @Test
    public void testGetAccountNumber() {
        assertEquals("1234567890", account.getAccountNumber());
    }

    @Test
    public void testGetBalance() {
        assertEquals(100.0, account.getBalance(), 0.01);
    }

    @Test
    public void testGetTransactionHistory() {
        List<String> history = account.getTransactionHistory();
        assertNotNull(history);
        assertEquals(1, history.size());
    }

    @Test
    public void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.01);
    }

    @Test
    public void testWithdraw() {
        account.withdraw(50.0);
        assertEquals(50.0, account.getBalance(), 0.01);
    }

    @Test
    public void testTransfer() {
        BankAccount targetAccount = new BankAccount("9876543210", 200.0);
        account.transfer(targetAccount, 50.0);
        assertEquals(50.0, account.getBalance(), 0.01);
        assertEquals(250.0, targetAccount.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        account.withdraw(-50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        account.withdraw(200.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferNullTargetAccount() {
        account.transfer(null, 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferNegativeAmount() {
        account.transfer(new BankAccount("9876543210", 200.0), -50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferInsufficientFunds() {
        account.transfer(new BankAccount("9876543210", 200.0), 150.0);
    }
}
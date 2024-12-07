package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountTest {

    @Test
    public void testDeposit() {
        BankAccount account = new BankAccount("12345", 100.0);
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.0);
    }

    @Test
    public void testWithdraw() {
        BankAccount account = new BankAccount("54321", 200.0);
        account.withdraw(50.0);
        assertEquals(150.0, account.getBalance(), 0.0);
    }

    @Test
    public void testTransfer() {
        BankAccount account1 = new BankAccount("11111", 300.0);
        BankAccount account2 = new BankAccount("22222", 100.0);
        account1.transfer(account2, 50.0);
        assertEquals(250.0, account1.getBalance(), 0.0);
        assertEquals(150.0, account2.getBalance(), 0.0);
    }
}
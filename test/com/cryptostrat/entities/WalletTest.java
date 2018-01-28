package com.cryptostrat.entities;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.cryptostrat.app.Currency;

public class WalletTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void positiveStartingBalanceTest()
    {
        Wallet wallet = new Wallet(Currency.TYPE.EUR, 20);
        assertEquals(20, wallet.getBalance(), 0.0f);
    }

    @Test
    public void negativeStartingBalanceTest()
    {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Cannot instantiate Wallet with a negative balance.");

        new Wallet(Currency.TYPE.EUR, -300);
    }

    @Test
    public void zeroStartingBalanceTest()
    {
        Wallet wallet = new Wallet(Currency.TYPE.EUR, 0.0f);
        assertEquals(0.0f, wallet.getBalance(), 0.0f);
    }

    @Test
    public void startingBalanceConstant()
    {
        Wallet wallet = new Wallet(Currency.TYPE.EUR, 100.0f);
        assertTrue(wallet.deposit(10.0f));
        assertTrue(wallet.withdraw(25.0f));
        assertEquals(100.0f, wallet.getStartingBalance(), 0.0f);
    }

    @Test
    public void positiveDepositTest()
    {
        Wallet wallet = new Wallet(Currency.TYPE.EUR, 20.0f);
        assertTrue(wallet.deposit(50.0f));
        assertEquals(70.0f, wallet.getBalance(), 0.0f);
    }

    @Test
    public void negativeDepositTest()
    {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Cannot deposit negative amount. Consider withdrawing instead.");

        Wallet wallet = new Wallet(Currency.TYPE.EUR, 20.0f);
        wallet.deposit(-10.0f);
    }

    @Test
    public void manyDepositsTest()
    {
        Wallet wallet = new Wallet(Currency.TYPE.EUR, 20.0f);
        assertTrue(wallet.deposit(50.0f));
        assertTrue(wallet.deposit(50.0f));
        assertTrue(wallet.deposit(0.001f));
        assertEquals(120.001f, wallet.getBalance(), 0.0f);
    }

    @Test
    public void positiveWithdrawTest()
    {
        Wallet wallet = new Wallet(Currency.TYPE.EUR, 20.0f);
        assertTrue(wallet.withdraw(10.5f));
        assertEquals(9.5f, wallet.getBalance(), 0.0f);
    }

    @Test
    public void negativeWithdrawTest()
    {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Cannot withdraw negative amount. Consider depositing instead.");

        Wallet wallet = new Wallet(Currency.TYPE.EUR, 20.0f);
        wallet.withdraw(-10.0f);
    }

    @Test
    public void manyWithdrawsTest()
    {
        Wallet wallet = new Wallet(Currency.TYPE.EUR, 200.0f);
        assertTrue(wallet.withdraw(10.0f));
        assertTrue(wallet.withdraw(10.0f));
        assertTrue(wallet.withdraw(0.001f));
        assertEquals(179.999f, wallet.getBalance(), 0.0f);
    }

    @Test
    public void withdrawBeyondBalanceTest()
    {
        Wallet wallet = new Wallet(Currency.TYPE.EUR, 20.0f);
        assertFalse(wallet.withdraw(30.0f));
        assertEquals(20.0f, wallet.getBalance(), 0.0f);
    }
}

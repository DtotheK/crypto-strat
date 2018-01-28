package com.cryptostrat.entities;

import com.cryptostrat.app.Currency;

public class Wallet
{
    private float startingBalance;
    private float balance;
    private Currency.TYPE currencyType;

    public Wallet(Currency.TYPE currencyType, float startingAmount)
    {
        if (startingAmount < 0)
        {
            throw new UnsupportedOperationException("Cannot instantiate Wallet with a negative balance.");
        }

        this.currencyType = currencyType;
        this.balance = this.startingBalance = startingAmount;
    }

    public boolean withdraw(float amount)
    {
        if (amount < 0)
        {
            throw new UnsupportedOperationException("Cannot withdraw negative amount. Consider depositing instead.");
        }

        if (balance < amount)
        {
            System.out.println("Insufficient " + currencyType + "funds to withdraw " + amount + " balance: " + balance);
            return false;
        }
        else
        {
            balance -= amount;
            return true;
        }
    }

    public boolean deposit(float amount)
    {
        if (amount < 0)
        {
            throw new UnsupportedOperationException("Cannot deposit negative amount. Consider withdrawing instead.");
        }

        balance += amount;
        return true;
    }

    public float getBalance()
    {
        return balance;
    }

    public float getStartingBalance()
    {
        return startingBalance;
    }
}

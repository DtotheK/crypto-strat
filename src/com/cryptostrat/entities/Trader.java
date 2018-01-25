package com.cryptostrat.entities;

import java.util.ArrayList;

import com.cryptostrat.app.Currency;
import com.cryptostrat.strat.Strategy;
import com.cryptostrat.utils.Converter;

public class Trader
{
    private Wallet cryptoWallet;
    private Wallet fiatWallet;

    private Strategy strategy;
    private float tradeAmountInFiat;

    public Trader()
    {
        this(new TraderParams());
    }

    public Trader(TraderParams traderParams)
    {
        this(traderParams.getStartingFiat(), traderParams.getStartingCrypto(), traderParams.getFiatPerTrade(), traderParams.getStrategyType());
    }

    public Trader(float fiatStart, float cryptoStart, float fiatPerTrade, Strategy.TYPE strategyType)
    {
        fiatWallet = new Wallet(Currency.TYPE.EUR, fiatStart);
        cryptoWallet = new Wallet(Currency.TYPE.XRP, cryptoStart);
        this.tradeAmountInFiat = fiatPerTrade;
        this.strategy = new Strategy(strategyType);
    }

    public float getFiatBalance()
    {
        return fiatWallet.getBalance();
    }

    public float getCryptoBalance()
    {
        return cryptoWallet.getBalance();
    }

    public float getFiatStart()
    {
        return fiatWallet.getStartingBalance();
    }

    public float getCrytoStart()
    {
        return cryptoWallet.getStartingBalance();
    }

    public void tradeBasedOnStrategy(float percChange24Hr, float priceOfCrypto)
    {
        ArrayList<Trade> trades = strategy.determineTrades(percChange24Hr, priceOfCrypto, tradeAmountInFiat);
        trade(trades);
    }

    public void trade(ArrayList<Trade> trades)
    {
        for (Trade trade : trades)
        {
            executeTrade(trade);
        }
        System.out.println("   ...completed trading. " + getBalancesString());
    }

    private void executeTrade(Trade trade)
    {
        switch (trade.getBuyCurrency())
        {
            case XRP:
                tradeFiatForCrypto(trade.getAmountInFiat(), trade.getPriceOfCrypto());
                break;

            case EUR:
                tradeCryptoForFiat(tradeAmountInFiat, trade.getPriceOfCrypto());
                break;
            default:
                throw new UnsupportedOperationException("Currency unsupported by executeTrade(): " + trade.getBuyCurrency());
        }
    }

    private void tradeCryptoForFiat(float tradeAmountInFiat, float priceOfCrypto)
    {
        cryptoWallet.withdraw(Converter.f2c(tradeAmountInFiat, priceOfCrypto));
        fiatWallet.deposit(tradeAmountInFiat);
    }

    private void tradeFiatForCrypto(float tradeAmountInFiat, float priceOfCrypto)
    {
        cryptoWallet.deposit(Converter.f2c(tradeAmountInFiat, priceOfCrypto));
        fiatWallet.withdraw(tradeAmountInFiat);
    }

    private String getBalancesString()
    {
        return "[F: " + getFiatBalance() + ", C:" + getCryptoBalance() + "]";
    }
}

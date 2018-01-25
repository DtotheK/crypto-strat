package com.cryptostrat.entities;

import com.cryptostrat.app.Currency;

public class Trade
{
    private Currency.TYPE sellCurrency;
    private Currency.TYPE buyCurrency;
    private float amountInFiat;
    private float priceOfCrypto;

    public Trade(Currency.TYPE buyCurrency, Currency.TYPE sellCurrency, float amountInFiat, float priceOfCrypto)
    {
        this.buyCurrency = buyCurrency;
        this.sellCurrency = sellCurrency;
        this.amountInFiat = amountInFiat;
        this.priceOfCrypto = priceOfCrypto;
    }

    public Currency.TYPE getBuyCurrency()
    {
        return buyCurrency;
    }

    public Currency.TYPE getSellCurrency()
    {
        return sellCurrency;
    }

    public float getAmountInFiat()
    {
        return amountInFiat;
    }

    public float getPriceOfCrypto()
    {
        return priceOfCrypto;
    }
}

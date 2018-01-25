package com.cryptostrat.strat;

import java.util.ArrayList;

import com.cryptostrat.entities.Trade;

public abstract class Algorithm
{
    abstract public ArrayList<Trade> determineTrades(float percChange24Hr, float priceOfCrypto, float tradeAmountInFiat);
}

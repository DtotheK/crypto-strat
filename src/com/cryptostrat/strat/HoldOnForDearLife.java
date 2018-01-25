package com.cryptostrat.strat;

import java.util.ArrayList;

import com.cryptostrat.entities.Trade;

public class HoldOnForDearLife extends Algorithm
{
    @Override
    public ArrayList<Trade> determineTrades(float percChange24Hr, float priceOfCrypto, float tradeAmountInFiat)
    {
        ArrayList<Trade> trades = new ArrayList<Trade>();

        System.out.println("[%:" + percChange24Hr + "]No action taken, HODL...\t");

        return trades;
    }
}

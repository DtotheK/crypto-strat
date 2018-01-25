package com.cryptostrat.strat;

import java.util.ArrayList;

import com.cryptostrat.app.Currency;
import com.cryptostrat.entities.Trade;

public class SellHighBuyLow extends Algorithm
{
    @Override
    public ArrayList<Trade> determineTrades(float percChange24Hr, float priceOfCrypto, float tradeAmountInFiat)
    {
        ArrayList<Trade> trades = new ArrayList<Trade>();

        if (percChange24Hr > 0.05)
        {
            trades.add(new Trade(Currency.TYPE.EUR, Currency.TYPE.XRP, tradeAmountInFiat, priceOfCrypto));
            System.out.println("[%:" + percChange24Hr + "] To the moon. SOLD...\t\t");
        }
        else if (percChange24Hr < -0.05)
        {
            trades.add(new Trade(Currency.TYPE.XRP, Currency.TYPE.EUR, tradeAmountInFiat, priceOfCrypto));
            System.out.println("[%:" + percChange24Hr + "] Must be a crash. ACCUMULATE...\t");
        }
        else
        {
            System.out.println("[%:" + percChange24Hr + "]No action taken, HODL...\t");
        }

        return trades;
    }
}

package com.cryptostrat.strat;

import java.util.ArrayList;

import com.cryptostrat.entities.Trade;

public class Strategy
{
    public enum TYPE
    {
        SHBL, // Sell High Buy Low
        HODL, // Hold on for dear life
        MARTINGALE
    }

    private Algorithm algorithm;

    public Strategy(TYPE type)
    {
        switch (type)
        {
            case SHBL:
                algorithm = new SellHighBuyLow();
                break;
            case HODL:
                algorithm = new HoldOnForDearLife();
                break;
            default:
                throw new UnsupportedOperationException("Selected strategy is not yet implemented: " + type);
        }
    }

    public ArrayList<Trade> determineTrades(float percChange24Hr, float priceOfCrypto, float tradeAmountInFiat)
    {
        return algorithm.determineTrades(percChange24Hr, priceOfCrypto, tradeAmountInFiat);
    }
}

package com.cryptostrat.app;

import java.text.DecimalFormat;

import com.cryptostrat.data.DailyStat;
import com.cryptostrat.data.Market;
import com.cryptostrat.entities.Trader;
import com.cryptostrat.utils.Converter;

public class Simulator
{
    private Trader trader;
    private Market market;

    public Simulator(Trader trader, Market market)
    {
        this.trader = trader;
        this.market = market;
    }

    public void simulate()
    {
        for (int dayIdx = 0; dayIdx < market.getNumDays(); dayIdx++)
        {
            DailyStat dayStat = market.getDailyStat(dayIdx);
            trader.tradeBasedOnStrategy(dayStat.getPercChange24Hr(), dayStat.getPriceOfCrypto());
        }
    }

    public void showResult()
    {
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);

        float cryptoDiff = trader.getCryptoBalance() - trader.getCrytoStart();
        float fiatDiff = trader.getFiatBalance() - trader.getFiatStart();

        String cryptoDiffStr = (cryptoDiff > 0) ? "+" + df.format(cryptoDiff) : df.format(cryptoDiff);
        String fiatDiffStr = (fiatDiff > 0) ? "+" + df.format(fiatDiff) : df.format(fiatDiff);

        float priceOfCryptoLastDay = market.getDailyStat(market.getNumDays() - 1).getPriceOfCrypto();
        float priceOfCryptoFirstDay = market.getDailyStat(0).getPriceOfCrypto();

        System.out.println("\n\n\tDays simulated: " + market.getNumDays());
        System.out.println("---------------------------------");
        System.out.println("\tCrypto\t\tFIAT");
        System.out.println("Start\t" + df.format(trader.getCrytoStart()) + "\t" + df.format(trader.getFiatStart()));
        System.out.println("End\t" + df.format(trader.getCryptoBalance()) + "\t" + df.format(trader.getFiatBalance()));
        System.out.println("Gains\t" + cryptoDiffStr + "\t\t" + fiatDiffStr);
        System.out.println("---------------------------------");
        System.out.println("Total FIAT at start: " + df.format(trader.getFiatStart() + Converter.c2f(trader.getCrytoStart(), priceOfCryptoFirstDay)));
        System.out.println("Total FIAT at end: " + df.format(trader.getFiatBalance() + Converter.c2f(trader.getCryptoBalance(), priceOfCryptoLastDay)));
    }
}

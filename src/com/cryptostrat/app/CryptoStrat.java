package com.cryptostrat.app;

import java.io.IOException;

import com.cryptostrat.api.CoinAPI;
import com.cryptostrat.data.Market;
import com.cryptostrat.entities.Trader;

public class CryptoStrat
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("   ___                 _        __ _             _   ");
        System.out.println("  / __\\ __ _   _ _ __ | |_ ___ / _\\ |_ _ __ __ _| |_ ");
        System.out.println(" / / | '__| | | | '_ \\| __/ _ \\\\ \\| __| '__/ _` | __|");
        System.out.println("/ /__| |  | |_| | |_) | || (_) |\\ \\ |_| | | (_| | |_ ");
        System.out.println("\\____/_|   \\__, | .__/ \\__\\___/\\__/\\__|_|  \\__,_|\\__|");
        System.out.println("           |___/|_|\n\n");

        Trader trader = new Trader();
        Market market = new Market(CoinAPI.getXrpInUsdPriceDec2017());
        Simulator simulator = new Simulator(trader, market);
        simulator.simulate();
        simulator.showResult();
    }
}

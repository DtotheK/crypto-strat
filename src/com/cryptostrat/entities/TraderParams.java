package com.cryptostrat.entities;

import com.cryptostrat.app.Config;
import com.cryptostrat.strat.Strategy;

public class TraderParams
{
    private final static String DEFAULT_TRADER_PARAMS_CFG = "trader.cfg";
    private final float startingFiat;
    private final float startingCrypto;
    private final float fiatPerTrade;
    private final Strategy.TYPE strategyType;

    public TraderParams()
    {
        Config cfg = new Config(DEFAULT_TRADER_PARAMS_CFG);
        this.startingFiat = Float.valueOf(cfg.getProperty("STARTING_FIAT"));
        this.startingCrypto = Float.valueOf(cfg.getProperty("STARTING_CRYPTO"));
        this.fiatPerTrade = Float.valueOf(cfg.getProperty("FIAT_PER_TRADE"));
        this.strategyType = Strategy.TYPE.valueOf(cfg.getProperty("STRATEGY"));
    }

    public float getStartingFiat()
    {
        return startingFiat;
    }

    public float getStartingCrypto()
    {
        return startingCrypto;
    }

    public float getFiatPerTrade()
    {
        return fiatPerTrade;
    }

    public Strategy.TYPE getStrategyType()
    {
        return strategyType;
    }
}

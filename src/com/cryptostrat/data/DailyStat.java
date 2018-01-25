package com.cryptostrat.data;

public class DailyStat
{
    private float percChange24Hr;
    private float priceOfCrypto;

    public DailyStat(float percChange24Hr, float priceOfCrypto)
    {
        this.percChange24Hr = percChange24Hr;
        this.priceOfCrypto = priceOfCrypto;
    }

    public float getPercChange24Hr()
    {
        return percChange24Hr;
    }

    public float getPriceOfCrypto()
    {
        return priceOfCrypto;
    }
}

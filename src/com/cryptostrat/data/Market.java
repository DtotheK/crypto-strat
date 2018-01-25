package com.cryptostrat.data;

import java.util.ArrayList;

public class Market
{
    ArrayList<DailyStat> dailyStats = new ArrayList<DailyStat>();

    public Market(ArrayList<Float> priceOfCryptoArray)
    {
        dailyStats.add(new DailyStat(0.0f, priceOfCryptoArray.get(0)));

        for (int idx = 1; idx < priceOfCryptoArray.size(); idx++)
        {
            float perChange = (priceOfCryptoArray.get(idx) - priceOfCryptoArray.get(idx - 1)) / priceOfCryptoArray.get(idx - 1);
            dailyStats.add(new DailyStat(perChange, priceOfCryptoArray.get(idx)));
        }
    }

    public DailyStat getDailyStat(int dayIdx)
    {
        return dailyStats.get(dayIdx);
    }

    public int getNumDays()
    {
        return dailyStats.size();
    }
}

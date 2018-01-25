package com.cryptostrat.api;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.cryptostrat.app.Config;

public class CoinAPI
{
    private static final String CONFIG_FILE = "coinapi.cfg";

    private static timedata[] get_historical_timeseries(String symbol_id, JavaRestCoinApiImpl.PERIOD_IDENTIFIER period_id, Timestamp time_start, Timestamp time_end) throws JavaRestCoinApiImpl.exception
    {
        Config cfg = new Config(CONFIG_FILE);
        String key = cfg.getProperty("KEY");
        JavaRestCoinApiImpl c = new JavaRestCoinApiImpl(key);
        return c.ohlcv_get_historical_timeseries(symbol_id, period_id, time_start, time_end);
    }

    @SuppressWarnings("deprecation")
    public static ArrayList<Float> getXrpInUsdPriceDec2017()
    {
        timedata[] data = null;
        try
        {
            data = get_historical_timeseries("BITSTAMP_SPOT_XRP_USD", JavaRestCoinApiImpl.PERIOD_IDENTIFIER._1DAY, new Timestamp(117, 11, 0, 0, 0, 0, 0), new Timestamp(117, 11, 30, 0, 0, 0, 0));
            System.out.println("Data Length: " + data.length);
        }
        catch (JavaRestCoinApiImpl.exception ex)
        {
            System.err.println("CoinAPI Exception: " + ex.getMessage());
        }
        catch (Exception ex)
        {
            System.err.println("Generic exception: " + ex.getMessage());
            ex.printStackTrace();
        }

        ArrayList<Float> xrpInUsdPrice2017 = new ArrayList<Float>();

        for (int idx = 0; idx < data.length; idx++)
        {
            xrpInUsdPrice2017.add((float) data[idx].getPriceClose());
        }

        return xrpInUsdPrice2017;
    }
}

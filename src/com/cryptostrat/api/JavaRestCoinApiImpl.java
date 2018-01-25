package com.cryptostrat.api;

import okhttp3.*;

import java.io.*;

import org.json.*;

import java.sql.Timestamp;

public class JavaRestCoinApiImpl
{
    public class exception extends Exception
    {
        private static final long serialVersionUID = 8795347947004876332L;
        int code;

        public exception(int code, String message)
        {
            super(message);
            this.code = code;
        }

        public int get_code()
        {
            return code;
        }
    }

    enum PERIOD_IDENTIFIER
    {
        INVALID,
        _1SEC,
        _2SEC,
        _3SEC,
        _4SEC,
        _5SEC,
        _6SEC,
        _10SEC,
        _15SEC,
        _20SEC,
        _30SEC,
        _1MIN,
        _2MIN,
        _3MIN,
        _4MIN,
        _5MIN,
        _6MIN,
        _10MIN,
        _15MIN,
        _20MIN,
        _30MIN,
        _1HRS,
        _2HRS,
        _3HRS,
        _4HRS,
        _6HRS,
        _8HRS,
        _12HRS,
        _1DAY,
        _2DAY,
        _3DAY,
        _5DAY,
        _7DAY,
        _10DAY,
        _1MTH,
        _2MTH,
        _3MTH,
        _4MTH,
        _6MTH,
        _1YRS,
        _2YRS,
        _3YRS,
        _4YRS,
        _5YRS
    }

    private static String period_id_to_string(PERIOD_IDENTIFIER period_id)
    {
        switch (period_id)
        {
            case _1SEC:
                return "1SEC";
            case _2SEC:
                return "2SEC";
            case _3SEC:
                return "3SEC";
            case _4SEC:
                return "4SEC";
            case _5SEC:
                return "5SEC";
            case _6SEC:
                return "6SEC";
            case _10SEC:
                return "10SEC";
            case _15SEC:
                return "15SEC";
            case _20SEC:
                return "20SEC";
            case _30SEC:
                return "30SEC";
            case _1MIN:
                return "1MIN";
            case _2MIN:
                return "2MIN";
            case _3MIN:
                return "3MIN";
            case _4MIN:
                return "4MIN";
            case _5MIN:
                return "5MIN";
            case _6MIN:
                return "6MIN";
            case _10MIN:
                return "10MIN";
            case _15MIN:
                return "15MIN";
            case _20MIN:
                return "20MIN";
            case _30MIN:
                return "20MIN";
            case _1HRS:
                return "1HRS";
            case _2HRS:
                return "2HRS";
            case _3HRS:
                return "3HRS";
            case _4HRS:
                return "4HRS";
            case _6HRS:
                return "6HRS";
            case _8HRS:
                return "8HRS";
            case _12HRS:
                return "12HRS";
            case _1DAY:
                return "1DAY";
            case _2DAY:
                return "2DAY";
            case _3DAY:
                return "3DAY";
            case _5DAY:
                return "5DAY";
            case _7DAY:
                return "7DAY";
            case _10DAY:
                return "10DAY";
            case _1MTH:
                return "1MTH";
            case _2MTH:
                return "2MTH";
            case _3MTH:
                return "3MTH";
            case _4MTH:
                return "4MTH";
            case _6MTH:
                return "6MTH";
            case _1YRS:
                return "1YRS";
            case _2YRS:
                return "2YRS";
            case _3YRS:
                return "3YRS";
            case _4YRS:
                return "3YRS";
            case _5YRS:
                return "5YRS";
            default:
                return "INVALID";
        }
    }

    private String key;

    public JavaRestCoinApiImpl(String key)
    {
        this.key = key;
    }

    @SuppressWarnings("deprecation")
    private static Timestamp precise_time_from_string(String time)
    {
        int year = Integer.parseInt(time.substring(0, 4)) - 1900;
        int month = Integer.parseInt(time.substring(5, 7)) - 1;
        int day = Integer.parseInt(time.substring(8, 10));
        int hours = Integer.parseInt(time.substring(11, 13));
        int minutes = Integer.parseInt(time.substring(14, 16));
        int seconds = Integer.parseInt(time.substring(17, 19));
        int nano = 0;

        if (time.length() > 20)
            nano = Integer.parseInt((time.substring(20, time.length() - 1) + "0000000000").substring(0, 7)) * 100;

        return new Timestamp(year, month, day, hours, minutes, seconds, nano);
    }

    @SuppressWarnings("deprecation")
    private static String precise_time_to_string(Timestamp timestamp)
    {
        return String.format("%04d-%02d-%02dT%02d:%02d:%02d", timestamp.getYear() + 1900, timestamp.getMonth() + 1, timestamp.getDate(), timestamp.getHours(), timestamp.getMinutes(), timestamp.getSeconds());
    }

    private String get_json(String url) throws IOException, exception
    {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://rest.coinapi.io" + url)
                .addHeader("X-CoinAPI-Key", key)
                .build();

        Response response = client.newCall(request).execute();

        if (response.code() >= 400)
        {
            String error = "Error code " + response.code();

            try
            {
                JSONObject object = new JSONObject(response.body().string());
                error = object.getString("error");
            }
            catch (Exception ex)
            {}

            throw new exception(response.code(), error);
        }

        return response.body().string();
    }

    private timedata[] parse_timeseries(JSONArray array)
    {
        timedata[] result = new timedata[array.length()];
        for (int i = 0; i < array.length(); i++)
        {
            Timestamp time_period_start = precise_time_from_string(array.getJSONObject(i).getString("time_period_start"));
            Timestamp time_period_end = precise_time_from_string(array.getJSONObject(i).getString("time_period_end"));
            Timestamp time_open = precise_time_from_string(array.getJSONObject(i).getString("time_open"));
            Timestamp time_close = precise_time_from_string(array.getJSONObject(i).getString("time_close"));
            double price_open = array.getJSONObject(i).getDouble("price_open");
            double price_high = array.getJSONObject(i).getDouble("price_high");
            double price_low = array.getJSONObject(i).getDouble("price_low");
            double price_close = array.getJSONObject(i).getDouble("price_close");
            double volume_traded = array.getJSONObject(i).getDouble("volume_traded");
            int trades_count = array.getJSONObject(i).getInt("trades_count");

            result[i] = new timedata(time_period_start, time_period_end, time_open, time_close, price_open, price_high, price_low, price_close, volume_traded, trades_count);
        }
        return result;
    }

    timedata[] ohlcv_get_historical_timeseries(String symbol_id, PERIOD_IDENTIFIER period_id, Timestamp time_start, Timestamp time_end) throws exception
    {
        try
        {
            String json = get_json("/v1/ohlcv/" + symbol_id + "/history?period_id=" + period_id_to_string(period_id) + "&time_start=" + precise_time_to_string(time_start) + "&time_end=" + precise_time_to_string(time_end));
            JSONArray array = new JSONArray(json);
            return parse_timeseries(array);
        }
        catch (IOException ioe)
        {}
        return null;
    }
}
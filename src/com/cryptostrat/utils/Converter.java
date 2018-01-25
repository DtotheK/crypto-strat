package com.cryptostrat.utils;

public class Converter
{
    public static float f2c(float fiatAmount, float cryptoPrice)
    {
        return fiatAmount / cryptoPrice;
    }

    public static float c2f(float cryptoAmount, float cryptoPrice)
    {
        return cryptoAmount * cryptoPrice;
    }
}

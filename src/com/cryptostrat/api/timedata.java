package com.cryptostrat.api;

import java.sql.Timestamp;

public class timedata
{
    private Timestamp timePeriodStart; // Period starting time (range left inclusive)
    private Timestamp timePeriodEnd; // Period ending time (range right exclusive)
    private Timestamp timeOpen; // Time of first trade inside period range
    private Timestamp timeClose; // Time of last trade inside period range
    private double priceOpen; // First trade price inside period range
    private double priceHigh; // Highest traded price inside period range
    private double priceLow; // Lowest traded price inside period range
    private double priceClose; // Last trade price inside period range
    private double volumeTraded; // Cumulative base amount traded inside period range
    private int tradesCount; // Amount of trades executed inside period range

    public timedata(Timestamp timePeriodStart, Timestamp timePeriodEnd, Timestamp timeOpen, Timestamp timeClose,
            double priceOpen, double priceHigh, double priceLow, double priceClose, double volumeTraded, int tradesCount)
    {
        this.timePeriodStart = timePeriodStart;
        this.timePeriodEnd = timePeriodEnd;
        this.timeOpen = timeOpen;
        this.timeClose = timeClose;
        this.priceOpen = priceOpen;
        this.priceHigh = priceHigh;
        this.priceLow = priceLow;
        this.priceClose = priceClose;
        this.volumeTraded = volumeTraded;
        this.tradesCount = tradesCount;
    }

    public Timestamp getTimePeriodStart()
    {
        return timePeriodStart;
    }

    public Timestamp getTimePeriodEnd()
    {
        return timePeriodEnd;
    }

    public Timestamp getTimeOpen()
    {
        return timeOpen;
    }

    public Timestamp getTimeClose()
    {
        return timeClose;
    }

    public double getPriceOpen()
    {
        return priceOpen;
    }

    public double getPriceHigh()
    {
        return priceHigh;
    }

    public double getPriceLow()
    {
        return priceLow;
    }

    public double getPriceClose()
    {
        return priceClose;
    }

    public double getVolumeTraded()
    {
        return volumeTraded;
    }

    public int getTradesCount()
    {
        return tradesCount;
    }
}
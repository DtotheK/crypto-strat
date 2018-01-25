package com.cryptostrat.app;

import java.util.Properties;

public class Config
{
    Properties configFile;

    public Config(String resource)
    {
        configFile = new java.util.Properties();
        try
        {
            configFile.load(this.getClass().getClassLoader().getResourceAsStream(resource));
        }
        catch (Exception eta)
        {
            eta.printStackTrace();
        }
    }

    public String getProperty(String key)
    {
        return configFile.getProperty(key);
    }
}

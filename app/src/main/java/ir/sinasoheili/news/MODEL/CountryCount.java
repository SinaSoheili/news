package ir.sinasoheili.news.MODEL;

import java.io.Serializable;

public class CountryCount implements Serializable
{
    private String countryName;
    private int count;

    //constructor
    public CountryCount(String countryName, int count)
    {
        this.countryName = countryName;
        this.count = count;
    }

    //setter
    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    //getter
    public String getCountryName()
    {
        return countryName;
    }

    public int getCount()
    {
        return count;
    }
}

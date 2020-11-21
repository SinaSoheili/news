package ir.sinasoheili.news.MODEL;

import java.io.Serializable;

public class Source implements Serializable
{
    private String id;
    private String name;
    private String description;
    private String url;
    private String category;
    private String language;
    private String country;
    private String countryFullName;

    //setter
    public void setCountryFullName(String countryFullName)
    {
        this.countryFullName = countryFullName;
    }

    //getter
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getCategory() {
        return category;
    }

    public String getLanguage() {
        return language;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryFullName() {
        return countryFullName;
    }
}

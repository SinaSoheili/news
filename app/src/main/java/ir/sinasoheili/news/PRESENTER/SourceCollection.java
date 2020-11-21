package ir.sinasoheili.news.PRESENTER;

import android.util.Log;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.MODEL.CountryCount;
import ir.sinasoheili.news.MODEL.Source;

public class SourceCollection
{
    public ArrayList<CountryCount> CollectionByCountry(Source[] allItem)
    {
        ArrayList<CountryCount> result = new ArrayList<>();
        int count = 0;

        for(int i=0 ; i<allItem.length ; i++)
        {
            count = 0;
            Source si = allItem[i];

            if(containCountry(si.getCountryFullName() , result))
            {
                continue;
            }

            for(int j=i ; j<allItem.length ; j++)
            {
                if(si.getCountry().equals(allItem[j].getCountry()))
                {
                    count++;
                }
            }

            result.add(new CountryCount(si.getCountryFullName() , count));
        }

        return result;
    }

    public ArrayList<CategoryCount> CollectionByCategory(Source[] allItem)
    {
        ArrayList<CategoryCount> result = new ArrayList<>();
        int count;

        for(int i=0 ; i<allItem.length ; i++)
        {
            count = 0;
            Source si = allItem[i];

            if(containCategory(si.getCategory() , result))
            {
                continue;
            }

            for(int j=i ; j<allItem.length ; j++)
            {
                if(si.getCategory().equals(allItem[j].getCategory()))
                {
                    count++;
                }
            }

            result.add(new CategoryCount(si.getCategory() , count));
        }

        return result;
    }

    private boolean containCountry(String CountryName , ArrayList<CountryCount> list)
    {
        for(CountryCount cc : list)
        {
//            Log.i("tag" , cc.getCountryName()+"---"+CountryName);

            if(cc.getCountryName().equals(CountryName))
            {
                return true;
            }
        }

        return false;
    }

    private boolean containCategory(String category , ArrayList<CategoryCount> list)
    {
        for(CategoryCount cc : list)
        {
            if(cc.getCategory().equals(category))
            {
                return true;
            }
        }

        return false;
    }

    public static ArrayList<Source> getSourceByCountry(Source[] allItem , String country)
    {
        ArrayList<Source> result = new ArrayList<>();

        for(Source s : allItem)
        {
            if(s.getCountryFullName().equals(country))
            {
                result.add(s);
            }
        }

        return result;
    }

    public static ArrayList<Source> getSourceByCategory(Source[] allItem , String category)
    {
        ArrayList<Source> result =  new ArrayList<>();

        for(Source s : allItem)
        {
            if(s.getCategory().equals(category))
            {
                result.add(s);
            }
        }

        return result;
    }
}

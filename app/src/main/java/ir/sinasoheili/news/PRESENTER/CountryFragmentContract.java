package ir.sinasoheili.news.PRESENTER;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CountryCount;

public interface CountryFragmentContract
{
    public interface CountryFragmentContract_view
    {
        public void showRecyclerView(ArrayList<CountryCount> cc);
    }

    public interface CountryFragmentContract_presenter
    {
        public void readAllCountry();
    }
}

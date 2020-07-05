package ir.sinasoheili.news.PRESENTER;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CountryCount;
import ir.sinasoheili.news.MODEL.Source;

public class CountryFragmentPresenter implements CountryFragmentContract.CountryFragmentContract_presenter
{
    private Context context;
    private CountryFragmentContract.CountryFragmentContract_view countryView;

    public CountryFragmentPresenter(Context context , CountryFragmentContract.CountryFragmentContract_view countryView)
    {
        this.context = context;
        this.countryView = countryView;
    }

    @Override
    public void readAllCountry()
    {
        SourcePreferenceManager spm = SourcePreferenceManager.getInstance(context);
        Source[] list = spm.getSource();

        if(list == null)
        {
            return;
        }

        SourceCollection collection = new SourceCollection();
        ArrayList<CountryCount> cc = collection.CollectionByCountry(list);

        countryView.showRecyclerView(cc);
    }
}

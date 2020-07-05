package ir.sinasoheili.news.PRESENTER;

import android.content.Context;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.MODEL.CountryCount;
import ir.sinasoheili.news.MODEL.Source;

public class ChooseFragmentPresenter implements ChooseFragmentContract.ChooseFragmentContractPresenter
{
    private ChooseFragmentContract.ChooseFragmentContractView chooseView;
    private Context context;

    public ChooseFragmentPresenter(Context context , ChooseFragmentContract.ChooseFragmentContractView chooseView)
    {
        this.context = context;
        this.chooseView = chooseView;
    }

    @Override
    public void readAllCountry()
    {
        SourcePreferenceManager pref = SourcePreferenceManager.getInstance(context);
        Source[] sources = pref.getSource();
        SourceCollection collection = new SourceCollection();
        ArrayList<CountryCount> cc = collection.CollectionByCountry(sources);
        chooseView.showCountry(cc);
    }

    @Override
    public void readAllCategory()
    {
        SourcePreferenceManager pref = SourcePreferenceManager.getInstance(context);
        Source[] sources = pref.getSource();
        SourceCollection collection = new SourceCollection();
        ArrayList<CategoryCount> cc = collection.CollectionByCategory(sources);
        chooseView.showCategory(cc);
    }
}

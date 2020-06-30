package ir.sinasoheili.news.PRESENTER;

import android.content.Context;

import java.util.ArrayList;
import java.util.Collections;

import ir.sinasoheili.news.MODEL.Source;

public class SourceListPresenter implements SourceListContract.SourceListContract_presenter
{
    private Context context;
    private SourceListContract.SourceListContract_view sourceView;

    public SourceListPresenter(Context context , SourceListContract.SourceListContract_view sourceView)
    {
        this.context = context;
        this.sourceView = sourceView;
    }

    @Override
    public void getSourceByCountry(String country)
    {
        ArrayList<Source> list = SourceCollection.getSourceByCountry
                (SourcePreferenceManager.getInstance(context).getSource() , country);

        sourceView.showRecyclerView(list);
    }

    @Override
    public void getSourceByCategory(String category)
    {
        ArrayList<Source> list = SourceCollection.getSourceByCategory
                (SourcePreferenceManager.getInstance(context).getSource() , category);

        sourceView.showRecyclerView(list);
    }
}

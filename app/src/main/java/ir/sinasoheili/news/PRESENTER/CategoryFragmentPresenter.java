package ir.sinasoheili.news.PRESENTER;

import android.content.Context;
import android.provider.CallLog;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.MODEL.Source;

public class CategoryFragmentPresenter implements CategoryFragmentContract.CategoryFragmentContract_presenter
{
    private Context context;
    private CategoryFragmentContract.CategoryFragmentContract_view categoryView;

    public CategoryFragmentPresenter(Context context , CategoryFragmentContract.CategoryFragmentContract_view categoryView)
    {
        this.context = context;
        this.categoryView = categoryView;
    }

    @Override
    public void readAllCategory()
    {
        SourcePreferenceManager spm = SourcePreferenceManager.getInstance(context);
        Source[] allItem = spm.getSource();

        if(allItem == null)
        {
            return;
        }

        SourceCollection collection = new SourceCollection();
        ArrayList<CategoryCount> items = collection.CollectionByCategory(allItem);

        categoryView.showRecyclerView(items);
    }
}

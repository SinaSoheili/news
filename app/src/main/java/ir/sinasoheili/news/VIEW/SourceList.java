package ir.sinasoheili.news.VIEW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.MODEL.CountryCount;
import ir.sinasoheili.news.MODEL.Source;
import ir.sinasoheili.news.PRESENTER.SourceListContract;
import ir.sinasoheili.news.PRESENTER.SourceListPresenter;
import ir.sinasoheili.news.R;

public class SourceList extends AppCompatActivity implements SourceListContract.SourceListContract_view
{
    private RecyclerView rv;

    private SourceListContract.SourceListContract_presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_list);

        initObj();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            if(bundle.containsKey("COUNTRY_COUNT"))
            {
                CountryCount cc = (CountryCount) bundle.get("COUNTRY_COUNT");
                presenter.getSourceByCountry(cc.getCountryName());
            }
            else if(bundle.containsKey("CATEGORY_COUNT"))
            {
                CategoryCount cc = (CategoryCount) bundle.get("CATEGORY_COUNT");
                presenter.getSourceByCategory(cc.getCategory());
            }
        }
    }

    private void initObj()
    {
        presenter = new SourceListPresenter(SourceList.this , this);

        rv = findViewById(R.id.source_list);
    }

    @Override
    public void showRecyclerView(ArrayList<Source> items)
    {
        SourceListAdapter adapter = new SourceListAdapter(SourceList.this ,items);
        rv.setLayoutManager(new LinearLayoutManager(SourceList.this , RecyclerView.VERTICAL , false));

        LayoutAnimationController lac = AnimationUtils.loadLayoutAnimation(SourceList.this , R.anim.layout_list_item_anim);
        rv.setLayoutAnimation(lac);

        rv.setAdapter(adapter);
    }
}

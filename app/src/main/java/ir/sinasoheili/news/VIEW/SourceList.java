package ir.sinasoheili.news.VIEW;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.MODEL.CountryCount;
import ir.sinasoheili.news.PRESENTER.SourceListContract;
import ir.sinasoheili.news.R;

public class SourceList extends AppCompatActivity implements SourceListContract.SourceListContract_view
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_list);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            if(bundle.containsKey("COUNTRY_COUNT"))
            {
                CountryCount cc = (CountryCount) bundle.get("COUNTRY_COUNT");
                Log.i("tag" , cc.getCountryName());
            }
            else if(bundle.containsKey("CATEGORY_COUNT"))
            {
                CategoryCount cc = (CategoryCount) bundle.get("CATEGORY_COUNT");
                Log.i("tag" , cc.getCategory());
            }
        }
    }
}

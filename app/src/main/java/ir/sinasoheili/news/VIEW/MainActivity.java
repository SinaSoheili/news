package ir.sinasoheili.news.VIEW;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;;
import com.google.android.material.tabs.TabLayout;

import ir.sinasoheili.news.R;

public class MainActivity extends AppCompatActivity
{
    private ViewPager viewPager;
    private TabLayout tabLayout;

    private CountryFragment countryFragment;
    private CategoryFragment categoryFragment;
    private ChooseFragment chooseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initObj();
    }

    private void initObj()
    {
        countryFragment = new CountryFragment();
        categoryFragment = new CategoryFragment();
        chooseFragment = new ChooseFragment();

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        initViewPager();
    }

    private void initViewPager()
    {
        Fragment[] fragments = {countryFragment , categoryFragment , chooseFragment};
        String[] pageTitles = {getString(R.string.title_page_country) , getString(R.string.title_page_category) , getString(R.string.title_page_choose)};

        viewPager.setAdapter( new SlideAdapter(getSupportFragmentManager() , fragments , pageTitles));
        tabLayout.setupWithViewPager(viewPager);
    }
}

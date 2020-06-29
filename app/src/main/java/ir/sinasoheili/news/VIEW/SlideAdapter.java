package ir.sinasoheili.news.VIEW;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SlideAdapter extends FragmentPagerAdapter
{
    private Fragment[] fragments;
    private String[] pageTitle;

    public SlideAdapter(@NonNull FragmentManager fm , Fragment[] fragments , String[] pageTitle)
    {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        this.fragments = fragments;
        this.pageTitle = pageTitle;
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return fragments[position];
    }

    @Override
    public int getCount()
    {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position)
    {
        return pageTitle[position];
    }
}

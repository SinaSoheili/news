package ir.sinasoheili.news.PRESENTER;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;

public interface CategoryFragmentContract
{
    public interface CategoryFragmentContract_view
    {
        public void showRecyclerView(ArrayList<CategoryCount> cc);
    }

    public interface CategoryFragmentContract_presenter
    {
        public void readAllCategory();
    }
}

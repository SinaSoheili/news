package ir.sinasoheili.news.PRESENTER;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.Source;

public interface SourceListContract
{
    public interface SourceListContract_view
    {
        public void showRecyclerView(ArrayList<Source> items);
    }

    public interface SourceListContract_presenter
    {
        public void getSourceByCountry(String country);
        public void getSourceByCategory(String category);
    }
}

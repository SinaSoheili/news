package ir.sinasoheili.news.PRESENTER;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.CategoryCount;
import ir.sinasoheili.news.MODEL.CountryCount;

public interface ChooseFragmentContract
{
    public interface ChooseFragmentContractView
    {
        public void showCountry(ArrayList<CountryCount> cc);
        public void showCategory(ArrayList<CategoryCount> cc);
    }

    public interface ChooseFragmentContractPresenter
    {
        public void readAllCountry();
        public void readAllCategory();
    }
}

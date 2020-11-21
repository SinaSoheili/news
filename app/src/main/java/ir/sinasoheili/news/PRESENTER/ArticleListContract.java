package ir.sinasoheili.news.PRESENTER;

import ir.sinasoheili.news.MODEL.Article;
import ir.sinasoheili.news.MODEL.Source;

public interface ArticleListContract
{
    public interface ArticleListContract_view
    {
        public void showRecyclerView(Article[] items);
        public void showMessage(String message);
    }

    public interface ArticleListContract_presenter
    {
        public void getArticle(Source s);
    }
}

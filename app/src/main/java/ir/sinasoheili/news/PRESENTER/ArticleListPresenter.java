package ir.sinasoheili.news.PRESENTER;

import android.content.Context;

import ir.sinasoheili.news.MODEL.Article;
import ir.sinasoheili.news.MODEL.Source;

public class ArticleListPresenter implements ArticleListContract.ArticleListContract_presenter
{
    private Context context;
    private ArticleListContract.ArticleListContract_view articleView;

    public ArticleListPresenter(Context context , ArticleListContract.ArticleListContract_view articleView)
    {
        this.context = context;
        this.articleView = articleView;
    }

    @Override
    public void getArticle(Source s)
    {
        API_ArticlesHandler handler = new API_ArticlesHandler();
        handler.start(s.getId(), new API_ArticlesHandler.callBack()
        {
            @Override
            public void onResponseSuccess(Article[] items)
            {
                articleView.showRecyclerView(items);
            }

            @Override
            public void onResponseNoSuccess(String message)
            {
                articleView.showMessage(message);
            }

            @Override
            public void onFailure(String message)
            {
                articleView.showMessage(message);
            }
        });
    }
}

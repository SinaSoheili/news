package ir.sinasoheili.news.VIEW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.snackbar.Snackbar;

import ir.sinasoheili.news.MODEL.Article;
import ir.sinasoheili.news.MODEL.Source;
import ir.sinasoheili.news.PRESENTER.ArticleListContract;
import ir.sinasoheili.news.PRESENTER.ArticleListPresenter;
import ir.sinasoheili.news.R;

public class ArticleListActivity extends AppCompatActivity implements ArticleListContract.ArticleListContract_view
{
    private RecyclerView rv;

    private ArticleListContract.ArticleListContract_presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        initObj();

        Bundle bundle = getIntent().getExtras();
        if(bundle != null)
        {
            if(bundle.containsKey("SOURCE"))
            {
                Source s = (Source) bundle.get("SOURCE");

                presenter.getArticle(s);
            }
        }
    }

    private void initObj()
    {
        this.presenter = new ArticleListPresenter(ArticleListActivity.this , this);

        this.rv = findViewById(R.id.article_list);
    }

    @Override
    public void showRecyclerView(Article[] items)
    {
        ArticleListAdapter adapter = new ArticleListAdapter(ArticleListActivity.this , items);
        rv.setLayoutManager(new LinearLayoutManager(ArticleListActivity.this , RecyclerView.VERTICAL , false));
        rv.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message)
    {
        Snackbar.make(rv , message , Snackbar.LENGTH_SHORT).show();
    }
}

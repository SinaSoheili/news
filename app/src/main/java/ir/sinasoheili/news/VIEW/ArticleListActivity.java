package ir.sinasoheili.news.VIEW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ProgressBar;

import com.google.android.material.snackbar.Snackbar;

import ir.sinasoheili.news.MODEL.Article;
import ir.sinasoheili.news.MODEL.Source;
import ir.sinasoheili.news.PRESENTER.ArticleListContract;
import ir.sinasoheili.news.PRESENTER.ArticleListPresenter;
import ir.sinasoheili.news.R;

public class ArticleListActivity extends AppCompatActivity implements ArticleListContract.ArticleListContract_view
{
    private RecyclerView rv;
    private ProgressBar progressBar;

    private ArticleListContract.ArticleListContract_presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_article);

        initObj();

        progressBar.setVisibility(View.VISIBLE);

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
        this.progressBar = findViewById(R.id.article_list_progressbar);
    }

    @Override
    public void showRecyclerView(Article[] items)
    {
        progressBar.setVisibility(View.GONE);

        ArticleListAdapter adapter = new ArticleListAdapter(ArticleListActivity.this , items);
        rv.setLayoutManager(new LinearLayoutManager(ArticleListActivity.this , RecyclerView.VERTICAL , false));

        LayoutAnimationController lac = AnimationUtils.loadLayoutAnimation(ArticleListActivity.this , R.anim.layout_list_item_anim);
        rv.setLayoutAnimation(lac);

        rv.setAdapter(adapter);
    }

    @Override
    public void showMessage(String message)
    {
        Snackbar.make(rv , message , Snackbar.LENGTH_SHORT).show();
    }
}

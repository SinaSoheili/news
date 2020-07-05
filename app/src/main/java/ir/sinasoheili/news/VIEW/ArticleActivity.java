package ir.sinasoheili.news.VIEW;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import ir.sinasoheili.news.MODEL.Article;
import ir.sinasoheili.news.R;

public class ArticleActivity extends AppCompatActivity
{
    private TextView tv_title;
    private TextView tv_date;
    private TextView tv_description;

    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);

        initObj();

        Bundle bundle = getIntent().getExtras();
        if((bundle != null) && (bundle.containsKey("ARTICLE")))
        {
            this.article = (Article) bundle.get("ARTICLE");
            fill();
        }
    }

    private void initObj()
    {
        tv_title = findViewById(R.id.tv_article_title);
        tv_date = findViewById(R.id.tv_article_date);
        tv_description = findViewById(R.id.tv_article_description);
    }

    private void fill()
    {
        tv_title.setText(article.getTitle());
        tv_date.setText(article.getPublishedAt());
        tv_description.setText(article.getDescription()+"\n\n"+article.getContent());
    }
}

package ir.sinasoheili.news.VIEW;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import ir.sinasoheili.news.MODEL.Article;
import ir.sinasoheili.news.MODEL.Source;
import ir.sinasoheili.news.PRESENTER.API_ArticlesHandler;
import ir.sinasoheili.news.PRESENTER.API_SourcesHandler;
import ir.sinasoheili.news.R;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

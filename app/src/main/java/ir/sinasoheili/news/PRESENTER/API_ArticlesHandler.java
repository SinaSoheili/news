package ir.sinasoheili.news.PRESENTER;

import android.util.Log;

import java.io.IOException;

import ir.sinasoheili.news.MODEL.Article;
import ir.sinasoheili.news.MODEL.ResponseArticles;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_ArticlesHandler
{
    private Retrofit retrofit;
    private APIs api;

    public API_ArticlesHandler()
    {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(APIs.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.api = retrofit.create(APIs.class);
    }

    public void start(String sourceId , final callBack callBack)
    {
        Call<ResponseArticles> call = api.getArticles(sourceId);
        call.enqueue(new Callback<ResponseArticles>()
        {
            @Override
            public void onResponse(Call<ResponseArticles> call, Response<ResponseArticles> response)
            {
                if(response.isSuccessful())
                {
                    callBack.onResponseSuccess(response.body().getArticles());
                }
                else
                {
                    callBack.onResponseNoSuccess(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseArticles> call, Throwable t)
            {
                callBack.onFailure(t.getMessage());
            }
        });
    }

    public interface callBack
    {
        public void onResponseSuccess(Article[] items);
        public void onResponseNoSuccess(String message);
        public void onFailure(String message);
    }
}

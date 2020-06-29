package ir.sinasoheili.news.PRESENTER;

import android.util.Log;

import ir.sinasoheili.news.MODEL.ResponseSource;
import ir.sinasoheili.news.MODEL.Source;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_SourcesHandler
{
    private Retrofit retrofit;
    private APIs api;

    public API_SourcesHandler()
    {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(APIs.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        this.api = retrofit.create(APIs.class);
    }

    public void start(final callBack callBack)
    {
        Call<ResponseSource> call = api.getSources();
        call.enqueue(new Callback<ResponseSource>()
        {
            @Override
            public void onResponse(Call<ResponseSource> call, Response<ResponseSource> response)
            {
                if(response.isSuccessful())
                {
                    callBack.onResponseSuccess(response.body().getSources());

                }
                else
                {
                   callBack.onResponseNoSuccess(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseSource> call, Throwable t)
            {
                callBack.onFailure(t.getMessage());
                Log.i("tag" , "FAIL");
            }
        });
    }

    public interface callBack
    {
        public void onResponseSuccess(Source[] items);
        public void onResponseNoSuccess(String messaage);
        public void onFailure(String message);
    }
}

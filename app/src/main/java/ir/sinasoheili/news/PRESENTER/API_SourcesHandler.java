package ir.sinasoheili.news.PRESENTER;

import android.content.Context;
import android.util.Log;

import ir.sinasoheili.news.MODEL.ResponseSource;
import ir.sinasoheili.news.MODEL.Source;
import ir.sinasoheili.news.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class API_SourcesHandler
{
    private Retrofit retrofit;
    private APIs api;
    private Context context;

    public API_SourcesHandler(Context context)
    {
        this.context = context;

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
                    String[] fullName = context.getResources().getStringArray(R.array.country_full_name);
                    Source[] sArray = response.body().getSources();

                    for(int i=0 ; i<sArray.length ; i++)
                    {
                        boolean find = false;

                        for(String name : fullName)
                        {
                            String[] a = name.split("#");

                            if(sArray[i].getCountry().equals(a[0]))
                            {
                                sArray[i].setCountryFullName(a[1]);
                                find = true;
                            }
                        }

                        if(! find)
                        {
                            sArray[i].setCountryFullName(sArray[i].getCountry());
                        }
                    }

                    callBack.onResponseSuccess(sArray);
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

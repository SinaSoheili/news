package ir.sinasoheili.news.PRESENTER;

import ir.sinasoheili.news.MODEL.ResponseSource;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIs
{
    String BASE_URL = "https://newsapi.org/v2/";

    @Headers("X-Api-Key:7d750fefb2e348d9bbefd9c62fff9fbd")
    @GET("sources")
    Call<ResponseSource> getSources();
}

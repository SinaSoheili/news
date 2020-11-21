package ir.sinasoheili.news.PRESENTER;

import ir.sinasoheili.news.MODEL.ResponseArticles;
import ir.sinasoheili.news.MODEL.ResponseSource;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIs
{
    String BASE_URL = "https://newsapi.org/v2/";
    String header = "X-Api-Key:7d750fefb2e348d9bbefd9c62fff9fbd";

    @Headers(header)
    @GET("sources")
    Call<ResponseSource> getSources();


    @Headers(header)
    @GET("top-headlines")
    Call<ResponseArticles> getArticles(@Query("sources") String sourceId);
}

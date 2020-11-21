package ir.sinasoheili.news.MODEL;

public class ResponseArticles
{
    private String status;
    private int totalResults;
    private Article[] articles;

    //getter

    public String getStatus()
    {
        return status;
    }

    public int getTotalResults()
    {
        return totalResults;
    }

    public Article[] getArticles()
    {
        return articles;
    }
}

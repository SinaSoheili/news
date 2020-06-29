package ir.sinasoheili.news.MODEL;

public class CategoryCount
{
    private String category;
    private int count;

    //constructor
    public CategoryCount(String category, int count)
    {
        this.category = category;
        this.count = count;
    }

    //setter
    public void setCategory(String category)
    {
        this.category = category;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    //getter
    public String getCategory()
    {
        return category;
    }

    public int getCount()
    {
        return count;
    }
}

package ir.sinasoheili.news.PRESENTER;

import ir.sinasoheili.news.MODEL.Source;

public class Application extends android.app.Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();

        //get all source form server and store in shared preferences
        getSource();
    }

    private void getSource()
    {
        API_SourcesHandler handler = new API_SourcesHandler();
        handler.start(new API_SourcesHandler.callBack()
        {
            @Override
            public void onResponseSuccess(Source[] items)
            {
                SourcePreferenceManager spm = SourcePreferenceManager.getInstance(Application.this);
                spm.saveSource(items);
            }

            @Override
            public void onResponseNoSuccess(String messaage)
            {

            }

            @Override
            public void onFailure(String message)
            {

            }
        });
    }
}

package ir.sinasoheili.news.PRESENTER;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

import ir.sinasoheili.news.MODEL.Source;

public class SourcePreferenceManager
{
    private static SourcePreferenceManager spm;
    private static SharedPreferences pref;
    private static SharedPreferences.Editor editor;
    private static String PREF_NAME="SOURCES";
    private static String PREF_KEY="ITEMS";

    private SourcePreferenceManager(Context context)
    {
        pref = context.getSharedPreferences(PREF_NAME , Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public static SourcePreferenceManager getInstance(Context context)
    {
        if(spm == null)
        {
            spm = new SourcePreferenceManager(context);
        }
        return spm;
    }

    public void saveSource(Source[] items)
    {
        Gson gson = new Gson();
        String stringJson = gson.toJson(items);

        editor.putString(PREF_KEY , stringJson).apply();
    }

    public Source[] getSource()
    {
        Source[] result;

        String stringJson = pref.getString(PREF_KEY , "");
        Gson gson = new Gson();
        result = gson.fromJson(stringJson , Source[].class);

        return result;
    }
}

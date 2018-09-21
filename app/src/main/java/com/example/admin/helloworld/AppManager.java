package com.example.admin.helloworld;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

/**
 * Created by admin on 2018-09-21.
 */

public class AppManager extends Application {

    private static Gson mGson;
    private static OkHttpClient mOkHttpClient;
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mGson = new Gson();
        mOkHttpClient = new OkHttpClient();
    }

    public static Gson getGson(){
        return mGson;
    }

    public static OkHttpClient getHttpClient(){
        return mOkHttpClient;
    }

    public static Context getmContext(){
        return mContext;
    }

    public static Resources getResource(){
        return mContext.getResources();
    }
}

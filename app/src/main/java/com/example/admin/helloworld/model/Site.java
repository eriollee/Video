package com.example.admin.helloworld.model;

import android.content.Context;

import com.example.admin.helloworld.R;

/**
 * Created by admin on 2018-09-17.
 */

public class Site {

    public static final int LETV = 1;//乐事
    public static final int SOHU = 2;//搜狐
    public static final int MAX_SITE = 2;

    private int siteId;
    private String siteName;
    private Context mContext;

    public Site(int id, Context context) {
        siteId = id;
        mContext = context;
        switch (siteId) {
            case LETV:
                siteName = mContext.getResources().getString(R.string.site_letv);
                break;
            case SOHU:
                siteName = mContext.getResources().getString(R.string.site_sohu);
                break;
        }
    }

    public int getSiteId() {
        return siteId;
    }

    public String getSetName() {
        return siteName;
    }
}

package com.example.admin.helloworld.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.admin.helloworld.BaseFragment;
import com.example.admin.helloworld.R;

/**
 * Created by admin on 2018-09-17.
 */

public class DetailListFragment extends BaseFragment {
    private static int mStiteId;
    private static int mChannelId;
    public static final String CHANNEL_ID = "channelid";
    public static final String SITE_ID = "siteid";

    public DetailListFragment(){

    }

//    public DetailListFragment(int siteId,int channelId){
//        mStiteId = siteId;
//        mChannelId = channelId;
//    }

    public static Fragment newInstance(int siteId,int channelId){
        DetailListFragment fragment = new DetailListFragment();
        mStiteId = siteId;
        mChannelId = channelId;
        Bundle bundle = new Bundle();
        bundle.putInt(CHANNEL_ID,channelId);
        bundle.putInt(SITE_ID,siteId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detailist;
    }
}

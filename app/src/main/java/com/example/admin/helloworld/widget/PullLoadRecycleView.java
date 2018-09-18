package com.example.admin.helloworld.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.admin.helloworld.R;

/**
 * Created by admin on 2018-09-18.
 */

public class PullLoadRecycleView extends LinearLayout {
    private Context mContext;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public PullLoadRecycleView(Context context) {
        super(context);
        initView(context);
    }

    public PullLoadRecycleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PullLoadRecycleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        mContext = context;
        View view = LayoutInflater.from(mContext).inflate(R.layout.pull_loadmore_layout,null);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setColorSchemeResources(android.R.color.holo_green_dark,android.R.color.holo_blue_dark,android.R.color.holo_orange_dark);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayoutOnRefresh());
    }

    class SwipeRefreshLayoutOnRefresh implements  SwipeRefreshLayout.OnRefreshListener{

        @Override
        public void onRefresh() {

        }
    }
}

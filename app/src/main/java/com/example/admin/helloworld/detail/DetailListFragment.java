package com.example.admin.helloworld.detail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.admin.helloworld.BaseFragment;
import com.example.admin.helloworld.R;
import com.example.admin.helloworld.widget.PullLoadRecycleView;

/**
 * Created by admin on 2018-09-17.
 */

public class DetailListFragment extends BaseFragment {
    private static int mStiteId;
    private static int mChannelId;
    public static final String CHANNEL_ID = "channelid";
    public static final String SITE_ID = "siteid";
    private PullLoadRecycleView mRecycleView;

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
        mRecycleView = bindViewId(R.id.pullloadRecyclerView);
        mRecycleView.setGridLayout(3);
        mRecycleView.setAdapter(new DetailListAdpter());
        mRecycleView.setOnPullLoadMoreListener(new PullLoadMoreListener());

    }

    class  PullLoadMoreListener implements PullLoadRecycleView.OnPullLoadMoreListener{

        @Override
        public void refresh() {

        }

        @Override
        public void loadMore() {

        }
    }

    class DetailListAdpter extends RecyclerView.Adapter{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_detailist;
    }
}

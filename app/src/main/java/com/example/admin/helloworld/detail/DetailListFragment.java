package com.example.admin.helloworld.detail;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.helloworld.BaseFragment;
import com.example.admin.helloworld.R;
import com.example.admin.helloworld.model.Site;
import com.example.admin.helloworld.widget.PullLoadRecycleView;

/**
 * Created by admin on 2018-09-17.
 */

public class DetailListFragment extends BaseFragment {
    private static int mSiteId;
    private static int mChannelId;
    public static final String CHANNEL_ID = "channelid";
    public static final String SITE_ID = "siteid";
    private PullLoadRecycleView mRecycleView;
    private TextView mEmptyView;
    private int mColumns;
    private DetailListAdpter mDetailListAdpter;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private static final int REFRESH_DURATION = 1500;
    private static final int LOADMORE_DURATION = 3000;

    public DetailListFragment(){

    }

//    public DetailListFragment(int siteId,int channelId){
//        mStiteId = siteId;
//        mChannelId = channelId;
//    }

    public static Fragment newInstance(int siteId,int channelId){
        DetailListFragment fragment = new DetailListFragment();
        mSiteId = siteId;
        mChannelId = channelId;
        Bundle bundle = new Bundle();
        bundle.putInt(CHANNEL_ID,channelId);
        bundle.putInt(SITE_ID,siteId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        if(mSiteId == Site.LETV){
            mDetailListAdpter = new DetailListAdpter();
            mColumns = 2;
            mDetailListAdpter.setColumns(mColumns);
        }
    }

    @Override
    protected void initView() {
        mEmptyView = bindViewId(R.id.tv_empty);
        mEmptyView.setText(getActivity().getResources().getString(R.string.load_more_text));
        mRecycleView = bindViewId(R.id.pullloadRecyclerView);
        mRecycleView.setGridLayout(3);
        mRecycleView.setAdapter(new DetailListAdpter());
        mRecycleView.setOnPullLoadMoreListener(new PullLoadMoreListener());

    }

    private void reFreshData(){
        //TODO 请求接口加载数据
    }

    private void loadData(){
        //TODO 请求接口加载数据
    }


    class  PullLoadMoreListener implements PullLoadRecycleView.OnPullLoadMoreListener{

        @Override
        public void refresh() {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    reFreshData();
                    mRecycleView.setRefreshConmpleted();
                }
            },REFRESH_DURATION);
        }

        @Override
        public void loadMore() {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadData();
                    mRecycleView.setLoadMoreCompleted();
                }
            },LOADMORE_DURATION);

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

        public void setColumns(int columns){
            //TODO
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

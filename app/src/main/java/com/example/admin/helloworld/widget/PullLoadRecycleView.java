package com.example.admin.helloworld.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.helloworld.R;

/**
 * Created by admin on 2018-09-18.
 */

public class PullLoadRecycleView extends LinearLayout {
    private Context mContext;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private boolean mIsRefresh = false;
    private boolean mIsLoadMore = false;
    private RecyclerView mRecyclerView;
    private View mFooterView;
    private AnimationDrawable mAnimationDrawable;
    private OnPullLoadMoreListener mOnPullLoadMoreListener;

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

        //RecycleView
        mRecyclerView = view.findViewById(R.id.recycleview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return mIsRefresh || mIsLoadMore;

            }
        });
        mRecyclerView.setVerticalScrollBarEnabled(false);
        mRecyclerView.addOnScrollListener(new RecylerViewOnScroll());

        mFooterView = view.findViewById(R.id.footer_view);
        ImageView imageView = mFooterView.findViewById(R.id.iv_load_img);
        imageView.setBackgroundResource(R.drawable.imooc_loading);
        mAnimationDrawable = (AnimationDrawable)imageView.getBackground();

        TextView textView = mFooterView.findViewById(R.id.tv_load_text);
        mFooterView.setVisibility(View.GONE);
        this.addView(view);
    }

    public void setGridLayout(int spanCount){
        GridLayoutManager manager = new GridLayoutManager(mContext,spanCount);
        //manager.setSpanCount(spanCount);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
    }

    public void setAdapter(RecyclerView.Adapter adapter){
        if(adapter !=null){
            mRecyclerView.setAdapter(adapter);
        }
    }

    class RecylerViewOnScroll extends RecyclerView.OnScrollListener{
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int firstItem = 0;
            int lastItem = 0;
            int totalCount = 0;
            RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
            totalCount = manager.getItemCount();
            if(manager instanceof GridLayoutManager){
                GridLayoutManager gridLayoutManager = (GridLayoutManager) manager;
                //第一个完全可见
                firstItem = gridLayoutManager.findFirstCompletelyVisibleItemPosition();
                //最后一个完全可见
                lastItem = gridLayoutManager.findLastCompletelyVisibleItemPosition();
                if(firstItem == 0 || firstItem == RecyclerView.NO_POSITION){
                    lastItem = gridLayoutManager.findLastVisibleItemPosition();
                }
            }

            //触发下拉加载更多
            if(mSwipeRefreshLayout.isEnabled()){
                mSwipeRefreshLayout.setEnabled(true);
            }
            else{
                mSwipeRefreshLayout.setEnabled(false);
            }

            if(!mIsLoadMore && totalCount-1 == lastItem && mSwipeRefreshLayout.isEnabled() && !mIsRefresh && (dx > 0||dy > 0)){
                mIsLoadMore = true;
                loadMoreData();
            }




        }


    }

    class SwipeRefreshLayoutOnRefresh implements  SwipeRefreshLayout.OnRefreshListener{

        @Override
        public void onRefresh() {
            if(!mIsRefresh){
                mIsRefresh = true;
                refreshData();
            }
        }
    }
    private void refreshData(){
        if(mOnPullLoadMoreListener != null){
            mOnPullLoadMoreListener.refresh();
        }
    }
    private void loadMoreData() {
        if(mOnPullLoadMoreListener != null){
            mOnPullLoadMoreListener.loadMore();
            mFooterView.animate().translationY(mFooterView.getHeight()).setInterpolator(new AccelerateDecelerateInterpolator())
                    .setDuration(300).setListener(new AnimatorListenerAdapter() {
                                                      @Override
                                                      public void onAnimationStart(Animator animation) {
                                                          super.onAnimationStart(animation);
                                                          mFooterView.setVisibility(View.VISIBLE);
                                                          mAnimationDrawable.start();
                                                      }
                                                  }
            ).start();
            invalidate();
            mOnPullLoadMoreListener.loadMore();
        }
    }

    public void setRefreshConmpleted(){
        mIsRefresh = false;
        setRefresh(false);
    }

    private void setRefresh(final boolean isRefreshing) {
        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(isRefreshing);
            }
        });
    }

    public void setLoadMoreCompleted(){
        mIsRefresh =false;
        mIsLoadMore = false;
        setRefresh(false);
    }

    public interface OnPullLoadMoreListener{
       void refresh();
       void loadMore();
    }

    public void setOnPullLoadMoreListener(OnPullLoadMoreListener listener){
        mOnPullLoadMoreListener = listener;
    }
}

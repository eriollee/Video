package com.example.admin.helloworld;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

/**
 * Created by admin on 2018-09-10.
 */

public class HomeFragment extends BaseFragment {
    private GridView mGridView ;

    @Override
    protected void initView() {
       LoopViewPager viewPager = bindViewId(R.id.looperviewpager);
       CircleIndicator indicator = bindViewId(R.id.indicator);
       viewPager.setAdapter(new HomePicAdapter(getActivity()));
       viewPager.setLooperPic(true);//5s轮询indicator
       indicator.setViewPager(viewPager);
//       mGridView = bindViewId(R.id.gv_channel);
//       mGridView.setAdapter();
    }

    class ChannelAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }
}

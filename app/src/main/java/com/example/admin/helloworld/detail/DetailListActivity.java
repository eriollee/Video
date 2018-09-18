package com.example.admin.helloworld.detail;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.example.admin.helloworld.BaseActivity;
import com.example.admin.helloworld.model.Channel;
import com.example.admin.helloworld.R;
import com.example.admin.helloworld.model.Site;

import java.util.HashMap;

/**
 * Created by admin on 2018-09-17.
 */

public class DetailListActivity extends BaseActivity {

    private static final String CHANNEL_ID="channid";
    private int mChannelId;
    private ViewPager mViewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail_list;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if(intent != null){
            mChannelId = intent.getIntExtra(CHANNEL_ID,0);
        }
        Channel channel = new Channel(mChannelId,this);
        String titleName = channel.getChannelName();
        setSupportActionBar();//表示当前页面支持ActionBar
        setSupportArrowActionBar(true);
        setTitle(titleName);
        mViewPager = bindViewId(R.id.pager);
        mViewPager.setAdapter(new SitePagerAdapter(getSupportFragmentManager(),this,mChannelId));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void initData() {

    }

    private class SitePagerAdapter extends FragmentPagerAdapter{
        private Context mContext;
        private int mChannelID;
        private HashMap<Integer,DetailListFragment> mPagerMap;

        public SitePagerAdapter(FragmentManager fm ,Context context,int channelId){
            super(fm);
            mContext = context;
            mChannelID = channelId;
            mPagerMap = new HashMap<>();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            Object obj =  super.instantiateItem(container, position);
            if(obj instanceof  DetailListFragment){
                mPagerMap.put(position,(DetailListFragment)obj);
            }
            return obj;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
            mPagerMap.remove(position);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = DetailListFragment.newInstance(new Site(1,mContext).getSiteId(),mChannelId);
            return fragment;
        }

        @Override
        public int getCount() {
            return Site.MAX_SITE;
        }
    }

    public static void launchDetailListActivity(Context context,int channelId){
        Intent intent = new Intent(context,DetailListActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra(CHANNEL_ID,channelId);
        context.startActivity(intent);

    }
}

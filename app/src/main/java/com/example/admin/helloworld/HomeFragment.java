package com.example.admin.helloworld;

import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.helloworld.detail.DetailListActivity;
import com.example.admin.helloworld.model.Channel;
import com.hejunlin.superindicatorlibray.CircleIndicator;
import com.hejunlin.superindicatorlibray.LoopViewPager;

/**
 * Created by admin on 2018-09-10.
 */

public class HomeFragment extends BaseFragment {
    private GridView mGridView ;
    private static final String TAG = HomeFragment.class.getSimpleName();

    @Override
    protected void initView() {
       LoopViewPager viewPager = bindViewId(R.id.looperviewpager);
       CircleIndicator indicator = bindViewId(R.id.indicator);
       viewPager.setAdapter(new HomePicAdapter(getActivity()));
       viewPager.setLooperPic(true);//5s轮询indicator
       indicator.setViewPager(viewPager);
       mGridView = bindViewId(R.id.gv_channel);
       mGridView.setAdapter(new ChannelAdapter());
       mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Log.d(TAG,">> onItemClick " + position);
                switch (position){
                    case 6:
                        //TODO
                        break;
                    case 7:
                        //TODO
                        break;
                    case 8:
                        //TODO
                        break;
                    default:
                        //TODO
                        //跳转对应频道
                        DetailListActivity.launchDetailListActivity(getActivity(),position+1);
                        break;
                }
           }
       });
    }

    class ChannelAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return Channel.MAX_COUNT;
        }

        @Override
        public Channel getItem(int position) {
            return new Channel(position + 1, getActivity());
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Channel chanel = getItem(position);
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.home_grid_item, null);
                holder = new ViewHolder();
                holder.textView =  convertView.findViewById(R.id.tv_home_item_text);
                holder.imageView = convertView.findViewById(R.id.iv_home_item_img);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.textView.setText(chanel.getChannelName());
            int id = chanel.getChannelId();
            int imgResId = -1;
            switch (id) {
                case Channel.SHOW:
                    imgResId = R.drawable.ic_show;
                    break;
                case Channel.MOVIE:
                    imgResId = R.drawable.ic_movie;
                    break;
                case Channel.COMIC:
                    imgResId = R.drawable.ic_comic;
                    break;
                case Channel.DOCUMENTRY:
                    imgResId = R.drawable.ic_movie;
                    break;
                case Channel.MUSIC:
                    imgResId = R.drawable.ic_music;
                    break;
                case Channel.VARIETY:
                    imgResId = R.drawable.ic_variety;
                    break;
                case Channel.LIVE:
                    imgResId = R.drawable.ic_live;
                    break;
                case Channel.FAVORITE:
                    imgResId = R.drawable.ic_bookmark;
                    break;
                case Channel.HISTORY:
                    imgResId = R.drawable.ic_history;
                    break;
            }

            holder.imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), imgResId));

            return convertView;
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    class ViewHolder{
        TextView textView;
        ImageView imageView;
    }
}

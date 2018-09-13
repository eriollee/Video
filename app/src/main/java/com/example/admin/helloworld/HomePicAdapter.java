package com.example.admin.helloworld;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin on 2018-09-13.
 */

public class HomePicAdapter extends PagerAdapter{
    private Context mContext;

    private int[] mDes = new int[]{
            R.string.a_name,
            R.string.b_name,
            R.string.c_name,
            R.string.d_name,
            R.string.e_name,
    };

    private int[] mImg= new int[]{
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
    };


    public HomePicAdapter(Activity activity){
        mContext = activity;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       // return super.instantiateItem(container, position);
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_pic_item,null);
        TextView textView = view.findViewById(R.id.tv_dec);
        textView.setText(mDes[position]);
        ImageView imageView =  view.findViewById(R.id.iv_img);
        imageView.setImageResource(mImg[position]);
        container.addView(view);
        return  view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View)object);

    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}

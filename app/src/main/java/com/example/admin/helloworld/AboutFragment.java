package com.example.admin.helloworld;

import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

/**
 * Created by admin on 2018-09-10.
 */

public class AboutFragment extends BaseFragment {
    @Override
    protected void initView() {
        TextView textView = bindViewId(R.id.tv_app_des);
        textView.setAutoLinkMask(Linkify.ALL);//有链接可点
        textView.setMovementMethod(LinkMovementMethod.getInstance());//文字可以滚动
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_about;
    }
}

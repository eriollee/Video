package com.example.admin.helloworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by admin on 2018-09-10.
 */

public abstract class BaseFragment extends Fragment {

    private View mContentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mContentView = getActivity().getLayoutInflater().inflate(getLayoutId(),container,false);
        initView();
        initData();
        return mContentView;
    }

    protected abstract void initView();
    protected abstract void initData();
    protected abstract int getLayoutId();

    protected <T extends View> T bindViewId(int resId){
        return (T) mContentView.findViewById(resId);
    }
}

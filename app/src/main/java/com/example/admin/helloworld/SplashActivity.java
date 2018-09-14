package com.example.admin.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends Activity {
    private SharedPreferences mSharedPreference; //读取配置文件
    private static  final int GO_HOME = 1;//进入HOME页
    private static final  int GO_GUIDE = 2;//进入引导页
    private static final  int ENTER_DURATION = 1000;//延时
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GO_GUIDE:
                    startGuideActivity();
                    break;
                case GO_HOME:
                    startHomeActivity();
                    break;
                default:
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    //    mSharedPreference = getSharedPreferences("config",MODE_PRIVATE);
        init();
    }

    private void init() {
        SharedPreferences pref = getSharedPreferences("config",MODE_PRIVATE);
        Boolean isFirstIn = pref.getBoolean("mIsFirstIn",true);
        Log.d("isFirstIn",">> isFirstIn=== " + isFirstIn);
        if(isFirstIn == true){
            mHandler.sendEmptyMessageDelayed(GO_GUIDE,ENTER_DURATION);
        }else {
            mHandler.sendEmptyMessageDelayed(GO_HOME,ENTER_DURATION);
        }
    }


    private void startHomeActivity() {
        Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
    private void startGuideActivity(){
        Intent intent = new Intent(SplashActivity.this,GuideActivity.class);
        startActivity(intent);
        finish();
    }

}

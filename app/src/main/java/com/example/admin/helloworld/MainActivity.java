package com.example.admin.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences mSharedPreference; //读取配置文件
    private static  final int GO_HOME = 1;//进入HOME页
    private static final  int GO_GUIDE = 2;//进入引导页
    private static final  int ENTER_DURATION = 2000;//延时
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
        mSharedPreference = getSharedPreferences("config",MODE_PRIVATE);
        init();
    }

    private void init() {
        Boolean isFirstIn = mSharedPreference.getBoolean("mIsFirstIn",true);
        if(isFirstIn){
            mHandler.sendEmptyMessageDelayed(GO_GUIDE,ENTER_DURATION);
        }else {
            mHandler.sendEmptyMessageDelayed(GO_HOME,ENTER_DURATION);
        }
    }


    private void startHomeActivity() {
        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }
    private void startGuideActivity(){
        Intent intent = new Intent(MainActivity.this,GuideActivity.class);
        startActivity(intent);
        finish();
    }

}

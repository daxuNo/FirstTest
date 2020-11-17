package com.example.grouppurchaseapp.activity;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.grouppurchaseapp.MainActivity;
import com.example.grouppurchaseapp.R;

import java.util.HashMap;

public class SplashActivity extends AppCompatActivity {

    Handler mHandler=new Handler();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp=getPreferences(MODE_PRIVATE);
                boolean isFirst=sp.getBoolean("isFirst",true);
                Intent intent = new Intent();
                if (isFirst){
                    sp.edit().putBoolean("isFirst",false).commit();
                    //第一次安装应用进入
                    intent.setClass(SplashActivity.this,GuideActivity.class);
                }else {
                    intent.setClass(SplashActivity.this, MainActivity.class);
                }
                startActivity(intent);
                //可以设置界面之间切换动画  进入动画
                overridePendingTransition(R.anim.scaleanim,R.anim.scaleanim);
                finish();
            }
        }, 3000);

    }
}

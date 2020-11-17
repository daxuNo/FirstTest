package com.example.grouppurchaseapp;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTabHost;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grouppurchaseapp.fragment.AroundFragment;
import com.example.grouppurchaseapp.fragment.MainFragment;
import com.example.grouppurchaseapp.fragment.MineFragment;
import com.example.grouppurchaseapp.fragment.MoreFragment;

public class MainActivity extends FragmentActivity {

    private Class[] fragments = new Class[]{MainFragment.class, AroundFragment.class, MineFragment.class, MoreFragment.class};
    private int[] imgSelectors = new int[]{
            R.drawable.index,
            R.drawable.near,
            R.drawable.my,
            R.drawable.more
    };
    private String[] tabTitles=new String[]{"首页","周边","我的","更多"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTabHost tabHost = findViewById(R.id.tabHost);
        tabHost.setup(MainActivity.this, getSupportFragmentManager(), android.R.id.tabcontent);

        for (int i = 0; i < fragments.length; i++) {
            View inflate = getLayoutInflater().inflate(R.layout.tab_item, null);
            ImageView tab_iv = inflate.findViewById(R.id.iv);
            TextView tab_tv = inflate.findViewById(R.id.tv);
            tab_iv.setImageResource(imgSelectors[i]);
            tab_tv.setText(tabTitles[i]);
            tabHost.addTab(tabHost.newTabSpec("首页"+i).setIndicator(inflate), fragments[i], null);

        }

    }
}
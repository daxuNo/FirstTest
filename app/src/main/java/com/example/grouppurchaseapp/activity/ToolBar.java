package com.example.grouppurchaseapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import com.example.grouppurchaseapp.R;

public class ToolBar extends AppCompatActivity {

    private Toolbar mToolbar;
    private Toolbar mToolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        mToolbar = findViewById(R.id.toolbar);
        //设置主标题     需要设置在setSupportActionBar之前
        mToolbar.setTitle("主标题");
        setSupportActionBar(mToolbar);

        //设置导航栏图标
        mToolbar1.setNavigationIcon(R.drawable.index1);
        //设置APP logo
        mToolbar.setLogo(R.mipmap.ic_launcher);
        //设置子标题
        mToolbar.setSubtitle("子标题");
        //
        mToolbar.inflateMenu(R.menu.toolbar_menu);
        //设置菜单
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
}
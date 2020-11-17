package com.example.grouppurchaseapp.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.grouppurchaseapp.R;

//主页Fragment

public class MainFragment extends Fragment {
    private int imgResID[] = new int[]{R.drawable.banner1, R.drawable.banner2, R.drawable.banner3};
    private ViewPager mViewPager;
    private View view;
    private Handler mHandle = new Handler();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);
        mViewPager = view.findViewById(R.id.viewPager);
        mViewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));
        autoScroll();

        return view;
    }

    //自动滚动
    private void autoScroll() {
        mHandle.postDelayed(new Runnable() {
            @Override
            public void run() {
                //获取当前页面下标
                int currentItem = mViewPager.getCurrentItem();
                if (currentItem==imgResID.length-1){
                    mViewPager.setCurrentItem(0);
                }else {
                    mViewPager.setCurrentItem(currentItem+1);
                }

                mHandle.postDelayed(this,2000);
            }
        },2000);
    }

    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        //返回fragment的视图
        @NonNull
        @Override
        public Fragment getItem(int position) {
            BannerFragment bannerFragment = new BannerFragment();
            bannerFragment.setImage(imgResID[position]);
            return bannerFragment;
        }

        @Override
        public int getCount() {
            return imgResID.length;
        }
    }
}
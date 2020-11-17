package com.example.grouppurchaseapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.grouppurchaseapp.R;
import com.example.grouppurchaseapp.view.Indicator;

import java.util.ArrayList;
import java.util.List;

public class TestViewActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private List<View> mViews = new ArrayList<>();
    private Indicator mIndicator;
    private Handler mHandle = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view);
        initData();
        mViewPager = findViewById(R.id.test_view_vp);
        mViewPager.setAdapter(new MyAdapter());

        mIndicator = findViewById(R.id.indicator);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //滚动的时候

            /**
             *
             * @param position
             * @param positionOffset    偏移百分比
             * @param positionOffsetPixels  偏移量
             */
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mIndicator.setQffset(position, positionOffset);
            }

            //选中的时候
            @Override
            public void onPageSelected(int position) {

            }

            //滑动的时候
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        autoScroll();
    }


    //自动滚动
    private void autoScroll() {
        mHandle.postDelayed(new Runnable() {
            @Override
            public void run() {
                //获取当前页面下标
                int currentItem = mViewPager.getCurrentItem();
                if (currentItem == mViews.size() - 1) {
                    mViewPager.setCurrentItem(0);
                    mIndicator.setQffset(0, 0);
                } else {
                    mViewPager.setCurrentItem(currentItem + 1);
                }

                mHandle.postDelayed(this, 2000);
            }
        }, 2000);
    }

    private void initData() {
        for (int i = 0; i < 4; i++) {
            View view = getLayoutInflater().inflate(R.layout.test_item, null);
            ImageView imageView = view.findViewById(R.id.ic_launcher);
            imageView.setImageResource(R.drawable.guide1);
            mViews.add(view);
        }
    }

    class MyAdapter extends PagerAdapter {
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
            container.removeView(mViews.get(position));
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = mViews.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }
    }
}
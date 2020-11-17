package com.example.grouppurchaseapp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.grouppurchaseapp.MainActivity;
import com.example.grouppurchaseapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 引导界面
 */
public class GuideActivity extends AppCompatActivity {

    //获取图片资源
    int [] imgRes=new int[]{R.drawable.guide1,R.drawable.guide2,R.drawable.guide3};
    private ViewPager mViewPager;
    private List<View> mViewList=new ArrayList<>();
    private Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        mViewPager=findViewById(R.id.viewPage_guide);
        initData();
        btnStart=findViewById(R.id.btn_start);

        MyPagerAdapter adapter=new MyPagerAdapter();
        mViewPager.setAdapter(adapter);
        setListener();



    }

    private void setListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //ViewPager 滚动到第几张
            @Override
            public void onPageSelected(int position) {
                //加入ViewPage滚动到最后一张  显示Button
                if (position==imgRes.length-1){
                    btnStart.setVisibility(View.VISIBLE);
                    Animation animation = AnimationUtils.loadAnimation(GuideActivity.this, R.anim.anim_guide_btn_start);
                    btnStart.startAnimation(animation);
                }else{
                    btnStart.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                finish();
            }
        });
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i=0;i<imgRes.length;i++) {
            View inflate = getLayoutInflater().inflate(R.layout.guide_item, null);
            ImageView iv_guide = inflate.findViewById(R.id.iv_guide);
            iv_guide.setBackgroundResource(imgRes[i]);
            mViewList.add(inflate);

        }
    }

    /**
     * 引导界面ViewPager适配器
     */
    class MyPagerAdapter extends PagerAdapter{

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = mViewList.get(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView(mViewList.get(position));
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view==object;//官方推荐的写法
        }


    }


}
package com.example.grouppurchaseapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.grouppurchaseapp.R;

public class BannerFragment extends Fragment {

    private int imgRes;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_banner, container, false);
        ImageView iv_banner=view.findViewById(R.id.iv_banner);
        iv_banner.setImageResource(imgRes);
        return view;
    }

    public void setImage(int imgRes){
        this.imgRes=imgRes;
    }
}
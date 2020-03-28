package com.example.gallery;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements View.OnClickListener,ViewPager.OnPageChangeListener {

    private Button btnPrevious, btnNext;
    private int position = 0, totalImage;
    private ViewPager viewPage;
    private ArrayList<Integer> item;
    private FragmentPagerAdapter adapter;
    private Images imageId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPage = findViewById(R.id.viewPager);
        btnPrevious = findViewById(R.id.btnImagePrevious);
        btnNext = findViewById(R.id.btnImageNext);
        imageId = new Images();
        item = imageId.getImageItem();
        totalImage = item.size();
        setPage(position);
        adapter = new FragmentPagerAdapter(getSupportFragmentManager(),item);
        viewPage.setAdapter(adapter);
        viewPage.setOnPageChangeListener(MainActivity.this);
        btnPrevious.setOnClickListener(this);
        btnNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnPrevious) {
            position--;
            viewPage.setCurrentItem(position);
        } else if (v == btnNext) {
            position++;
            viewPage.setCurrentItem(position);
        }
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int position) {
        this.position = position;
        setPage(position);
    }

    private void setPage(int page) {
        if (page == 0 && totalImage > 0) {
            btnNext.setVisibility(View.VISIBLE);
            btnPrevious.setVisibility(View.INVISIBLE);
        } else if (page == totalImage - 1 && totalImage > 0) {
            btnNext.setVisibility(View.INVISIBLE);
            btnPrevious.setVisibility(View.VISIBLE);
        } else {
            btnNext.setVisibility(View.VISIBLE);
            btnPrevious.setVisibility(View.VISIBLE);
        }
    }
}

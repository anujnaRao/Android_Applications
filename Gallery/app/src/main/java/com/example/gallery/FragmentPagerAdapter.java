package com.example.gallery;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class FragmentPagerAdapter extends FragmentStatePagerAdapter{
    private ArrayList<Integer> item;
    public FragmentPagerAdapter(@NonNull FragmentManager fm , ArrayList<Integer> item) {
        super(fm);
        this.item = item;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        FragmentImageView f = FragmentImageView.newInstance();
        f.setImageList(item.get(position));
        return f;
    }

    @Override
    public int getCount() {
        return item.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter{
    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new Home();
            case 1:
                return new Sports();
            case 2:
                return new Technology();
            case 3:
                return new Health();
            case 4:
                return new Entertainment();
            case 5:
                return new Science();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}

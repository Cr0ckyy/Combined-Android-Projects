package com.myapplicationdev.android.c347_l6_ps_know_your_facts;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
//todo Create the FragmentPagerAdapter subclass and set the adapter in  the Activity,
// as you had learnt in the worksheet.
public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragments;

    public MyFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> al) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragments = al;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

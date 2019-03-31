package com.eims.app.adapter.viewadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * @author bobo
 * @date 2018/10/15
 * describe
 */
public class FindViewpagerAdapter extends FragmentStatePagerAdapter {

    private String[] mTitles;
    private ArrayList<Fragment> mFragments;

    public FindViewpagerAdapter(FragmentManager fm, String[] mTitles, ArrayList<Fragment>
            mFragments) {
        super(fm);
        this.mTitles = mTitles;
        this.mFragments = mFragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
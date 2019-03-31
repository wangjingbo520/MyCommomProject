package com.eims.app.ui.fragment;


import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.eims.app.R;
import com.eims.app.adapter.viewadapter.FindViewpagerAdapter;
import com.eims.app.base.BaseFragment;
import com.eims.app.ui.fragment.childfragment.ChildFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author bobo
 * @date 2018/9/1
 * describe
 */
public class OneFragment extends BaseFragment {
    private FragmentManager fragmentManager;
    private TabLayout tl_tab;
    private ViewPager vp_content;

    private ArrayList<Fragment> mFragments;
    private String[] mTitles;


    @Override
    public void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_one;
    }

    @Override
    public void initView(View view) {
        vp_content = view.findViewById(R.id.vp_content);
        tl_tab = view.findViewById(R.id.tl_tab);
        fragmentManager = getChildFragmentManager();
        mFragments = new ArrayList<>();
        mTitles = getResources().getStringArray(R.array.tab_home);
        mFragments.add(new ChildFragment());
        mFragments.add(new ChildFragment());
        mFragments.add(new ChildFragment());
        mFragments.add(new ChildFragment());
        mFragments.add(new ChildFragment());
        vp_content.setOffscreenPageLimit(3);
        vp_content.setAdapter(new FindViewpagerAdapter(fragmentManager, mTitles,
                mFragments));
        tl_tab.setupWithViewPager(vp_content);
        setIndicator(tl_tab);
    }

    private void setIndicator(TabLayout tabs) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        assert tabStrip != null;
        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int left = (int) (getResources().getDisplayMetrics().density * 10);
        int right = (int) (getResources().getDisplayMetrics().density * 10);
        assert ll_tab != null;
        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            View child = ll_tab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout
                    .LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

}

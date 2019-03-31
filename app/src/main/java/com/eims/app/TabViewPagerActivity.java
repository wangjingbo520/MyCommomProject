package com.eims.app;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;

import com.eims.app.adapter.viewadapter.FindViewpagerAdapter;
import com.eims.app.base.BaseActivity;
import com.eims.app.ui.fragment.OneFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author bobo
 * @date 2018/9/1
 * describe tablayout + viewPager
 */
public class TabViewPagerActivity extends BaseActivity {

    @BindView(R.id.tl_tab)
    TabLayout tlTab;
    @BindView(R.id.vp_content)
    ViewPager vpContent;
    private ArrayList<Fragment> mFragments;
    private String[] mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main2);
        bindView();
    }

    private void bindView() {
        mTitles = getResources().getStringArray(R.array.tab_titles);
        mFragments = new ArrayList<>();
        mFragments.add(new OneFragment());
        mFragments.add(new OneFragment());
        mFragments.add(new OneFragment());
        mFragments.add(new OneFragment());
        mFragments.add(new OneFragment());
        vpContent.setOffscreenPageLimit(3);
        vpContent.setAdapter(new FindViewpagerAdapter(getSupportFragmentManager(), mTitles,
                mFragments));
        tlTab.setupWithViewPager(vpContent);
        setIndicator(tlTab);
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

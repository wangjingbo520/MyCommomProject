package com.eims.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.eims.app.base.MyNetDataBaseActivity;
import com.eims.app.ui.fragment.OneFragment;
import com.eims.app.ui.fragment.ThreeFragment;
import com.eims.app.ui.fragment.TwoFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author bobo
 * @date 2018/9/1TabHomeActivity
 * describe 主页
 */
public class TabHomeActivity extends MyNetDataBaseActivity {
    private OneFragment oneFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private List<Fragment> fragmentList = new ArrayList<>();
    private static final String HOME_FRAGMENT_KEY = "homeFragment";
    private static final String DASHBOARD_FRAGMENT_KEY = "DashboardFragment";
    private static final String NOTICE_FRAGMENT_KEY = "NoticeFragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_tab_home);
        setTitle("TabHomeActivity");
        if (savedInstanceState != null) {
            /*获取保存的fragment  没有的话返回null*/
            oneFragment = (OneFragment) getSupportFragmentManager().getFragment
                    (savedInstanceState, HOME_FRAGMENT_KEY);
            twoFragment = (TwoFragment) getSupportFragmentManager().getFragment
                    (savedInstanceState, DASHBOARD_FRAGMENT_KEY);
            threeFragment = (ThreeFragment) getSupportFragmentManager().getFragment
                    (savedInstanceState, NOTICE_FRAGMENT_KEY);
            addToList(oneFragment);
            addToList(twoFragment);
            addToList(threeFragment);
        } else {
            initFragment();
        }
    }

    private void addToList(Fragment fragment) {
        if (fragment != null) {
            fragmentList.add(fragment);
        }
    }

    private void initFragment() {
        /* 默认显示home  fragment*/
        oneFragment = new OneFragment();
        addFragment(oneFragment);
        showFragment(oneFragment);
    }

    private void addFragment(Fragment fragment) {
        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().add(R.id.tab_content, fragment).commit();
            fragmentList.add(fragment);
        }
    }

    private void showFragment(Fragment fragment) {
        for (Fragment frag : fragmentList) {
            if (frag != fragment) {
                getSupportFragmentManager().beginTransaction().hide(frag).commit();
            }
        }
//        if (fragment instanceof TwoFragment || fragment instanceof ThreeFragment) {
//            fragment.onResume();
//        }
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        /*fragment不为空时 保存*/
        if (oneFragment != null) {
            getSupportFragmentManager().putFragment(outState, HOME_FRAGMENT_KEY, oneFragment);
        }
        if (twoFragment != null) {
            getSupportFragmentManager().putFragment(outState, DASHBOARD_FRAGMENT_KEY,
                    twoFragment);
        }
        if (threeFragment != null) {
            getSupportFragmentManager().putFragment(outState, NOTICE_FRAGMENT_KEY, threeFragment);
        }
        super.onSaveInstanceState(outState);
    }


}

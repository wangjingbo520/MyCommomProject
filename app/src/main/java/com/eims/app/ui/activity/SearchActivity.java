package com.eims.app.ui.activity;

import android.os.Bundle;

import com.eims.app.R;
import com.eims.app.base.BaseActivity;

/**
 * @author bobo
 * @date 2018/9/1
 * describe 搜索
 */
public class SearchActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_search);
        setTitleLayoutVisiable(false);
        initEvent();
    }

    private void initEvent() {
//        fairySearchView.setOnBackClickListener(new FairySearchView.OnBackClickListener() {
//            @Override
//            public void onClick() {
//                //TODO
//                finish();
//            }
//        });
//
//        fairySearchView.setOnCancelClickListener(new FairySearchView.OnCancelClickListener() {
//            @Override
//            public void onClick() {
//                finish();
//            }
//        });
//
//        fairySearchView.setOnEditChangeListener(new FairySearchView.OnEditChangeListener() {
//            @Override
//            public void onEditChanged(String nowContent) {
//                //nowContent：输入框中的内容
//            }
//        });
//
//        fairySearchView.setOnEnterClickListener(new FairySearchView.OnEnterClickListener() {
//            @Override
//            public void onEnterClick(String content) {
//                //content：输入框中的内容
//            }
//        });

    }
}

package com.eims.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.eims.app.base.MyNetDataBaseActivity;
import com.eims.app.ui.activity.SearchActivity;

/**
 * @author bobo
 * @date 2018/9/1
 * describe 首页
 */
public class MainActivity extends MyNetDataBaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_main);
        initEvent();
    }

    private void initEvent() {
        findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, SearchActivity.class));
            }
        });
        findViewById(R.id.btnLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, ScrollingActivity.class));
            }
        });
    }
}

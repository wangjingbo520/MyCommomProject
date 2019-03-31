package com.eims.app;

import android.os.Bundle;
import android.view.View;

import com.eims.app.base.MyNetDataBaseActivity;
import com.eims.app.bean.User;
import com.eims.app.net.InterfaceMethod;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ScrollingActivity extends MyNetDataBaseActivity<User> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.button, R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                map.put("userName", "15575163734");
                map.put("pwd", "123456789");
                postString(InterfaceMethod.LOGIN, map);
                break;
            case R.id.button2:
                break;
            default:
                break;
        }
    }

    @Override
    public void onNetDataT(String url, User data) {
        super.onNetDataT(url, data);
    }
}

package com.eims.app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eims.app.R;
import com.eims.app.SidebarActivity;
import com.eims.app.TabHomeActivity;
import com.eims.app.TabViewPagerActivity;
import com.eims.app.base.MyNetDataBaseActivity;


import butterknife.OnClick;

/**
 * @author bobo
 * @date 2018/9/1
 * describe 登录
 */
public class LoginActivity extends MyNetDataBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_login);
        setTitle("登录");
    }

    @OnClick({R.id.tvLogin, R.id.tvPicture, R.id.tvTabViewpager, R.id.sidebar})
    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.tvLogin:
//                CustomDialog customDialog = new CustomDialog(this, "提示", "您确定登录吗?");
//                customDialog.show();
                //      startActivity(new Intent(mContext, MainActivity.class));
                startActivity(new Intent(mContext, TabHomeActivity.class));
                break;
            case R.id.tvPicture:

                break;
            case R.id.tvTabViewpager:
                startTo(TabViewPagerActivity.class, false);
                break;
            case R.id.sidebar:
                startTo(SidebarActivity.class, false);
                break;
            default:
                break;
        }
    }

}

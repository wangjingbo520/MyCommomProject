package com.eims.app.ui.activity;

import android.os.Bundle;

import com.eims.app.R;
import com.eims.app.base.BaseActivity;

/**
 * @author bobo
 * @date 2018/9/1
 * describe 忘记密码
 */
public class ForgetPasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_forget_password);
        setTitle("忘记密码");
    }
}

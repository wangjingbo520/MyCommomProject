package com.eims.app.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author bobo
 * @date 2018/10/8
 * describe fragment 基类
 */
public abstract class BaseFragment extends Fragment {
    protected final String TAG = this.getClass().getSimpleName();
    private Unbinder mUnBinder;
    public View mRootView;
    public FragmentActivity mContext;

    public void startToActivity(Class c, boolean isFinish) {
        startActivity(new Intent(mContext, c));
        if (isFinish) {
            mContext.finish();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View view = null;
        if (getLayoutId() != 0) {
            this.mContext = this.getActivity();
            view = inflater.inflate(getLayoutId(), container, false);
            mUnBinder = ButterKnife.bind(this, view);
            mRootView = view;
            initView(view);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public View getRootView() {
        return mRootView;
    }

    /**
     * 数据初始化
     */
    public abstract void initData();

    /**
     * 初始化布局
     *
     * @return
     */
    protected abstract int getLayoutId();


    /**
     * 绑定布局
     *
     * @param view
     */
    public abstract void initView(View view);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
    }
}

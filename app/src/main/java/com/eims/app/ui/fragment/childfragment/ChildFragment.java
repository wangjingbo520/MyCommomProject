package com.eims.app.ui.fragment.childfragment;


import android.support.v4.app.Fragment;
import android.view.View;

import com.eims.app.R;
import com.eims.app.base.BaseFragment;
import com.youth.banner.Banner;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildFragment extends BaseFragment {
    private Banner banner;
    private ArrayList<String> images;

    @Override
    public void initData() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_child;
    }

    @Override
    public void initView(View view) {
        banner = view.findViewById(R.id.banner);
        images = new ArrayList<>();
        images.add("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1539768546818&di" +
                "=4571912d2edf62ac667e8341e298efad&imgtype=0&src=http%3A%2F%2Fimg2.niutuku" +
                ".com%2Fdesk%2F1208%2F1429%2Fntk-1429-9415.jpg");
        images.add("https://timgsa.baidu" +
                ".com/timg?image&quality=80&size=b9999_10000&sec=1539768546817&di" +
                "=6cffca2af15c3aa3cce8e54d16753677&imgtype=0&src=http%3A%2F%2Fs9.knowsky" +
                ".com%2Fbizhi%2Fl%2F20090808%2F200910296%2520%252841%2529.jpg");
      //  banner.setImages(images).setImageLoader(new GlideImageLoader()).start();
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
    }

}

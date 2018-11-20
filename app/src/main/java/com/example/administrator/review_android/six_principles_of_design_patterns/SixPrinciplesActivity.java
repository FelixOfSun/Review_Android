package com.example.administrator.review_android.six_principles_of_design_patterns;

import android.widget.ImageView;

import com.example.administrator.review_android.BaseActivity;
import com.example.administrator.review_android.R;
import com.example.administrator.review_android.six_principles_of_design_patterns.ocp.DiskCache;
import com.example.administrator.review_android.six_principles_of_design_patterns.ocp.ThreeLevelCache;
import com.example.administrator.review_android.six_principles_of_design_patterns.srp.ImageLoader;
import com.example.common.annotation.ContentView;
import com.example.common.annotation.ViewInject;

@ContentView(value = R.layout.activity_six_principles)
public class SixPrinciplesActivity extends BaseActivity {
    @ViewInject(R.id.iv_show_srp)
    ImageView iv_show_srp;

    @Override
    protected void initView() {
//        ImageLoader.instance()
//                .setImageCache(new ThreeLevelCache())
//                .displayImage("https://ww1.sinaimg.cn/large/0065oQSqly1ft5q7ys128j30sg10gnk5.jpg", iv_show_srp);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEnvent() {

    }
}

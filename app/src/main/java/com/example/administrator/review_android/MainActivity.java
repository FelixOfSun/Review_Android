package com.example.administrator.review_android;

import android.util.Log;
import android.view.View;

import com.example.administrator.review_android.six_principles_of_design_patterns.SixPrinciplesActivity;
import com.example.common.annotation.ContentView;


@ContentView(value = R.layout.activity_main)
public class MainActivity extends BaseActivity {

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEnvent() {

    }

    public void showPrinciples(View view) {
        enterActivity(SixPrinciplesActivity.class);
        showToast("跳转到六大原则");
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause 可见不可交互状态");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop 不可见状态");
        super.onStop();
    }
}

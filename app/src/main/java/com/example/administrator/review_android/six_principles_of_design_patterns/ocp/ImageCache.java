package com.example.administrator.review_android.six_principles_of_design_patterns.ocp;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2018/11/15.
 */

public interface ImageCache {

    public Bitmap get(String url);

    public void put(String url, Bitmap bitmap);
}

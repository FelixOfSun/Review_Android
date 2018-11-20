package com.example.administrator.review_android.six_principles_of_design_patterns.srp;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.example.administrator.review_android.six_principles_of_design_patterns.ocp.ImageCache;

/**
 * Created by Administrator on 2018/11/15.
 */

public class LruImageCache implements ImageCache{

    LruCache<String, Bitmap> mImageCache;

    public LruImageCache() {
        //计算机可使用的最大内存
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //取八分之一的可用内存作为缓存
        int cacheSize = maxMemory / 8;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        if (mImageCache != null) {
            mImageCache.put(url, bitmap);
        }
    }

    public Bitmap get(String url) {
        Bitmap bitmap = null;
        if (mImageCache != null) {
            bitmap = mImageCache.get(url);
        }
        return bitmap;
    }
}

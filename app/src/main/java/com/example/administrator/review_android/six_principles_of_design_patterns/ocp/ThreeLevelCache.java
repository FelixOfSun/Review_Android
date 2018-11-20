package com.example.administrator.review_android.six_principles_of_design_patterns.ocp;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;

import com.example.administrator.review_android.six_principles_of_design_patterns.srp.DownLoadImage;
import com.example.administrator.review_android.six_principles_of_design_patterns.srp.LruImageCache;

/**
 * Created by Administrator on 2018/11/15.
 */

public class ThreeLevelCache implements ImageCache {
    private LruImageCache mLruImageCache;
    private DiskCache mDiskCache;

    public ThreeLevelCache() {
        this.mLruImageCache = new LruImageCache();
        this.mDiskCache = new DiskCache();
    }

    @Override
    public Bitmap get(final String url) {
        Bitmap bitmap = null;
        bitmap = mLruImageCache.get(url);
        if (bitmap != null) {
            return bitmap;
        }

        bitmap = mDiskCache.get(url);
        if (bitmap != null) {
            return bitmap;
        }
        bitmap = DownLoadImage.downLoadImage(url);
        if (bitmap != null) {
            mLruImageCache.put(url, bitmap);
            mDiskCache.put(url, bitmap);
            return bitmap;
        }
        return null;
    }

    @Override
    public void put(String url, Bitmap bitmap) {

    }
}

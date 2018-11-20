package com.example.administrator.review_android.six_principles_of_design_patterns.srp;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ImageView;

import com.example.administrator.review_android.six_principles_of_design_patterns.ocp.ImageCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.单一职责原则 (Single Responsibility Principle)
 * 定义:就一个类而言，应该仅有一个引起它变化的原因。
 * 简单来说，一个类中应该是一组相关性很高的函数、数据的封装。
 * 因为单一职责的划分接线并不是总是那么清晰，很多时候都需要靠个人经验来界定。
 * 当然，最大的问题就是对职责的定义，什么是类的职责，以及怎么划分类的职责。
 */

public class ImageLoader {

    private static final String TAG = "ImageLoader.";
//    //内存缓存（直接依赖于细节）
//    LruImageCache mImageCache = null;
//
//    //SD卡缓存
//    DiskCache mDiskCache = null;

    //图片缓存类，依赖于抽象,并且有一个默认的实现
    ImageCache mImageCache = null;
    //线程池
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static ImageLoader instance;

    public static ImageLoader instance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }

    private ImageLoader() {
        initImageCache();
    }

    private void initImageCache() {
        mImageCache = new LruImageCache();
    }

    public void displayImage(final String imgUrl, final ImageView imageView) {
        imageView.setTag(imgUrl);
        final Bitmap bitmap = mImageCache.get(imgUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    Log.d(TAG, "主线程");
                } else {
                    Log.d(TAG, "子线程");
                }
                Bitmap bitmap = DownLoadImage.downLoadImage(imgUrl);
                if (bitmap != null) {
                    if (imageView.getTag().equals(imgUrl)) {
                        imageView.setImageBitmap(bitmap);
                    }
                    mImageCache.put(imgUrl, bitmap);
                }
            }
        });
    }

    //设置缓存策略，依赖于抽象
    public ImageLoader setImageCache(ImageCache mImageCache) {
        this.mImageCache = mImageCache;
        return this;
    }
}

package com.example.administrator.review_android.six_principles_of_design_patterns.srp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2018/11/15.
 */

public class DownLoadImage {
    private static final String TAG = "DownLoadImage.";

    public static Bitmap downLoadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                Log.d(TAG, "主线程");
            } else {
                Log.d(TAG, "子线程");
            }
            URL url = new URL(imageUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = connection.getInputStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}

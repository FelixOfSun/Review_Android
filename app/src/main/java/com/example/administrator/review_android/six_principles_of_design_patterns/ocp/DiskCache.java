package com.example.administrator.review_android.six_principles_of_design_patterns.ocp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.administrator.review_android.six_principles_of_design_patterns.isp.CloseUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 2.开闭原则(Open Close Principle)
 * 定义:：软件中的对象（类、模块、函数等）应该对于扩展是开放的，但是，对于修改是封闭的。
 * 在软件的生命周期内，因为变化、升级和维护等原因需要对软件原有代码进行修改时，
 * 可能会将错误引入原本已经经过测试的旧代码中，破坏原有系统。
 * 因此，当软件需要变化时，我们应该尽量通过扩展的方式来实现变化，而不是通过修改已有的代码来实现。
 * 也就是说，程序一旦开发完成，程序中的一个类的实现只应该因错误而被修改，
 * 新的或者改变的特性应该通过新建不同的类实现，新建的类可以通过继承的方式来重用原类的代码。
 * 已存在的实现类对于修改是封闭的，但是新的实现类可以通过复写父类的接口应对变化
 */

public class DiskCache implements ImageCache {

    static String cacheDir = "sdcard/cache/";

    public Bitmap get(String url) {
        String fileName = url.split("/")[url.split("/").length - 1];
        return BitmapFactory.decodeFile(cacheDir + fileName);
    }

    public void put(String imgUrl, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(cacheDir + imgUrl);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
//            if (fileOutputStream != null){
//                try {
//                    fileOutputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
            //接口隔离原则，使暴露的接口越少越好
            CloseUtils.close(fileOutputStream);
        }
    }
}

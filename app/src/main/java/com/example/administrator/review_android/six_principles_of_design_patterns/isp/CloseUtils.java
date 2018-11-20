package com.example.administrator.review_android.six_principles_of_design_patterns.isp;

import java.io.Closeable;
import java.io.IOException;

/**
 * 5.接口隔离原则(Interface Segregation Principle)
 * 定义:：客户端不应该依赖它不需要的接口。
 * 另一种定义是：类间的依赖关系应该建立在最小的接口上。
 * 接口隔离原则将非常庞大、臃肿的接口拆分成更小的和更具体的接口，这样客户端将会只知道特闷感兴趣的方法。
 * 接口隔离原则的目的是系统解开耦合，从而容易重构、更改和重新部署。
 */

public class CloseUtils {
    //关闭Closeable对象
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

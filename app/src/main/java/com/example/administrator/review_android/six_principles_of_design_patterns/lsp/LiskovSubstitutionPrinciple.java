package com.example.administrator.review_android.six_principles_of_design_patterns.lsp;

/**
 * 3.里氏替换原则(Liskov Substitution Principle)
 * 定义:如果对每一个类型为 S 的对象 O1，都有类型为 T 的对象 O2，
 * 使得以 T 定义的所有程序 P 在所有的对象 O1 都替换成 O2 时，程序 P 的行为没有发生变化，
 * 那么类型 S 是类型 T 的子类型。
 * 里氏替换原则第二种定义：所有引用基类的地方必须能透明地使用其子类对象。
 * 我们知道，面向对象的语言的三大特点是继承、封装、多态，里氏替换原则就是依赖于继承、多态这两大特性。
 * 里氏替换原则简单来说就是，所有引用基类的地方必须能够透明地使用其子类的对象。
 * 通俗点讲，只要父类能出现的地方子类就可以出现，而且替换为子类也不会产生任何错误或者异常，
 * 使用者可能根本就不需要知道是父类还是子类。但是反过来就不行了，有子类出现的地方，父类未必就能适应。
 * 说了这么多，其实总结就两个字：抽象
 */

public class LiskovSubstitutionPrinciple {
    //窗口类
    public class Window {
        public void show(View child) {
            child.draw();
        }
    }

    //建立视图抽象，测量视图的宽高为公用代码，绘制实现交由具体的子类
    public abstract class View {
        public abstract void draw();

        public void measure(int width, int height) {
            //测量视图的大小
        }
    }

    //按钮类的具体实现
    public class Button extends View {
        @Override
        public void draw() {
            //绘制按钮
        }
    }

    //TextView 的具体实现
    public class TextView extends View {
        @Override
        public void draw() {
            //绘制文本
        }
    }
}

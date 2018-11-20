package com.example.administrator.review_android.six_principles_of_design_patterns.dip;

/**
 * 4.依赖倒置原则(Dependence Inversion Principle)
 * 定义:依赖倒置原则指代了一个特定的解耦形式，使得高层次的模块不依赖低层次的模块的实现细节的目的，
 * 依赖倒置被颠倒了。
 * 依赖倒置原则有以下几个关键点：
 * <p>
 * （1）高层模块不应该依赖低层模块，两者都应该依赖其抽象；
 * （2）抽象不应该依赖细节；
 * （3）细节应该依赖抽象。
 * 在 Java 语言中，抽象就是指接口或抽象类，两者都是不能直接被实例化的；
 * 细节就是实现类，实现接口或继承抽象类而产生的类就是细节，其特点就是，可以直接被实例化，
 * 也就是可以加上一个关键字 new 产生一个对象。高层模块就是调用端，低层模块就是具体实现类。
 * 依赖倒置原则在 Java 语言中的表现就是：模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，
 * 其依赖关系是通过接口或者抽象类产生的。
 */

public class DependenceInversionPrinciple {
}

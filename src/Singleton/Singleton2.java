package Singleton;

import java.util.Date;

/**
 *  饿汉式：
* 	在类初始化时直接创建实例对象，不管你是否需要这个对象都会创建
 * 枚举类型：表示该类型的对象是有限的几个
 * 我们可以限定为一个，就成了单例
*构造函数默认是private 所以外部无法通过构造器创建枚举类的实例
**/
public enum Singleton2 {
    INSTANCE;
    public Date date=new Date();

//    public  Date getInstance(){
//        return this.date;
//    }
}

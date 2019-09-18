package Singleton;

import java.io.IOException;
import java.util.Properties;
/**
    *  饿汉式：
 * 	在类初始化时直接创建实例对象，不管你是否需要这个对象都会创建
 * 
    * 效果和Singleton1是一样的 
 * 
    * 区别是一个在静态成员变量调用构造函数  
    *             一个在静态代码块调用构造函数
 * 
    *  为了方便向构造函数传入外部配置文件中的值  初始化数据
 * 
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;

    static {
        try {
            Properties pro = new Properties();

            pro.load(Singleton3.class.getClassLoader().getResourceAsStream("Singleton/single.properties"));

            INSTANCE = new Singleton3(pro.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Singleton3(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3 [info=" + info + "]";
    }

}

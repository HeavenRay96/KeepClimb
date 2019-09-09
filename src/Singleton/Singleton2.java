package Singleton;

import java.util.Date;

/**
 * 枚举类型：表示该类型的对象是有限的几个
 * 我们可以限定为一个，就成了单例
 */
public enum Singleton2 {
    INSTANCE;
    private Date date;

    private Singleton2(){
        date=new Date();
    }
    public  Date getInstance(){
        return this.date;
    }
}

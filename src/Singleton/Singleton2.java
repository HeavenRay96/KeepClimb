package Singleton;

import java.util.Date;

/**
 * ö�����ͣ���ʾ�����͵Ķ��������޵ļ���
 * ���ǿ����޶�Ϊһ�����ͳ��˵���
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

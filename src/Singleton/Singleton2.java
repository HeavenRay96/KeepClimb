package Singleton;

import java.util.Date;

/**
 * ö�����ͣ���ʾ�����͵Ķ��������޵ļ���
 * ���ǿ����޶�Ϊһ�����ͳ��˵���
*���캯��Ĭ����private �����ⲿ�޷�ͨ������������ö�����ʵ��
**/
public enum Singleton2 {
    INSTANCE;
    public Date date=new Date();

//    public  Date getInstance(){
//        return this.date;
//    }
}

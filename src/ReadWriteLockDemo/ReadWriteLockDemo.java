package ReadWriteLockDemo;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        //ʮ��д�߳�
        for (int i = 1; i <= 10; i++) {
            final int tempInt=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                   myCache.put(tempInt+"", "");
                }
            },"Thread "+i).start();

        }
       //ʮ�����߳�
        for (int i = 1; i <= 10; i++) {
            final int tempInt=i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    myCache.get(tempInt+"");
                }
            },"Thread "+i).start();

        }


    }
}

/**
 * Description:
 * ����߳�ͬʱ���� һ����Դ��û���κ����� ����Ϊ�����㲢����
 * ��ȡ������ԴӦ�ÿ���ͬʱ����
 * ����
 * �����һ���߳���ȥд������Դ��  �Ͳ�Ӧ���������߳̿��Զ���Դ���ж���д
 *
 * С�ܽ�:
 * �� ���ܹ���
 * �� д���ܹ���
 * д д���ܹ���
 * д���� ԭ��+��ռ �������̱�����һ����ɵ�ͳһ���� �м䲻�����ָ� �����
 **/

//��Դ��
class MyCache {

    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

   //д
    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " ����д��: " + key);
            TimeUnit.MILLISECONDS.sleep(300);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + " д����ɡ�");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
    //��
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " ���ڶ�ȡ: ");
            TimeUnit.MILLISECONDS.sleep(300);
            map.get(key);
            System.out.println(Thread.currentThread().getName() + " ��ȡ��ɡ�");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }


}
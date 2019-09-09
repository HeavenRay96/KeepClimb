package LockConditionDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程交替执行 实现
 * 线程ABC启动
 * 线程A打印 5次 线程B打印 10次 线程C打印15次
 * 打印10轮
 *
 * 多线程环境中 Lock 可以利用 Condition 精确唤醒线程
 */

class ShareResource{
    private  int number = 1; //A:1 B:2 C:3
    private ReentrantLock lock=new ReentrantLock();
    private Condition condition1=lock.newCondition();
    private Condition condition2=lock.newCondition();
    private Condition condition3=lock.newCondition();

    public void printA(){
        lock.lock();
        try {
            //此处用while 不用if 防止虚假唤醒
           while(number!=1) {
               condition1.await();

           }
            for (int i = 0; i <5 ; i++) {
                System.out.print(Thread.currentThread().getName());
               }
               System.out.println();
               number=2;
               condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while(number!=2){
                condition2.await();
            }
                for (int i = 0; i <10 ; i++) {
                    System.out.print(Thread.currentThread().getName());
                }
                System.out.println();
                number=3;
                condition3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while(number!=3) {
                condition3.await();
            }
                for (int i = 0; i <15 ; i++) {
                    System.out.print(Thread.currentThread().getName());
                }
                System.out.println();
                number=1;
                condition1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class LockConditiomDemo {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();

        new Thread(()->{
            try {
                for (int i = 1; i < 10; i++) {
                    shareResource.printA();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                for (int i = 1; i < 10; i++) {
                    shareResource.printB();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                for (int i = 1; i < 10; i++) {
                    shareResource.printC();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();
    }



}

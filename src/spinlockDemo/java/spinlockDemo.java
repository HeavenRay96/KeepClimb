package spinlockDemo.java;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

//手写一个自旋锁
public class spinlockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<Thread>();

    public void myLock() {
        Thread thread = Thread.currentThread();
        while (!atomicReference.compareAndSet(null, thread)) {
            //System.out.println(Thread.currentThread().getName()+" is waiting to get the lock...");
        }
        System.out.println(Thread.currentThread().getName() + " I got the lock");
    }

    public void myUnLock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(Thread.currentThread().getName() + " I have unlocked...");

    }

    public static void main(String[] args) {
        spinlockDemo spinlockDemo = new spinlockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                spinlockDemo.myLock();
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinlockDemo.myUnLock();
            }
        }, "Thread A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                spinlockDemo.myLock();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                spinlockDemo.myUnLock();
            }
        }, "Thread B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                spinlockDemo.myLock();
                spinlockDemo.myUnLock();
            }
        }, "Thread C").start();
    }

}
	



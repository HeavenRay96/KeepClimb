package CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class demo {
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(2) {
            @Override
            public void await() throws InterruptedException {
                super.await();
            }
        };

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        }, "thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //do something
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " is done");
                countDownLatch.countDown();
            }
        }, "thread2");


        thread1.start();
        thread2.start();
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " count down is ok");


    }

}

	


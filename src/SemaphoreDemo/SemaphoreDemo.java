package SemaphoreDemo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

    public class SemaphoreDemo {
        public static void main(String[] args) {
            //模拟3个停车位
            Semaphore semaphore = new Semaphore(10);
            //模拟6部汽车
            for (int i = 1; i <= 1000; i++) {
                new Thread(() -> {
                    try {
                        //抢到资源
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "\t抢到车位");
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "\t 停1秒后离开车位");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //释放资源
                        semaphore.release();
                    }
                }, String.valueOf(i)).start();
            }
        }
    }



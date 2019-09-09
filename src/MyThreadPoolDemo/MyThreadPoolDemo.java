package MyThreadPoolDemo;

import java.util.concurrent.*;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                //Ĭ���׳��쳣
                //new ThreadPoolExecutor.AbortPolicy()
                //���˵�����
                //new ThreadPoolExecutor.CallerRunsPolicy()
                //�������Ĳ�����
                //new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );
        //ģ��10���û�������ҵ�� û���û����������ⲿ�������߳�.

        try {
            for (int i = 1; i <= 8; i++){
                final int tempInt=i;
                threadPool.execute(() -> {
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t ����ҵ��" +tempInt);
                });}
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        //threadPoolInit();
    }

    private static void threadPoolInit() {
        /**
         * һ��5�������߳�
         */
        //ExecutorService threadPool= Executors.newFixedThreadPool(5);
        /**
         * һ��һ�߳�
         */
        //ExecutorService threadPool= Executors.newSingleThreadExecutor();
        /**
         * һ��N�߳�
         */
        ExecutorService threadPool = Executors.newCachedThreadPool();
        //ģ��10���û�������ҵ�� û���û����������ⲿ�������߳�.
        try {
            for (int i = 1; i <= 20; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t ����ҵ��");
                });
                try {
                    TimeUnit.MICROSECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}

package SemaphoreDemo;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

    public class SemaphoreDemo {
        public static void main(String[] args) {
            //ģ��3��ͣ��λ
            Semaphore semaphore = new Semaphore(3);
            //ģ��6������
            for (int i = 1; i <= 6; i++) {
                new Thread(() -> {
                    try {
                        //������Դ
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "\t������λ");
                        try {
                            TimeUnit.SECONDS.sleep(15);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName() + "\t ͣ3����뿪��λ");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        //�ͷ���Դ
                        semaphore.release();
                    }
                }, String.valueOf(i)).start();
            }
        }
    }



package VolatileDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {

    public static void main(String[] args) {
        atomic();

    }

    // volatile����֤ԭ����
    /*
     * ��ν����
     * 1.��addplus������ sync
     * 2.ʹ��JUC�µ�AtomicInteger
     *
     */
    public static void atomic() {
        mydate md = new mydate();
        // ����20���߳�
        for (int i = 1; i <= 20; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    // ÿ���̵߳���number++ 1000��
                    for (int j = 1; j <= 1000; j++) {
                        md.addpuls();
                        md.addatomic();

                    }
                }
            }).start();

        }
        while (Thread.activeCount() > 2) {

            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + " Int number :" + md.number);
        System.out.println(Thread.currentThread().getName() + " Atomic number :" + md.atomicInteger);
    }

    // volatile��֤�ɼ���
    public static void visibleDemo() {
        mydate md = new mydate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " come in. wait 2 seconds");

                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }

                md.addTo60();
                System.out.println(Thread.currentThread().getName() + " change number to:" + md.number);
            }
        }).start();

        while (md.number == 0) {
            // System.out.println("xxx");
        }
        System.out.println("main thread get the number is:" + md.number);
    }

}

class mydate {
    volatile int number = 0;// ����volatile�ؼ��� 28�� whileѭ����һֱѭ�� ��Ϊû�еõ��߳��޸ĵ�number���µ�ֵ
    AtomicInteger atomicInteger = new AtomicInteger();

    public void addTo60() {
        this.number = 60;
    }

    public void addpuls() {
        number++;

    }

    public void addatomic() {
        atomicInteger.getAndIncrement();


    }

}
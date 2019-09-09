package CyclicBarrierDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,new TourGuideTask());

        for (int i = 1; i <=7; i++) {
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"���Ｏ�ϵ�");
                try {
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+"��ʼ����");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"�߳�"+String.valueOf(i)).start();
        }
    }
}
 class TourGuideTask implements Runnable{

    @Override
    public void run() {
        System.out.println("****���ηַ�����ǩ֤****");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

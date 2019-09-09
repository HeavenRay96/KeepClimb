package DeadLockDemo;

import java.util.concurrent.TimeUnit;

class HoldThread implements Runnable {

    private String lockA;
    private String lockB;

    public HoldThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "\t �Լ�������" + lockA + "���Ի��" + lockB);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "\t �Լ�������" + lockB + "���Ի��" + lockA);
            }
        }
    }
}

/**
 * Description:
 * ������ָ�����������ϵĽ�����ִ�й�����,
 * ��������Դ����ɵ�һ���໥�ȴ�������,
 * �����������������Ƕ����޷��ƽ���ȥ
 *
 * ���ն���ʹ�� jps ���� �鿴java���̺�
 * ��ʹ�� jstack+���̺� ����
 *
 **/
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldThread(lockA, lockB), "threadAAA").start();
        new Thread(new HoldThread(lockB, lockA), "threadBBB").start();
    }
}

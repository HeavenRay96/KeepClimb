package Singleton;

/**
 * 懒汉式：
 *
 * 延迟创建这个实例对象
 *
 * (1)构造器私有化
 * (2)用一个静态变量保存这个唯一的实例
 * (3)提供一个静态方法，获取这个实例对象
 */
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
    	//避免后来线程 再已经有实例的情况下 再次进入同步块 减少加锁解锁消耗
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

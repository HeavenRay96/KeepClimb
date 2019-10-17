package Singleton;

/**
 * 懒汉式：
 *
 * 延迟创建这个实例对象
 *
 * (1)构造器私有化
 * (2)用一个私有静态变量保存这个唯一的实例
 * (3)提供一个静态方法，获取这个实例对象
 */
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        //实例为null才进入同步代码块，否则直接返回实例
        if (instance == null) {
            synchronized (Singleton5.class) {
                //如果已经有线程new出实例 防止等待锁的线程重新new出实例
                if (instance == null) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}

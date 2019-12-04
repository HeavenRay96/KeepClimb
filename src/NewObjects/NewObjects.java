package NewObjects;

import java.lang.reflect.Constructor;

public class NewObjects  implements Cloneable  {
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader= NewObjects.class.getClassLoader();
        Object o=classLoader.loadClass("NewObjects.NewObjects").newInstance();
        System.out.println(o.toString());

        // 获取类对象的三种方式
        // 1.Class.forName(类路径)
        Class class1 = Class.forName("NewObjects.NewObjects");
        // 2.类名.class
        Class class2= NewObjects.class;
        NewObjects object=new NewObjects();
        // 3.对象.getClass()
        Class class3=object.getClass();

        // 创建对象的四种方式
        // 1.调用类对象的newInstance方法
        Object object1=class1.newInstance();
        Object object2=class2.newInstance();
        Object object3=class3.newInstance();
        // 2.使用Constructor类的newInstance方法
        Constructor constructor = class1.getConstructor();
        Object object4=constructor.newInstance();
        // 3.对象克隆
        NewObjects newObjects=new NewObjects();
        Object object5=newObjects.clone();
        // 4.采用序列化机制。。。

        System.out.println(object1.toString());
        System.out.println(object2.toString());
        System.out.println(object3.toString());
        System.out.println(object4.toString());
        System.out.println(object5.toString());
    }
}

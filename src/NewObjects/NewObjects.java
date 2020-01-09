package NewObjects;

import org.apache.commons.lang3.StringEscapeUtils;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
        List<Dog> dogs=new ArrayList<Dog>();
        dogs.add(new Dog("lucky","red",99));
        dogs.add(new Dog("lucky","red",44));
        dogs.add(new Dog("lucky","red",33));
        dogs.add(new Dog("lucky","red",199));
        System.out.println(dogs.toString());
        dogs.sort(Comparator.comparing(Dog::getWeight).reversed());
        System.out.println(dogs.toString());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(simpleDateFormat.format(new Date()));
        BigDecimal bigDecimal=new BigDecimal("0");
        BigDecimal re=new BigDecimal("0");
        BigDecimal di=new BigDecimal("1000");
        re=bigDecimal.divide(di, 0, RoundingMode.HALF_DOWN);
        System.out.println(String.valueOf(re));
        String s="&amp;";
         String s1= URLDecoder.decode(s,"utf-8");
        String s2= StringEscapeUtils.unescapeHtml4(s);
        System.out.println(s2);

    }
}

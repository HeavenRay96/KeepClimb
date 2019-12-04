import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.*;

public class Main implements Cloneable {
    private  int anInt =13213;
   private String name;

    public Main(String name) {
        this.name = name;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, CloneNotSupportedException {

//        Scanner in = new Scanner(System.in);
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        int n = in.nextInt();
//        int m = in.nextInt();
//        while (in.hasNextInt()) {
//            arrayList.add(in.nextInt());
//        }
        System.out.println(findodd().toString());
        StringBuilder stringBuilder=new StringBuilder();
        //ArrayList<Integer> arrayList=new ArrayList<>();
         Object [] nums=new Object[5];
        nums[0]=0;
        nums[1]=1;
        nums[2]=2;
        nums[3]=3;
        System.out.println(nums.length);
        int index=3;
        System.arraycopy(nums, index, nums, index + 1,
                4 - index);
        for (Object o:nums
             ) {
            System.out.println(o.toString());
        }
        String str="1000";
        //其他进制转10进制
        System.out.println(Integer.parseInt(str, 7));
        System.out.println(to10(7, 1000));
        //10进制转其他进制
        System.out.println(toAll(7, 343));
        System.out.println("xx"+str.charAt(3));
        HashMap<Integer,String> hashMap=new HashMap();
        hashMap.put(1, "one");
        hashMap.put(2, "two");
        hashMap.put(3, "xxxx");
        hashMap.put(4, "lll");
        Set<Integer> integers = hashMap.keySet();
        Collection<String> values = hashMap.values();
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        System.out.println(integers.toString());
        System.out.println(values.toString());
        System.out.println(entries.toString());
        new Thread(()->{
            System.out.println("xx");
        }).start();
        Runnable runnable=()-> System.out.println();
        new Thread().start();
        int a=toAll(2, 16);
        System.out.println(a);
        char[] chars=String.valueOf(a).toCharArray();
        char c = String.valueOf(a).charAt(0);
        for (char i:chars
             ) {
            System.out.println(i);
        }
        System.out.println(c);

        System.out.println(Integer.parseInt("1000", 2));
        Object object=new Object();
        Main mainxx=new Main("xxx");

        System.out.println(mainxx.name);

    }


    private  void function(){

    }
    protected   void function1(){

    }

      //找出200-300的质数
    public static ArrayList findodd() {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for(int i=200 ;i<=300;i++){
            for(int y=2;y<i;y++){
                if(i%y==0){
                    break;
                }
                if(y==i-1){
                    arrayList.add(i);
                }

            }
        }
            return  arrayList;
    }
    //其他进制转10进制
    public static Integer to10(int n,int num){
        int i=0;
        int snum=0;
        while(num>0){
            int temp=num%10;
            num=num/10;
            snum= (int) (snum+temp*Math.pow(n, i));
            i++;

        }
        return  snum;
    }
    //10进制转其他进制
    public static Integer toAll(int n,int num){

        StringBuffer sb = new StringBuffer();
        StringBuilder stringBuilder=new StringBuilder();
        while(num>0){
            sb.append(num%n);
            num=num/n;

        }
        //将StringBuffer反转再转为Integer类型
        int a=Integer.parseInt(sb.reverse().toString());
        return  a;

    }
    //静态内部类
    public  static  class  xx{

    }

}



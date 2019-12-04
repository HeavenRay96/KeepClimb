package FatherSon;

import java.util.LinkedHashMap;
import java.util.Map;
//调用顺序
//父类的静态代码（按出现的顺序执行）
//子类的静态代码（按出现的顺序执行）
//父类的非静态代码
//子类的非静态代码
//父类的构造函数 子类的构造函数
public class Son  extends Father{
	private int i= test();
	private int g=2;
	 //private static int j=method();
	 static {
		 System.out.println("子类的静态代码块");
		 
	 }
	 Son(){
		 System.out.println("子类的构造函数");
	 }
	 
	 {
		 System.out.println("子类的非静态代码块");
	 }
	 
	 
	 public int  test() {
		System.out.println("子类的非静态代码");
		return 1;
	}
	 

	 public static void main(String[] args) {
		Son s1=new Son();
		System.out.println();
		 System.out.println(s1.method());
		 //Son s2=new Son();
	}
	 
}


 


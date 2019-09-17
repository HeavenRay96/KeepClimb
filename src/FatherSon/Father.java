package FatherSon;

public class Father {
 private int i= test();
 private static int j=method();
 
 static {
	 System.out.println("父类的静态代码块");
	 
 }
 Father(){
	 System.out.println("父类的构造函数");
 }
 
 {
	 System.out.println("父类的非静态代码块");
 }
 
 //非静态方法前面有一个默认的 对象this
 public int  test() {
	System.out.println("父类的非静态代码块");
	return 1;
}
 
 public static int method() {
	System.out.println("父类的静态代码");
	return 1;
}
}

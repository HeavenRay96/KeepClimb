package FatherSon;

public class Father {
 private int i= test();
 private static int j=method();
 
 static {
	 System.out.println("����ľ�̬�����");
	 
 }
 Father(){
	 System.out.println("����Ĺ��캯��");
 }
 
 {
	 System.out.println("����ķǾ�̬�����");
 }
 
 //�Ǿ�̬����ǰ����һ��Ĭ�ϵ� ����this
 public int  test() {
	System.out.println("����ķǾ�̬�����");
	return 1;
}
 
 public static int method() {
	System.out.println("����ľ�̬����");
	return 1;
}
}

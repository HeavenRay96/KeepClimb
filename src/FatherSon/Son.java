package FatherSon;

import java.util.LinkedHashMap;
import java.util.Map;
//����˳��
//����ľ�̬���루�����ֵ�˳��ִ�У�
//����ľ�̬���루�����ֵ�˳��ִ�У�
//����ķǾ�̬����
//����ķǾ�̬����
//����Ĺ��캯�� ����Ĺ��캯��
public class Son  extends Father{
	private int i= test();
	 private static int j=method();
	 static {
		 System.out.println("����ľ�̬�����");
		 
	 }
	 Son(){
		 System.out.println("����Ĺ��캯��");
	 }
	 
	 {
		 System.out.println("����ķǾ�̬�����");
	 }
	 
	 
	 public int  test() {
		System.out.println("����ķǾ�̬����");
		return 1;
	}
	 
	 public static int method() {
		System.out.println("����ľ�̬����");
		return 1;
	}
	 public static void main(String[] args) {
		Son s1=new Son();
		System.out.println();
		//Son s2=new Son();
	}
	 
}


 


package LinkedHashMapDemo;

import java.util.LinkedHashMap;
import java.util.Map;
public class LinkedHashMapDemo {

	   private static final int MAX_ENTRIES = 9;

	   public static void main(String[] args) {
	      LinkedHashMap<Object, Object> lhm = new LinkedHashMap<Object, Object>(MAX_ENTRIES , .75F, true) {

	         protected boolean removeEldestEntry(Map.Entry eldest) {
	        	 //移除条件
	            return size() > MAX_ENTRIES;
	         }
	      };
	      for (int i = 0; i < args.length; i++) {
	    	  lhm.put(0, i);
		}
	      lhm.put(0, 0);
	      lhm.put(1, 1);
	      lhm.put(2, 2);
	      lhm.put(3, 3);
	      lhm.put(4, 4);
	      lhm.put(5, 5);
	      lhm.put(6, 6);
	      lhm.put(7, 7);
	      lhm.put(8, 8);
	      lhm.get(1);//访问会将元素放到链表尾部
	      lhm.put(9, 9);
	     

	      System.out.println("" + lhm);

	   }
	}

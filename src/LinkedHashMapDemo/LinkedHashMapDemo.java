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
	      
	      lhm.put(0, "H");
	      lhm.put(1, "E");
	      lhm.put(2, "L");
	      lhm.put(3, "L");
	      lhm.put(4, "O");
	      lhm.put(5, "!");
	      lhm.put(6, "H");
	      lhm.put(7, "E");
	      lhm.put(8, "L");
	      lhm.get(1);
	      lhm.put(9, "L");
	      lhm.put(10, "O");
	      lhm.put(11, "!");

	      System.out.println("" + lhm);

	   }
	}

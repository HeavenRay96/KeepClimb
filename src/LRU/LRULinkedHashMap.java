package LRU;

import java.util.LinkedHashMap;
import java.util.Map;
public class LRULinkedHashMap {
       
	   private static final int MAX_ENTRIES = 9;

	   public static void main(String[] args) {
	      LinkedHashMap<Object, Object> lhm = new LinkedHashMap<Object, Object>(MAX_ENTRIES , .75F, true) {

	         protected boolean removeEldestEntry(Map.Entry eldest) {
	        	 //移除条件
	            return size() > MAX_ENTRIES;
	         }
	      };
	    
	      lhm.put(0, 0); 
	      lhm.put(1, 1);
	      lhm.put(2, 2);
	      lhm.put(3, 3);
	      lhm.put(4, 4);
	      lhm.put(5, 5);
	      lhm.put(6, 6);
	      lhm.put(7, 7);
	      lhm.put(8, 8);//0 1 2 3 4 5 6 7 8
	      
	      //访问会将元素放到链表尾部
	       lhm.get(1); // 0 2 3 4 5 6 7 8 1
	       
	      //满足移除最老元素条件  size() > MAX_ENTRIES
	      lhm.put(9, 9);// 2 3 4 5 6 7 8 1 9
	     
	      System.out.println("" + lhm);

	   }
	}

package ExamCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
//58笔试 大鱼吃小鱼
//值最小的被值第二小的吃掉
//fish2=fish1+fish2
//返回池塘鱼的最小值
public class FishEating {
    public static void main(String[] args) {
        sloution();
    }
    private static void sloution() {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrayList=new ArrayList<>();
        int n=in.nextInt();
        int m=in.nextInt();//吃几轮
        while (in.hasNextInt()) {
              arrayList.add(in.nextInt());
                }
        Comparator<Integer> comparator=  new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };
        for(int i=0;i<m;i++){
            Collections.sort(arrayList,comparator );
            int x=1;
            while (arrayList.get(0)== arrayList.get(x+1)){
                x++;
            }
            int num=arrayList.get(0)+arrayList.get(x);
            arrayList.set(x,num);
            arrayList.remove(0);
        }
        Collections.sort(arrayList,comparator );
        System.out.println(arrayList.get(0));
    }


}



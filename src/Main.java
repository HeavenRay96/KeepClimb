import java.util.*;

public class Main {
    public static void main(String[] args) {

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
        int index=3;
        System.arraycopy(nums, index, nums, index + 1,
                4 - index);
        for (Object o:nums
             ) {
            System.out.println(o.toString());
        }



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
}

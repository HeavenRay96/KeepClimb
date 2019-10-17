package QuickSort;

import javax.xml.bind.SchemaOutputResolver;

public class QucikSort {

    public static void main(String[] args) {
        QucikSort qucikSort=new QucikSort();
        int r []={1,99,4,2,9,45,6,24,13};
        qucikSort.sort(r, 0, r.length-1);
        for (int x:r
             ) {
            System.out.println(x);
        }
    }
    //一次划分
    public int partition(int r[], int first,int end ){
        int i=first;
        int j=end;
        while(i<j){
            while(i<j&&r[i]<=r[j])//右侧扫描 右侧比基准数大 j前移
            {
                j--;
            }
            //如果右侧有数比基准数小 交换 i后移一位
            if(i<j)
            {
                swap(r,i,j);
                i++;
            }
            while(i<j&&r[i]<=r[j])//左侧扫描
            {
              i++;
            }
            if(i<j)//如果左侧有数比基准数大 交换 j前移一位
            {
                swap(r,i,j);
                j--;
            }
    }
          return i;//返回基准数的下标位置
    }

    public void sort(int r[],int first,int end){
        if(first<end)//区间长度大于1，执行一次划分，否则递归结束
        {
            int partition = partition(r, first, end);
            sort(r,  first, partition-1);
            sort(r,partition+1,end);
        }
    }

    public  static void swap(int[] r,int a,int b){
        int temp=r[a];
        r[a]=r[b];
        r[b]=temp;
    }
}

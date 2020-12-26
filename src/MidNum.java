import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class MidNum {
    public static void main() {
        Double array []={1.0,2.0,3.0,4.0};
        int heapSize= array.length/2+1;
        //构建size为n/2+1 的最小堆
        //PriorityQueue默认为最小堆
        PriorityQueue<Double> queue=new PriorityQueue<>(heapSize);
        //填充最小堆
        for(int i=0;i<heapSize;i++){
            queue.add(array[i]);
        }
        //如果后续元素比最小堆顶元素大，则加入并重建堆，直到遍历完成
        for(int j=heapSize;j< array.length;j++){
            if(array[j]>queue.peek()){
                queue.remove();
                queue.add(array[j]);
            }
        }
        //如果数组大小为奇数则堆顶元素为中位数
        //如果数组大小为偶数则取出堆顶元素后，重建堆后再取出堆顶元素相加/2则为中位数
        if(array.length%2==1){
            System.out.println(queue.poll());
        }else {
            System.out.println((queue.poll()+queue.poll())/2);
        }

        //最大堆的创建方法  重写PriorityQueue的compare方法
        PriorityQueue queue1=new PriorityQueue(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

    }
}

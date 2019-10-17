package ProductConsume;

import java.util.concurrent.*;

public class PrudCons {
    public static void main(String[] args) {
        BlockingDeque<Integer> blockingDeque=new LinkedBlockingDeque(15);
        Thread prod=new Thread(new Product(blockingDeque), "生产线程1");
        Thread cons1=new Thread(new Consume(blockingDeque), "消费线程1");
        Thread cons2=new Thread(new Consume(blockingDeque), "消费线程2");
        prod.start();
        cons1.start();
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        //自定义线程池
        ExecutorService threadpool=new ThreadPoolExecutor( 2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        //execute 没有返回值
            threadpool.execute(new Product(blockingDeque));
            //submit 有返回值
        Future submit = threadpool.submit(new Product(blockingDeque));
        //cons2.start();
    }

}

class Product implements  Runnable{
    BlockingDeque<Integer> blockingDeque;
    public Product(BlockingDeque<Integer> blockingDeque) {
        this.blockingDeque=blockingDeque;

    }

    @Override
    public void run() {
        for(int i=0;i<15;i++){
           // System.out.println(Thread.currentThread().getName()+"生产数据:"+i);
            //offer 插入成功返回 true 失败返回 false
            if(blockingDeque.offer(i))
            System.out.println(Thread.currentThread().getName()+"生产数据:"+i);


        }
    }
}
class Consume implements  Runnable{
    BlockingDeque<Integer> blockingDeque;
    public Consume(BlockingDeque<Integer> blockingDeque) {
        this.blockingDeque=blockingDeque;

    }
    @Override
    public void run() {
        for(int i=0;i<15;i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                //take 没有数据时会阻塞
              int num=  blockingDeque.take();
                System.out.println(Thread.currentThread().getName()+"消费数据:"+num);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}

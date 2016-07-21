package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by hupo.wh on 2016/7/3.
 */
public class TestSingleThreadExecutor {

    public static void main(String[] args) {

        //创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newCachedThreadPool();

        //创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new WhThread();
        Thread t2 = new WhThread();
        Thread t3 = new WhThread();
        Thread t4 = new WhThread();
        Thread t5 = new WhThread();

        //将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);

        pool.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("fuck");
            }
        });

        //关闭线程池
        pool.shutdown();

//        ExecutorService pool = Executors. newSingleThreadExecutor();
//        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(100);
//
//        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常
//            @Override
//            public void run() {
//
//                System.out.println("================");
//                throw new RuntimeException();
//            }
//        }, 1000, 5000, TimeUnit.MILLISECONDS);
//
//        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的
//            @Override
//            public void run() {
//                System.out.println(System.nanoTime());
//            }
//        }, 1000, 2000, TimeUnit.MILLISECONDS);
    }

}

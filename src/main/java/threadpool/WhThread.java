package threadpool;

/**
 * Created by hupo.wh on 2016/7/2.
 */
public class WhThread extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行...");
    }
}

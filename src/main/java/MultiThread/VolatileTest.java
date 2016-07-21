package MultiThread;

/**
 * Created by hupo.wh on 2016/7/8.
 */
public class VolatileTest {

    private static final int THREAD_NUM =20;

    public static volatile int race= 0;

    public static void increase(){
        race++ ;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[THREAD_NUM];

        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<10000;i++){
                        //System.out.println("race == "+race);
                        increase();
                    }
                }
            });
            threads[i].start();
        }

//        while(Thread.activeCount()>2){
//            Thread.yield();
//        }

        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i].join();
        }

        System.out.println(race);
    }
}

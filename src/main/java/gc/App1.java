package gc;

/**
 * Created by hupo.wh on 2016/7/14.
 */
public class App1 {

    public static void main(String args[]) throws Throwable {

        FinalizeTest t = new FinalizeTest();

        if (t == null)
            System.out.println("没这个对象了");
        else
            System.out.println("对象还在");

        //////
        //t.finalize();
        t = null;
        System.gc();
        //Thread.sleep(500);
        /////

        if (t == null)
            System.out.println("没这个对象了");
        else
            System.out.println("对象还在");
    }
}

class FinalizeTest {

    @Override
    protected void finalize() throws Throwable {

        System.out.println("finalize()");
        super.finalize();
    }
}

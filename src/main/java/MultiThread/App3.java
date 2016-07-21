package MultiThread;

/**
 * Created by hupo.wh on 2016/7/5.
 */
class Foo extends Thread
{
    private int val;
    public Foo(int v)
    {
        val = v;
    }

    public synchronized void printVal(int v)
    {
        while(true)
            System.out.println(v);
    }

    public void run()
    {
        printVal(val);
    }
}

public class App3
{
    public static void main(String args[])
    {
        Foo f1 = new Foo(1);
        f1.start();

        Foo f2 = new Foo(3);
        f2.start();
    }
}

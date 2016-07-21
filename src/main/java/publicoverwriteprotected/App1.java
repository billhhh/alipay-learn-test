package publicoverwriteprotected;

/**
 * Created by hupo.wh on 2016/7/18.
 */
public class App1 {

    public static void main(String args[]) {

        new SubClass().sayHello("wangu");
    }
}

class SuperClass{

    private void sayHello(String name) {
        System.out.println("hello "+name);
    }
}

class SubClass extends SuperClass{

    public void sayHello(String name) {
        System.out.println("hello "+name);
    }

}
package classloader;

/**
 * Created by hupo.wh on 2016/7/6.
 */
public class App1 {

    public static void main(String[] args) throws Exception {

        WhClassLoader whloader = new WhClassLoader("WanghuClassLoader");
        Class<?> clazz = whloader.whLoadClass("classloader.WhHelloWorld");
        Object object = clazz.newInstance();
        WhHelloWorld h = (WhHelloWorld)object;
        h.sayHello();
    }
}

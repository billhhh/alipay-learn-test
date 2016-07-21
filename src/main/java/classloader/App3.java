package classloader;

import java.lang.reflect.Method;

/**
 * Created by hupo.wh on 2016/7/7.
 */
public class App3 {

    private final static int size = 12;

    public static void main(String args[]) throws ClassNotFoundException {

        //System.out.println(size);

        Class clazz = Class.forName("classloader.Child");
        Method[] methods = clazz.getMethods();

        for (int i=0;i<methods.length;++i) {
            System.out.println(methods[i]);
        }
    }
}

interface Test{

    int te = 0;
    public void te();
}

abstract class Parent {

    int pa;

    public void pa() {
        System.out.println("this is parent");
    }
}

class Child extends Parent implements Test{

    int ch;

    public void ch() {
        System.out.println("this is child");
    }

    @Override
    public void te() {

    }
}
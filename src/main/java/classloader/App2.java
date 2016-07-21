package classloader;

/**
 * Created by hupo.wh on 2016/7/7.
 */
public class App2 {
}
/**
 * 被动引用情景1
 * 通过子类引用父类的静态字段，不会导致子类的初始化
 * @author volador
 *
 */
class SuperClass{

    static{
        System.out.println("super class init.");
    }
    public static int value=123;
}

class SubClass extends SuperClass{

    static{
        i =10;
        System.out.println("sub class init.");
        //System.out.println("i == "+i);
    }

    static  int i;

}

class ConstClass {

    static{
        System.out.println("ConstClass init.");
    }

    public static final String HELLOWORLDA = "hello bill";
}

class test{
    public static void main(String[]args){

        System.out.println(SubClass.i);

//        SuperClass[] sca = new SuperClass[10];
//        sca[1] = null;

//        System.out.println(SubClass.HELLOWORLDA);

    }

}
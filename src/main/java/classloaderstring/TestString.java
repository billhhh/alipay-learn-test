package classloaderstring;

import java.lang.*;
import java.lang.reflect.Method;

/**
 * Created by hupo.wh on 2016/7/7.
 */
public class TestString {

    public static void main(java.lang.String args[]) throws Exception {

        java.lang.String classDataRootPath = "D:\\xiaohua\\WhTest\\out\\production\\WhTest\\classloader\\Sample";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);

        Class<?> class1 = fscl1.loadClass("classloaderstring.String");
        Class<?> class2 = Class.forName("classloaderstring.String");
        Object obj1 = class1.newInstance();

        System.out.println(java.lang.String.class.getClassLoader());
        System.out.println(class1.getClassLoader());

        System.out.println(java.lang.String.class);
        System.out.println(class1);
        System.out.println(class2);

        Method setSampleMethod = class1.getMethod("toString");
        System.out.println(setSampleMethod.invoke(obj1));

    }
}

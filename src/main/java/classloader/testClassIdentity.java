package classloader;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 * Created by hupo.wh on 2016/7/7.
 */
public class testClassIdentity {

    public testClassIdentity() {
        System.out.println("构造成功");
    }

    public void testClassIdentity() throws MalformedURLException {

        System.out.println("进入方法");

//        File file = new File("D:\\xiaohua\\WhTest\\out\\production\\WhTest\\classloader\\Sample.class");
//        URL url = file.toURI().toURL();
//
//        ClassLoader fscl1 = new URLClassLoader(new URL[]{url});
//        ClassLoader fscl2 = new URLClassLoader(new URL[]{url});

        String classDataRootPath = "D:\\xiaohua\\WhTest\\out\\production\\WhTest\\classloader\\Sample";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);

        String className = "classloader.Sample";
        try {
            Class<?> class1 = fscl1.loadClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();

            System.out.println(class1.getClassLoader());
            System.out.println(class2.getClassLoader());

            Method setSampleMethod = class1.getMethod("setSample", Object.class);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() {

        String classDataRootPath = "D:\\xiaohua\\WhTest\\out\\production\\WhTest\\classloader\\Sample";
        FileSystemClassLoader fscl1 = new FileSystemClassLoader(classDataRootPath);
        FileSystemClassLoader fscl2 = new FileSystemClassLoader(classDataRootPath);
        String className = "classloader.Sample";
        try {
            Class<?> class1 = fscl1.loadClass(className);
            Object obj1 = class1.newInstance();
            Class<?> class2 = fscl2.loadClass(className);
            Object obj2 = class2.newInstance();

            System.out.println(class1.getClassLoader());
            System.out.println(class2.getClassLoader());

            Method setSampleMethod = class1.getMethod("setSample", java.lang.Object.class);
            setSampleMethod.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws MalformedURLException {

        new testClassIdentity().test();
    }
}

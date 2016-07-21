package classloader;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by hupo.wh on 2016/7/20.
 */
public class ClassLoaderTest2 {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) {

                try {

                    String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }

                    byte [] b = new byte[is.available()];

                    is.read(b);

                    return defineClass(name,b,0,b.length);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };


        Class<?> clazz = myLoader.loadClass("helloworld.HelloWorld");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz1 = myLoader.loadClass("org.omg.CORBA.Any");
        System.out.println(clazz1.getClassLoader());
    }
}

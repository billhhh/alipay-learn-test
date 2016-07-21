package classloader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by hupo.wh on 2016/7/20.
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws Exception {

        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) {

                try {

                    InputStream is = null;
                    if(name == "helloworld.HelloWorld") {
                        is = new FileInputStream("D:\\xiaohua\\WhTest\\target\\classes\\helloworld\\HelloWorld.class");
                    }
                    else {

                        is = new FileInputStream("D:\\lang\\Object.class");
                        //return super.loadClass(name);
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
    }
}

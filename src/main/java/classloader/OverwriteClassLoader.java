package classloader;

import java.io.*;

/**
 * Created by hupo.wh on 2016/7/18.
 */
public class OverwriteClassLoader extends ClassLoader {

    private String rootDir = "d:\\";

    public Class<?> loadClass(String name)
            throws ClassNotFoundException {

        synchronized (getClassLoadingLock(name)) {

            // First, check if the class has already been loaded
            Class<?> c = findClass(name);

            return c;
        }
    }

    private byte[] getClassData(String className) {
        //String path = classNameToPath(className);
        String path = "D:\\xiaohua\\WhTest\\target\\classes\\helloworld\\HelloWorld.class";
        try {
            InputStream ins = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {

        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        else {
            System.out.println("name == "+name);
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }

    public OverwriteClassLoader(ClassLoader classLoader) {

        super(classLoader);
    }

    protected final Class<?> whdefineClass(String name, byte[] b, int off, int len)
            throws ClassFormatError
    {
        return defineClass("helloworld.HelloWorld", b, off, len, null);
    }

}


/////Main.java
class Main{

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoader extcl =new Object(){}.getClass().getEnclosingClass().getClassLoader();
        while(extcl.getParent()!=null){

            extcl=extcl.getParent();
        }
        System.out.println("extcl == "+extcl);
        System.out.println("overwriteclassloader == "+OverwriteClassLoader.class.getClassLoader());

        OverwriteClassLoader cl = new OverwriteClassLoader(extcl);
        Class<?> clazz = cl.loadClass("helloworld.HelloWorld");

        System.out.println(clazz.getClassLoader());
    }
}

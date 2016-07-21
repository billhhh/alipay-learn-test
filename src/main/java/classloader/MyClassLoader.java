package classloader;

import java.io.*;

/**
 * Created by hupo.wh on 2016/7/6.
 */
public class MyClassLoader extends ClassLoader {

    private String name;//类加载器的名字

    private String path = "/home/chiwei/mydisk/eclipse_workspace/java/src/";//类加载的路径

    private final String fileType = ".class";

    public MyClassLoader(String name) {
        super();
        this.name = name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private byte[] loadClassData(String name) {
        InputStream in = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            name = name.replace(".", "\\");
            in = new BufferedInputStream(new FileInputStream(new File(path+name+fileType)));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while((ch=in.read())!=-1) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                baos.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    protected Class<?> findClass(String name) {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0,data.length);
    }

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        MyClassLoader loader1 = new MyClassLoader("loader1");
        loader1.setPath("");
        test(loader1);
    }

    public static void test(ClassLoader loader) throws Exception{
        Class<?> clazz = loader.loadClass("classloader.MyString");
        Object object = clazz.newInstance();
        MyString ms = (MyString)object;
        System.out.println(ms.toString());
        System.out.println(object==null);
        System.out.println(object.hashCode());
    }

}

package classloader;

/**
 * Created by hupo.wh on 2016/7/6.
 */
public class WhClassLoader extends ClassLoader {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //构造函数
    public WhClassLoader(String name) {
        super();
        this.name = name;
    }

    //加载类，并返回类
    public Class<?> whLoadClass(String class_name) throws Exception {

        Class<?> clazz = super.loadClass(class_name);
        return clazz;
    }
}

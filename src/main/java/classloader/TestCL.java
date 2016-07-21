package classloader;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by hupo.wh on 2016/7/18.
 */
public class TestCL {

    static class MyCL extends URLClassLoader {
        MyCL(URL[] urls) {
            // NOTE: No parent classloader!
            super(urls, null);
        }

        @Override
        public Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
            System.out.println("custom loading of: " + name);
            return super.loadClass(name, resolve);
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            System.out.println("findClass: " + name);
            System.out.println("NOTE: Only called if this classloader does NOT have a parent");
            return super.findClass(name);
        }
    }

    public static void main(String[] args) throws Exception {
        URL url = new File("./bin").toURI().toURL();
        System.out.println("url to search for classes: " + url);
        MyCL cl = new MyCL(new URL[]{url});
        Thread.currentThread().setContextClassLoader(cl);
        Class loadClass = cl.loadClass("stackoverflow.june2012.classloader.TestRun");
        System.out.println("Loaded TestRun using classloader: " + loadClass.getClassLoader());
        loadClass.getMethod("run", new Class[]{}).invoke(null);
    }
}

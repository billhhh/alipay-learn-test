package classloaderstring;

import java.io.*;
import java.lang.String;

/**
 * Created by hupo.wh on 2016/7/7.
 */
public class FileSystemClassLoader extends ClassLoader {

    private java.lang.String rootDir;

    public FileSystemClassLoader(java.lang.String rootDir) {
        this.rootDir = rootDir;
    }

    protected Class<?> findClass(java.lang.String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(java.lang.String className) {
        java.lang.String path = classNameToPath(className);
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

    private java.lang.String classNameToPath(String className) {
        return rootDir + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
    }
}

package classloader;

/**
 * Created by hupo.wh on 2016/7/7.
 */

public class Sample {
    private Sample instance;

    public void setSample(Object instance) {
        this.instance = (Sample) instance;
        System.out.println("set成功...");
    }
}

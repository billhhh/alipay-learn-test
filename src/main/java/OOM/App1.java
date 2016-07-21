package OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hupo.wh on 2016/7/15.
 */
public class App1 {

    static class OOMClass {
        long[] num = new long[10240];
    }

    public static void main(String[] args) {
        List<OOMClass> list = new ArrayList<>();
        while (true) {
            list.add(new OOMClass());
        }
    }


}

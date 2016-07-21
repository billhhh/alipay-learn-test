package overflow;

import java.util.ArrayList;

/**
 * Created by hupo.wh on 2016/7/7.
 */

public class MyTest {

    public void testHeap(){
        for(;;){
            ArrayList list = new ArrayList (2000);
        }
    }
    int num=1;
    public void testStack(){
        num++;
        this.testStack();
    }

    public static void main(String[] args){

        MyTest t  = new MyTest();
        t.testHeap();
        //t.testStack();
    }
}
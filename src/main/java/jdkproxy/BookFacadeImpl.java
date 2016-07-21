package jdkproxy;

/**
 * Created by hupo.wh on 2016/7/4.
 */
public class BookFacadeImpl implements BookFacade {

    @Override
    public void addBook() {
        System.out.println("增加图书方法...");
    }

    public void sayHello(){
        System.out.println("Hello");
    }

}

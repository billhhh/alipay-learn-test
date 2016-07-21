package jdkproxy;

/**
 * Created by hupo.wh on 2016/7/4.
 */
public class App1 {

    public static void main(String[] args) {

        BookFacadeProxy proxy = new BookFacadeProxy();
        BookFacade bookProxy = (BookFacade) proxy.bind(new BookFacadeImpl());
        bookProxy.addBook();

        bookProxy.sayHello();
    }
}

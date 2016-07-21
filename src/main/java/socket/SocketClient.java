package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by hupo.wh on 2016/7/14.
 */
public class SocketClient {

    public static void main(String args[]) {

        try {

            Socket socket = new Socket("localhost",8888);

            //socket.bind(new InetSocketAddress(8888));
            OutputStream out = socket.getOutputStream();

            out.write("hello".getBytes());
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

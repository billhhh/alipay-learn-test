package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * Created by hupo.wh on 2016/7/16.
 */
public class NioServer {

    public static void main(String args[]) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.socket().bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false); //非阻塞

        //字符序列和字节序列的编码和解码
        Charset charset = Charset.forName("UTF-8");

        ByteBuffer buf = ByteBuffer.allocate(48);
        while(true){
            SocketChannel socketChannel =
                    serverSocketChannel.accept();

            String mesg = "";
            if(socketChannel != null){
                //do something with socketChannel...
                System.out.println("Connection has been built!!!");

                while (socketChannel.read(buf) > 0) {
                    buf.flip();
                    mesg += charset.decode(buf);
                }
                System.out.println(mesg);

            }
        }
    }
}

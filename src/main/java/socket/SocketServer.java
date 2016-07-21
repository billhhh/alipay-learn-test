package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hupo.wh on 2016/7/14.
 */
public class SocketServer {

    public static void main(String args[]) {

        try {
            ServerSocket serverSocket = new ServerSocket();

            serverSocket.bind(new InetSocketAddress(8888));

            boolean isStopped = false;

            while (!isStopped) {

                System.out.println("accept waiting...");

                Socket clientSocket = serverSocket.accept();
                //InputStream in = clientSocket.getInputStream();
                BufferedReader is=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println(is.readLine());

                clientSocket.close();
            }

            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

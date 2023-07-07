package org.clb.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class BIOTest {



    public void rec() throws IOException {
        ServerSocket socket = new ServerSocket(6542);

        while (true) {
            System.out.println("等待连接");
            Socket accept = socket.accept();
//            InputStream inputStream = accept.getInputStream();
            System.out.println("连接成功");
        }

    }
    public void connect() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",9000));
//        OutputStream outputStream = socket.getOutputStream();
    }
}

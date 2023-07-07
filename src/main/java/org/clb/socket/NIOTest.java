package org.clb.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class NIOTest {
    static ArrayList<SocketChannel> list = new ArrayList<>();
    static ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    public void rec() throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        socketChannel.bind(new InetSocketAddress("127.0.0.1",6542));
        socketChannel.configureBlocking(false);

        while (true) {
            for (SocketChannel channel : list) {
                int read = channel.read(byteBuffer);
                if (read>0) {
                    byteBuffer.flip();
                    byte[] bytes = new byte[read];
                    byteBuffer.get(bytes);
                    System.out.println(new String(bytes));
                    byteBuffer.clear();
                }
            }
            System.out.println("等待连接");
            SocketChannel accept = socketChannel.accept();
            if (accept!=null) {
                accept.configureBlocking(false);
                list.add(accept);
                System.out.println("连接成功");
            }
//            InputStream inputStream = accept.getInputStream();
        }

    }
    public void connect() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("127.0.0.1",6542));
        OutputStream outputStream = socket.getOutputStream();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            if ("quit".equalsIgnoreCase(next)) {
                break;
            }
            socket.getOutputStream().write(next.getBytes());
        }
        outputStream.close();
    }
}

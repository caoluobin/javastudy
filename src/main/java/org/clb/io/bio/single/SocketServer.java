package org.clb.io.bio.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(83)) {

            while (true) {
                try (Socket socket = serverSocket.accept();//阻塞等待客户端连接
                     InputStream inputStream = socket.getInputStream();
                     OutputStream outputStream = socket.getOutputStream()) {
                    int port = socket.getPort();
                    byte[] context = new byte[2048];
                    Thread.sleep(1000);
                    int realLen = inputStream.read(context);
                    String msg = new String(context, 0, realLen);
                    System.out.println("服务器收到来自端口" + port + " 的消息：" + msg);
                    outputStream.write("已收到消息".getBytes());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

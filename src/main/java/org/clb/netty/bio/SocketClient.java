package org.clb.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient implements Runnable {


    public static void main(String[] args) {
        new Thread(new SocketClient()).start();
    }
    @Override
    public void run() {
        try(Socket socket = new Socket("127.0.0.1", 83);
            InputStream inputStream =socket.getInputStream();
            OutputStream outputStream =socket.getOutputStream();) {
            outputStream.write("客户端消息".getBytes());
            outputStream.flush();
            int maxLen=2048;
            byte[] context = new byte[maxLen];
            StringBuilder msg = new StringBuilder();
            int realLen;
            while ((realLen=inputStream.read(context,0,maxLen))!=-1) {
                msg.append(new String(context,0,realLen));
            }
            System.out.println("消息");
            System.out.println(msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

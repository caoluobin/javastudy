package org.clb.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient implements Runnable {

    Integer index;

    public SocketClient(Integer index) {
        this.index = index;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new SocketClient(i)).start();
        }
    }
    @Override
    public void run() {
        try(Socket socket = new Socket("127.0.0.1", 83);
            InputStream inputStream =socket.getInputStream();
            OutputStream outputStream =socket.getOutputStream();) {
            outputStream.write(("client="+index+"=info").getBytes());
            outputStream.flush();
            int maxLen=2048;
            byte[] context = new byte[maxLen];
            StringBuilder msg = new StringBuilder();
            int realLen;
            while ((realLen=inputStream.read(context,0,maxLen))!=-1) {
                msg.append(new String(context,0,realLen));
            }
            System.out.println("服务端消息返回："+msg);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

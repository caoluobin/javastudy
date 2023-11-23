package org.clb.netty.bio.single;

import sun.nio.cs.ext.GBK;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(83);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            int port = socket.getPort();
            byte[]  context = new byte[2048];
            int realLen = inputStream.read(context);
            String msg = new String(context,0,realLen);
            System.out.println("�������յ����Զ˿�"+port+" ����Ϣ��"+msg);
            outputStream.write("���յ���Ϣ".getBytes("GBK"));
            outputStream.close();
            inputStream.close();
            socket.close();
        }
    }
}

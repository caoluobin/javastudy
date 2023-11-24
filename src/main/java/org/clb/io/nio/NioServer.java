package org.clb.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioServer {

    public static void main(String[] args) {
        try (Selector selector = Selector.open();
             ServerSocketChannel ssChannel=ServerSocketChannel.open();
             ){
            ssChannel.configureBlocking(false);
            ssChannel.register(selector, SelectionKey.OP_ACCEPT);

            ServerSocket serverSocket = ssChannel.socket();
            serverSocket.bind(new InetSocketAddress("127.0.0.1",83));
            while (true) {
                selector.select();//阻塞等待
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = keys.iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();

                    if (key.isAcceptable()) {

                        ServerSocketChannel ssChannel1 = (ServerSocketChannel) key.channel();

                        // 服务器会为每个新连接创建一个 SocketChannel
                        SocketChannel sChannel = ssChannel1.accept();
                        sChannel.configureBlocking(false);

                        // 这个新连接主要用于从客户端读取数据
                        sChannel.register(selector, SelectionKey.OP_READ);

                    } else if (key.isReadable()) {

                        SocketChannel sChannel = (SocketChannel) key.channel();
                        System.out.println("消息"+readDataFromSocketChannel(sChannel));
                        sChannel.close();
                    }

                    keyIterator.remove();
                }

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException {

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();

        while (true) {

            buffer.clear();
            int n = sChannel.read(buffer);
            if (n == 0) {
                break;
            }
            buffer.flip();
            byte[] dst = new byte[buffer.remaining()];
            buffer.get(dst);
            data.append(new String(dst));
            buffer.clear();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return data.toString();
    }
}

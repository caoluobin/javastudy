package org.clb.io.nio;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * SocketChannel ：一个客户端用来发起 TCP 的 Channel 。
 * ServerSocketChannel ：一个服务端用来监听新进来的连接的 TCP 的 Channel 。对于每一个新进来的连接，都会创建一个对应的 SocketChannel 。
 * DatagramChannel ：通过 UDP 读写数据。
 * FileChannel ：从文件中，读写数据。
 */
public class ChannelTest {

    public static void main(String[] args) throws IOException {
        fileChannelTest("C:\\Users\\CP\\Desktop\\account.txt");
    }

    public static void fileChannelTest(String path) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile(path, "rw");
        FileChannel inChannel = aFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        List<Byte> bytes = new ArrayList<>();
        for (int bytesRead = inChannel.read(buf); bytesRead != -1; bytesRead = inChannel.read(buf)) {
            buf.flip();
            while (buf.hasRemaining()) {
                bytes.add(buf.get());
            }

            buf.clear();
        }
        byte[] a= new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            a[i]=bytes.get(i);
        }
        System.out.println(new String(a,"UTF-8"));
        aFile.close();
    }

}

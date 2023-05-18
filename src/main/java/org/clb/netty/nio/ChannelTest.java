package org.clb.netty.nio;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * SocketChannel ��һ���ͻ����������� TCP �� Channel ��
 * ServerSocketChannel ��һ����������������½��������ӵ� TCP �� Channel ������ÿһ���½��������ӣ����ᴴ��һ����Ӧ�� SocketChannel ��
 * DatagramChannel ��ͨ�� UDP ��д���ݡ�
 * FileChannel �����ļ��У���д���ݡ�
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

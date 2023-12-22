package org.clb.util.connect;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.apache.commons.net.telnet.TelnetClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ConnectUtil {



    // SSH连接测试
    public static boolean testSSHConnection(String host, String username, String password, int port) {
        try {
            JSch jsch = new JSch();

            // 创建SSH会话
            Session session = jsch.getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no"); // 忽略主机密钥检查
            session.connect();

            // 关闭会话
            session.disconnect();

            return true;
        } catch (JSchException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Telnet连接测试
    public static boolean testTelnetConnection(String host, int port, String username, String password) {
        TelnetClient telnetClient = new TelnetClient();

        try {
            // 连接Telnet服务器
            telnetClient.connect(host, port);

            // 获取输入输出流
            InputStream inputStream = telnetClient.getInputStream();
            OutputStream outputStream = telnetClient.getOutputStream();

            // 读取服务器的欢迎信息等
            readData(inputStream);

            // 发送用户名
            sendCommand(outputStream, username);

            // 读取服务器对用户名的响应
            readData(inputStream);

            // 发送密码
            sendCommand(outputStream, password);

            // 读取服务器对密码的响应
            readData(inputStream);

            // 关闭Telnet连接
            telnetClient.disconnect();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void readData(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead = inputStream.read(buffer);
        if (bytesRead > 0) {
            System.out.println(new String(buffer, 0, bytesRead));
        }
    }

    private static void sendCommand(OutputStream outputStream, String command) throws IOException {
        outputStream.write((command + "\r\n").getBytes());
        outputStream.flush();
    }

    public static void main(String[] args) {
        // SSH连接测试
        boolean sshConnectionResult = testSSHConnection("your_ssh_host", "your_ssh_username", "your_ssh_password", 22);
        System.out.println("SSH Connection Test Result: " + sshConnectionResult);

        // Telnet连接测试
        boolean telnetConnectionResult = testTelnetConnection("your_telnet_host", 23, "your_ssh_username", "your_ssh_password");
        System.out.println("Telnet Connection Test Result: " + telnetConnectionResult);
    }

}

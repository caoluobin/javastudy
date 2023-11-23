package org.clb.util.encode;



import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class GBKToUTF8 {

    public static void main(String[] args) throws Exception {

        String gbkDirPath = "E:\\JavaProject\\javastudy";//GBK编码格式源码文件路径
        String utf8DirPath = "E:\\JavaProject\\utf\\src";//转为UTF-8编码格式源码文件保存路径

        @SuppressWarnings("unchecked")
        Collection<File> gbkFileList =  FileUtils.listFiles(new File(gbkDirPath), new String[]{"java"}, true);//获取所有java文件
        for (File gbkFile : gbkFileList) {
            if ("UTF-8".equals(detectEncoding(gbkFile))) {
                continue;
            }
            String utf8FilePath = utf8DirPath + gbkFile.getAbsolutePath().substring(gbkDirPath.length());//UTF-8编码格式文件保存路径
            FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(gbkFile, "GBK"));//使用GBK编码格式读取文件，然后用UTF-8编码格式写入数据
        }
    }
    public static String detectEncoding(File file) {
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bom = new byte[4];
            int bytesRead = inputStream.read(bom);
            if (bytesRead >= 3 && bom[0] == (byte)0xEF && bom[1] == (byte)0xBB && bom[2] == (byte)0xBF) {
                return "UTF-8";
            } else if (bytesRead >= 2 && bom[0] == (byte)0xFF && bom[1] == (byte)0xFE) {
                return "UTF-16LE";
            } else if (bytesRead >= 2 && bom[0] == (byte)0xFE && bom[1] == (byte)0xFF) {
                return "UTF-16BE";
            } else if (bytesRead >= 4 && bom[0] == (byte)0x00 && bom[1] == (byte)0x00 && bom[2] == (byte)0xFE && bom[3] == (byte)0xFF) {
                return "UTF-32BE";
            } else if (bytesRead >= 4 && bom[0] == (byte)0xFF && bom[1] == (byte)0xFE && bom[2] == (byte)0x00 && bom[3] == (byte)0x00) {
                return "UTF-32LE";
            } else {
                // 默认返回UTF-8编码格式
                return "UTF-8";
            }
        } catch (IOException e) {
            e.printStackTrace();
            // 返回空字符串表示判断失败
            return "";
        }
    }

}

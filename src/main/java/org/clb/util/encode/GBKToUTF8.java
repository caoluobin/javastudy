package org.clb.util.encode;



import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class GBKToUTF8 {

    public static void main(String[] args) throws Exception {

        String gbkDirPath = "E:\\JavaProject\\javastudy\\src";//GBK缂栫爜鏍煎紡婧愮爜鏂囦欢璺緞
        String utf8DirPath = "E:\\JavaProject\\utf\\src";//杞负UTF-8缂栫爜鏍煎紡婧愮爜鏂囦欢淇濆瓨璺緞

        @SuppressWarnings("unchecked")
        Collection<File> gbkFileList =  FileUtils.listFiles(new File(gbkDirPath), new String[]{"java"}, true);//鑾峰彇鎵�鏈塲ava鏂囦欢
        for (File gbkFile : gbkFileList) {
            if ("UTF-8".equals(detectEncoding(gbkFile))) {
                continue;
            }
            String utf8FilePath = utf8DirPath + gbkFile.getAbsolutePath().substring(gbkDirPath.length());//UTF-8缂栫爜鏍煎紡鏂囦欢淇濆瓨璺緞
            FileUtils.writeLines(new File(utf8FilePath), "UTF-8", FileUtils.readLines(gbkFile, "GBK"));//浣跨敤GBK缂栫爜鏍煎紡璇诲彇鏂囦欢锛岀劧鍚庣敤UTF-8缂栫爜鏍煎紡鍐欏叆鏁版嵁
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
                // 榛樿杩斿洖UTF-8缂栫爜鏍煎紡
                return "GBK";
            }
        } catch (IOException e) {
            e.printStackTrace();
            // 杩斿洖绌哄瓧绗︿覆琛ㄧず鍒ゆ柇澶辫触
            return "";
        }
    }

}

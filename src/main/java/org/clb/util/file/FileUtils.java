package org.clb.util.file;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils {

    public static void main(String[] args) throws IOException {
        test01();
    }
    public void addZip(Map<String, List<String>> map){

    }

    static void test01() throws IOException {
        String compresspath = "D:\\test";
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(compresspath+".zip"));
        File file = new File(compresspath);
        compressZip(zipOutputStream, file, "");
        //必须关闭,否则压缩后的zip包有问题,不能解压
        zipOutputStream.closeEntry();
        zipOutputStream.close();
    }

    private static void compressZip(ZipOutputStream zipOutput, File file, String suffixpath) {
        File[] listFiles = file.listFiles();// 列出所有的文件
        for(File fi : listFiles){
            if(fi.isDirectory()){
                if(suffixpath.equals("")){
                    compressZip(zipOutput, fi, fi.getName());
                }else{
                    compressZip(zipOutput, fi, suffixpath + File.separator + fi.getName());
                }
            }else{
                if ("1.txt".equals(fi.getName())) {
                    suffixpath="1";
                } else {
                    suffixpath="";
                }
                zip(zipOutput, fi, suffixpath);
            }
        }
    }

    public static void zip(ZipOutputStream zipOutput, File file, String suffixpath) {
        try {
            ZipEntry zEntry = null;
            if(suffixpath.equals("")){
                zEntry = new ZipEntry(file.getName());
            }else{
                zEntry = new ZipEntry(suffixpath + File.separator + file.getName());
            }
            //核心代码
            zipOutput.putNextEntry(zEntry);
            //将给定文件写入到压缩包中
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[1024];
            int read = 0;
            while((read = bis.read(buffer)) != -1){
                //会自动压缩流数据
                zipOutput.write(buffer, 0, read);
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void zip(ZipOutputStream zipOutput, byte[] fileBytes, String suffixpath,String fileName) {
        try {
            ZipEntry zEntry = null;
            if(suffixpath.equals("")){
                zEntry = new ZipEntry(fileName);
            }else{
                zEntry = new ZipEntry(suffixpath + File.separator + fileName);
            }
            //核心代码
            zipOutput.putNextEntry(zEntry);
            //将给定文件写入到压缩包中
            InputStream inputStream = new ByteArrayInputStream(fileBytes);
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            byte[] buffer = new byte[1024];
            int read = 0;
            while((read = bis.read(buffer)) != -1){
                //会自动压缩流数据
                zipOutput.write(buffer, 0, read);
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

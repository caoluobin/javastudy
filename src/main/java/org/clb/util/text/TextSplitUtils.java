package org.clb.util.text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TextSplitUtils {
    public static void main(String[] args) {
        //约500m -3000000行
        splitDataToSaveFile(300000,new File("F:\\SRdata\\运维问题处理\\11月\\11.17\\syslog.log"),"F:\\SRdata\\运维问题处理\\11月\\11.17\\2");
    }
    public static List<File> splitDataToSaveFile(int rows, File sourceFile, String targetDirectoryPath) {
        long startTime = System.currentTimeMillis();
        List<File> fileList = new ArrayList<>();
        File targetFile = new File(targetDirectoryPath);
        if (!sourceFile.exists() || rows <= 0 || sourceFile.isDirectory()) {
            return null;
        }
        if (targetFile.exists()) {
            if (!targetFile.isDirectory()) {
                return null;
            }
        } else {
            targetFile.mkdirs();
        }
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile); InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8); BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            StringBuilder stringBuilder = new StringBuilder();
            String lineStr;
            int lineNo = 1, fileNum = 1;
            while ((lineStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(lineStr).append("");
                if (lineNo % rows == 0) {
                    File file = new File(targetDirectoryPath + File.separator + fileNum + sourceFile.getName());
                    writeFile(stringBuilder.toString(), file);     //清空文本
                    stringBuilder.delete(0, stringBuilder.length());
                    fileNum++;
                    fileList.add(file);
                }
                lineNo++;
            }
            if ((lineNo - 1) % rows != 0) {
                File file = new File(targetDirectoryPath + File.separator + fileNum + sourceFile.getName());
                writeFile(stringBuilder.toString(), file);
                fileList.add(file);
            }
            long endTime = System.currentTimeMillis();

        } catch (Exception e) {

        }
        return fileList;
    }

    private static void writeFile(String text, File file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file); OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8); BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter, 1024)) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

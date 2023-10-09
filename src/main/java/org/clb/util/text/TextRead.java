package org.clb.util.text;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextRead {

    public static void main(String[] args) {

        List<String> read = read("E:\\a.txt");
        read.forEach(System.out::println);
    }

    public static List<String> read(String filePath) {
        File file = new File(filePath);
        //��ȡfilePath  txt�ļ�ת����list
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

    public static void write(String filePath, List<String> lines) {
        //д��filePath  txt�ļ�
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine(); // ���з�
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

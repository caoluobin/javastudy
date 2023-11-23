package org.clb.util.backcolor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:  照片换底色
 * @author: clb
 * @date:  14:52
 * @since:
 */
public class BackgroundColorUtil {
    public static void dealPohtoBackColor(String path,int color) throws IOException {
        File dir = new File(path);
        List<File> fileList = Arrays.asList(dir.listFiles());
        for (File file : fileList) {
            BufferedImage bufferedImage = ImageIO.read(file);
            int width = bufferedImage.getWidth();
            int height = bufferedImage.getHeight();
            int minX = bufferedImage.getMinX();
            int minY = bufferedImage.getMinY();
            List<RgbNode> list = new ArrayList<>();
            for (int y = minY + 1; y < height - 1; y++) {
                for (int x = minX + 1; x < width - 1; x++) {
                    int rgb = bufferedImage.getRGB(x, y);
                    int rgbZero = bufferedImage.getRGB(0, 0);
                    int rgbX = bufferedImage.getRGB(x - 1, y);
                    int lastRgbY = bufferedImage.getRGB(x, y - 1);
                    int[] rbg = {(rgb & 0xff0000) >> 16, (rgb & 0xff00) >> 16, rgb & 0xff};
                    int[] rgbZ = {(rgbZero & 0xff0000) >> 16, (rgbZero & 0xff00) >> 16, rgbZero & 0xff};
                    int[] rbgX = {(rgbX & 0xff0000) >> 16, (rgbX & 0xff00) >> 16, rgbX & 0xff};
                    int[] rbgY = {(lastRgbY & 0xff0000) >> 16, (lastRgbY & 0xff00) >> 16, lastRgbY & 0xff};
                    if (Math.abs(rbg[0] - rgbZ[0]) < 20 && Math.abs(rbg[1] - rgbZ[1]) < 20 && Math.abs(rbg[2] - rgbZ[2]) < 20 &&
                            Math.abs(rbg[0] - rbgX[0]) < 20 && Math.abs(rbg[1] - rbgX[1]) < 20 && Math.abs(rbg[2] - rbgX[2]) < 20 &&
                            Math.abs(rbg[0] - rbgY[0]) < 20 && Math.abs(rbg[1] - rbgY[1]) < 20 && Math.abs(rbg[2] - rbgY[2]) < 20) {
                        list.add(new RgbNode(x, y));
//                        bufferedImage.setRGB(x,y,1235456);
                    } else {
                        break;
                    }

                }
            }
            for (int y = height - 2; y >minY +1; y--) {
                for (int x = width - 2; x >minX + 1 ; x--) {
                    int rgb = bufferedImage.getRGB(x, y);
                    int rgbZero = bufferedImage.getRGB(0, 0);
                    int rgbX = bufferedImage.getRGB(x - 1, y);
                    int lastRgbY = bufferedImage.getRGB(x, y - 1);
                    int[] rbg = {(rgb & 0xff0000) >> 16, (rgb & 0xff00) >> 16, rgb & 0xff};
                    int[] rgbZ = {(rgbZero & 0xff0000) >> 16, (rgbZero & 0xff00) >> 16, rgbZero & 0xff};
                    int[] rbgX = {(rgbX & 0xff0000) >> 16, (rgbX & 0xff00) >> 16, rgbX & 0xff};
                    int[] rbgY = {(lastRgbY & 0xff0000) >> 16, (lastRgbY & 0xff00) >> 16, lastRgbY & 0xff};
                    if (Math.abs(rbg[0] - rgbZ[0]) < 20 && Math.abs(rbg[1] - rgbZ[1]) < 20 && Math.abs(rbg[2] - rgbZ[2]) < 20 &&
                            Math.abs(rbg[0] - rbgX[0]) < 20 && Math.abs(rbg[1] - rbgX[1]) < 20 && Math.abs(rbg[2] - rbgX[2]) < 20 &&
                            Math.abs(rbg[0] - rbgY[0]) < 20 && Math.abs(rbg[1] - rbgY[1]) < 20 && Math.abs(rbg[2] - rbgY[2]) < 20) {
                        list.add(new RgbNode(x, y));
//                        bufferedImage.setRGB(x,y,1235456);
                    } else {
                        break;
                    }
                }
            }
            for (RgbNode rgbNode : list) {
                bufferedImage.setRGB(rgbNode.x, rgbNode.y, 245457677);
            }
            String fileName = file.getName().split("\\.")[0];
            FileOutputStream ops = new FileOutputStream(path + "//" + fileName + "_new.jpg");
            ImageIO.write(bufferedImage, "jpg", ops);
            ops.flush();
            ops.close();
        }
    }

    public static void main(String[] args) {
        try {
            dealPohtoBackColor("C:\\Users\\52554\\Pictures\\IQIYISnapShot",2342);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

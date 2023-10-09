package org.clb.LeetCode.codeUtil;

import java.util.Random;

public class StructureUtil {

    public static int[] getIntArray() {
        Random random = new Random();
        int length = random.nextInt(10) + 1;
        int[] r =new int[length];
        for (int i = 0; i < r.length; i++) {
            r[i] = random.nextInt(10)+1;
        }
        return r;
    }
}

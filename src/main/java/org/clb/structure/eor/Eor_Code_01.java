package org.clb.structure.eor;

/**
 * 假如一个数组只有两个数a,b出现奇数次 其它数都出现偶数次，求出这两个数的值
 * ^:不同为1 相同为0 偶数个数^都为0
 * 所有数^结果为 a^b 由于a,b是两个不同的数 故至少有一个位置上的数是不同的 为1
 * 求取最右侧的1下标为i 大小为c  此时原先所有数可以分为两种情况 i位为1和i位为0
 * c为00001000 此时c与原先所有数进行&运算 如果！=0就进行^运算即可得出a
 * 然后a与a^b进行^运算即可得出b
 */
public class Eor_Code_01 {

    public static int[] getTwoResult(int[] a) {
        int eor = 0;
        for (int i = 0; i < a.length; i++) {
            eor ^= a[i];
        }
        System.out.println("eor=:" + eor);
        //获取最右侧的1
        int eor2 = eor & (-eor);//5: 0101 1011
        System.out.println("eor2=" + eor2);
        int resulta = 0;
        for (int i = 0; i < a.length; i++) {
            if ((a[i] & eor2) != 0) {
                resulta ^= a[i];
            }
        }
        int[] result = new int[2];
        result[0] = resulta;
        result[1] = resulta ^ eor;
        return result;
    }

    public static int[] getIntArray() {
        int max = 100;
        //数组的长度为0-100的随机数
        //int size=(int)(Math.random()*10)+90;
        int size = 20;
        int acount = 2 * (int) (Math.random() * 5) + 1;
        int bcount = 2 * (int) (Math.random() * 5) + 1;
        int[] res = new int[size];
        int start = 0;
        putNumIntoArray(res, start, acount);
        start += acount;
        putNumIntoArray(res, acount, bcount);
        start += bcount;
        while (true) {
            if (start < size - 10) {
                int ccount = 2 * (int) (Math.random() * 5);
                putNumIntoArray(res, start, ccount);
                start += ccount;
            } else if (start < size) {
                int ccount = size - start;
                putNumIntoArray(res, start, ccount);
                return res;
            }

        }

    }

    /**
     * @param a     需要加入数的数组
     * @param start 数组a的下标
     * @param b     需要放入的个数
     * @return
     */
    public static int[] putNumIntoArray(int[] a, int start, int b) {
        int c = (int) (Math.random() * 10) + 1;
        for (int i = start; i < b + start && i < a.length; i++) {
            a[i] = c;
        }
        return a;
    }

    public static void main(String[] args) {
        //        for (int i = 0; i < 10; i++) {
        //            int[] intArray = getIntArray();
        //            for (int j = 0; j < intArray.length; j++) {
        //                System.out.print(intArray[j] + " ");
        //            }
        //            System.out.println();
        //            int[] twoResult = getTwoResult(intArray);
        //            System.out.println(twoResult[0] + ":" + twoResult[1]);
        //            System.out.println("========");
        //        }
        //getTwoResult(new int[]{6,6,6,6,6,9,9,9,8,8,8,8,8,8,8,8,2,2,2,2});
        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(0 ^ 0);
    }


}

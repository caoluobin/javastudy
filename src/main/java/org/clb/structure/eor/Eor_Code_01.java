package org.clb.structure.eor;

/**
 * ����һ������ֻ��������a,b���������� ������������ż���Σ��������������ֵ
 * ^:��ͬΪ1 ��ͬΪ0 ż������^��Ϊ0
 * ������^���Ϊ a^b ����a,b��������ͬ���� ��������һ��λ���ϵ����ǲ�ͬ�� Ϊ1
 * ��ȡ���Ҳ��1�±�Ϊi ��СΪc  ��ʱԭ�����������Է�Ϊ������� iλΪ1��iλΪ0
 * cΪ00001000 ��ʱc��ԭ������������&���� �����=0�ͽ���^���㼴�ɵó�a
 * Ȼ��a��a^b����^���㼴�ɵó�b
 */
public class Eor_Code_01 {

    public static int[] getTwoResult(int[] a) {
        int eor = 0;
        for (int i = 0; i < a.length; i++) {
            eor ^= a[i];
        }
        System.out.println("eor=:" + eor);
        //��ȡ���Ҳ��1
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
        //����ĳ���Ϊ0-100�������
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
     * @param a     ��Ҫ������������
     * @param start ����a���±�
     * @param b     ��Ҫ����ĸ���
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

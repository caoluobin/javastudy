package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * ��������Ϊ -2 �������� arr1 �� arr2������������ӵĽ����
 * ������ ������ʽ ���������������� 0 �� 1 ��ɣ��������Чλ�������Чλ��˳�����С�
 * ���磬arr = [1,1,0,1] ��ʾ���� (-2)^3 + (-2)^2 + (-2)^0 = -3��������ʽ �е����� arr Ҳͬ������ǰ���㣺
 * �� arr == [0] �� arr[0] == 1��
 * ������ͬ��ʾ��ʽ�� arr1 �� arr2 ��ӵĽ���������ı�ʾ��ʽΪ������ǰ���㡢������ 0 �� 1 ��ɵ����顣
 * ���룺arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * �����[1,0,0,0,0]
 * ���ͣ�arr1 ��ʾ 11��arr2 ��ʾ 5�������ʾ 16 ��
 */
public class Code_1073 {
    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int length = Math.max(length1,length2);
        int index = 1;
        List<Integer> list  = new LinkedList<>();
        int last = 0;
        while (index<length) {

            int a = index<length1?arr1[length1-index]:0;
            int b = index<length2?arr2[length2-index]:0;
            int sum = a+b+last;
            Integer res = 0;
            switch (sum) {
                case 0:res=0;last=0;break;
                case 1:res=1;last=0;break;
                case 2:res=0;last=-1;break;
                default:
                    System.out.println("����");
            }
            list.add(res);
            index++;
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[] ints = addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1});
        //0 0 0 0 1
        for (int anInt : ints) {
            System.out.println(anInt);
        }// 100 =  1 1 0 2 0
        // 1 0 1   ||  1           0 -1 1 0  ||   -1  0   1 0 2 0
        //    16 -8 4 -2 1
        //     1  1 0  1 0
    }
}

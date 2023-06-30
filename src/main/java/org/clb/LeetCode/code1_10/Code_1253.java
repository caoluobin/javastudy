package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * ����һ�� 2 �� n �еĶ��������飺
 * ������һ�������ƾ�������ζ�ž����е�ÿ��Ԫ�ز��� 0 ���� 1��
 * �� 0 �е�Ԫ��֮��Ϊ upper��
 * �� 1 �е�Ԫ��֮��Ϊ lower��
 * �� i �У��� 0 ��ʼ��ţ���Ԫ��֮��Ϊ colsum[i]��colsum ��һ������Ϊ n ���������顣
 * ����Ҫ���� upper��lower �� colsum ���ع�������󣬲��Զ�ά�����������ʽ��������
 * ����ж����ͬ�Ĵ𰸣���ô����һ��������ͨ�����⡣
 * ��������ڷ���Ҫ��Ĵ𰸣����뷵��һ���յĶ�ά���顣
 */
public class Code_1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        if (upper>colsum.length||lower>colsum.length){
            return new ArrayList<>();
        }
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        LinkedList<Integer> indexList = new LinkedList<>();
        int sum = 0;
        int allSum = upper+lower;
        for (int i = 0; i < colsum.length; i++) {
            int col = colsum[i];
            sum+= col;
            if (col == 2) {
                list1.add(1);
                list2.add(1);
                if (upper<=0){//���upper�����ˣ���list1ǰ��ȡ��һ��1
                    if (indexList.isEmpty()){
                        return new ArrayList<>();
                    }
                    Integer index = indexList.removeFirst();
                    list1.set(index,0);
                    list2.set(index,1);
                    upper++;
                    lower--;
                }
                upper--;
                lower--;
            } else if (col ==1 &&upper>0) {//��1����list1�����
                list1.add(1);
                list2.add(0);
                indexList.add(i);
                upper--;
            } else if (col ==1 &&lower>0) {//���upper�����ˣ�����list2�����
                list1.add(0);
                list2.add(1);
                lower--;
            } else if (col ==0) {
                list1.add(0);
                list2.add(0);
            }
            if (sum>allSum){
                return new ArrayList<>();
            }
        }
        if (upper!=0||lower!=0){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(list1);
        res.add(list2);
        return res;
    }

    public List<List<Integer>> reconstructMatrix2(int upper, int lower, int[] colsum) {
        if (upper>colsum.length||lower>colsum.length){
            return new ArrayList<>();
        }
        //��colsum���
        int sum = 0;
        for (int i = 0; i < colsum.length; i++) {
            sum+=colsum[i];
        }
        if (sum!=upper+lower){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for (int count : colsum) {
            if (count==2) {
                res.get(0).add(1);
                res.get(1).add(1);
                upper--;
                lower--;
            } else if (count==1) {
                if (upper>lower){
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                }else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                    lower--;
                }
            } else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
            if (upper<0||lower<0){
                return new ArrayList<>();
            }
        }
        return res;
    }
}

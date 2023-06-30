package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * 给你一个 2 行 n 列的二进制数组：
 * 矩阵是一个二进制矩阵，这意味着矩阵中的每个元素不是 0 就是 1。
 * 第 0 行的元素之和为 upper。
 * 第 1 行的元素之和为 lower。
 * 第 i 列（从 0 开始编号）的元素之和为 colsum[i]，colsum 是一个长度为 n 的整数数组。
 * 你需要利用 upper，lower 和 colsum 来重构这个矩阵，并以二维整数数组的形式返回它。
 * 如果有多个不同的答案，那么任意一个都可以通过本题。
 * 如果不存在符合要求的答案，就请返回一个空的二维数组。
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
                if (upper<=0){//如果upper不够了，从list1前面取出一个1
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
            } else if (col ==1 &&upper>0) {//有1先往list1里面放
                list1.add(1);
                list2.add(0);
                indexList.add(i);
                upper--;
            } else if (col ==1 &&lower>0) {//如果upper不够了，就往list2里面放
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
        //对colsum求和
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

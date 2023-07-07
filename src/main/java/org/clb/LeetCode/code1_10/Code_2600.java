package org.clb.LeetCode.code1_10;

/**
 * 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
 * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 * 袋子最初包含：
 * numOnes 件标记为 1 的物品。
 * numZeroes 件标记为 0 的物品。
 * numNegOnes 件标记为 -1 的物品。
 * 现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 */
public class Code_2600 {


    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k == 0) {
            return 0;
        }
        if (k<=numOnes){
            return k;
        } else if (k<=numOnes+numZeros){
            return numOnes;
        } else if (k<=numOnes+numZeros+numNegOnes){
            return numOnes-(k-numOnes-numZeros);
        } else {
            return numOnes+numNegOnes;
        }
    }
}

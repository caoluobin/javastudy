package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 finalSum 。请你将它拆分成若干个 互不相同 的正偶数之和，且拆分出来的正偶数数目 最多 。
 * 比方说，给你 finalSum = 12 ，那么这些拆分是 符合要求 的（互不相同的正偶数且和为 finalSum）：(2 + 10) ，(2 + 4 + 6) 和 (4 + 8) 。
 * 它们中，(2 + 4 + 6) 包含最多数目的整数。注意 finalSum 不能拆分成 (2 + 2 + 4 + 4) ，因为拆分出来的整数必须互不相同。
 * 请你返回一个整数数组，表示将整数拆分成 最多 数目的正偶数数组。如果没有办法将 finalSum 进行拆分，请你返回一个 空 数组。你可以按 任意 顺序返回这些整数。
 */
public class Code_2178 {

    public static void main(String[] args) {
        Code_2178 code_2178 = new Code_2178();
        List<Long> list = code_2178.maximumEvenSplit(14);
        for (Long count : list) {
            System.out.println(count);
        }
    }
    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum%2==1||finalSum <=0) {
            return new ArrayList<>();
        }
        List<Long> list = new ArrayList<>();
        long now = 0l;
        while (true) {
            now +=2;
            finalSum -=now;
            if (finalSum<=now){
                list.add(finalSum+now);
                break;
            }
            list.add(now);
        }
        return list;
    }
}

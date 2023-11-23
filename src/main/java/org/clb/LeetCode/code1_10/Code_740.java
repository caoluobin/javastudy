package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.codeUtil.StructureUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 */
public class Code_740 {

    public static void main(String[] args) {
        Code_740 code = new Code_740();

        for (int i = 0; i < 100; i++) {
            int[] arrays = StructureUtil.getIntArray();
            if (code.deleteAndEarn(arrays)!=code.deleteAndEarn2(arrays)) {
                for (int num : arrays) {
                    System.out.println(num);
                }
                break;
            }

        }
    }

    public int deleteAndEarn(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int num : nums) {
            if (sumMap.put(num, sumMap.getOrDefault(num, 0) + num) == null) {
                list.add(num);
            }
        }
        list.sort(Integer::compareTo);
        int lNsMax = 0;
        int sMax = 0;
        int nsMax = 0;
        int last = -1;
        for (Integer count : list) {
            lNsMax = nsMax;
            nsMax = Math.max(sMax, nsMax);
            if (count - last == 1) {
                sMax =lNsMax+ sumMap.get(count);
            } else {
                sMax =Math.max(sMax, nsMax)+ sumMap.get(count);
            }
            last = count;
        }

        return Math.max(sMax, nsMax);
    }

    public int deleteAndEarn2(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num,max);
        }
        int[] sums = new int[max];
        for (int num : nums) {
            sums[num-1]+=num;
        }
        int lNsMax = 0;
        int sMax = 0;
        int nsMax = 0;
        int last = -1;

        for (int count = 0; count < max; count++) {
            lNsMax = nsMax;
            nsMax = Math.max(sMax, nsMax);
            if (count - last == 1) {
                sMax =lNsMax+ sums[count];
            } else {
                sMax =Math.max(sMax, nsMax)+ sums[count];
            }
            last = count;
        }

        return Math.max(sMax, nsMax);
    }
}

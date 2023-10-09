package org.clb.LeetCode.code1_10;

import org.clb.LeetCode.codeUtil.StructureUtil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ����һ���������� nums ������Զ�������һЩ������
 * ÿ�β����У�ѡ������һ�� nums[i] ��ɾ��������� nums[i] �ĵ�����
 * ֮�������ɾ�� ���� ���� nums[i] - 1 �� nums[i] + 1 ��Ԫ�ء�
 * ��ʼ��ӵ�� 0 ����������������ͨ����Щ������õ���������
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

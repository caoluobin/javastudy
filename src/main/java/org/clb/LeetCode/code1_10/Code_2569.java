package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ���������±�� 0 ��ʼ������ nums1 �� nums2 ����һ����ά���� queries ��ʾһЩ�������ܹ��� 3 �����͵Ĳ�����
 * �������� 1 Ϊ queries[i] = [1, l, r] ������Ҫ�� nums1 ���±� l ���±� r ������ 0 ��ת�� 1 �� 1 ��ת�� 0 ��l �� r �±궼�� 0 ��ʼ��
 * �������� 2 Ϊ queries[i] = [2, p, 0] ������ 0 <= i < n �е������±꣬�� nums2[i] = nums2[i] + nums1[i] * p ��
 * �������� 3 Ϊ queries[i] = [3, 0, 0] ���� nums2 ������Ԫ�صĺ͡�
 * ���㷵��һ�����飬�������е����ֲ������͵Ĵ𰸡�
 */
public class Code_2569 {
    public static void main(String[] args) {

    }

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        List<Long> res = new ArrayList<>();
        long nums2Sum = Arrays.stream(nums2).mapToLong(a->a).sum();
        long nums1Sum = Arrays.stream(nums1).mapToLong(a->a).sum();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] == 1) {
                for (int j = query[1]; j <= query[2]; j++) {
                    if (nums1[j] == 1) {
                        nums1[j] = 0;
                        nums1Sum--;
                    } else {
                        nums1[j] = 1;
                        nums1Sum++;
                    }

                }
            } else if (query[0] == 2) {
                nums2Sum += nums1Sum * query[1];
            } else {
                res.add(nums2Sum);
            }
        }
        return res.stream().mapToLong(Long::longValue).toArray();
    }
}

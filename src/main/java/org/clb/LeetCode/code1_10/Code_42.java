package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��
 */
public class Code_42 {

    public int trap(int[] height) {
        int leftMaxIndex =0;
        List<Integer> maxList = new ArrayList<>();

        int last = height[0];
        for (int i = 1; i < height.length; i++) {
            if (height[i]>last) {

            }
            if (height[i]==last) {

            }
            if (height[i]<last) {
                //������ڵ���leftMaxIndex��ֵ leftMaxIndex==i ������ߵ�ֵ
                //maxList��i
            }
        }
        return 0;

    }
}

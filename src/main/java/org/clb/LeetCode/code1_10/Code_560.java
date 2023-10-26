package org.clb.LeetCode.code1_10;

import java.util.HashMap;
import java.util.Map;

/**
 * ����һ���������� nums ��һ������ k ������ͳ�Ʋ����� �������к�Ϊ k ��������ĸ��� ��
 * ��������������Ԫ�ص������ǿ����С�  nums������Ϊ-1000~1000
 */
public class Code_560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        //key ǰi���ĺ�  value �ú͵ĸ���
        Map<Integer,Integer> map = new HashMap<>();
        int pre = 0;
        //����pre=k��ʱ����һ��
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            pre+=nums[i];
            if (map.containsKey(pre-k)) {// pre-k ����ǰ���
                count+= map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum==k) {
                    count++;
                }
            }
        }
        return count;
    }

}

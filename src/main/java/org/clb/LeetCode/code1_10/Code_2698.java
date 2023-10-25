package org.clb.LeetCode.code1_10;


import java.util.*;

/**
 * ����һ�������� n �����㷵�� n �� �ͷ��� ��
 * n �� �ͷ��� ����Ϊ���������������� i ������ƽ���ͣ�
 * 1 <= i <= n
 * i * i ��ʮ���Ʊ�ʾ���ַ������Էָ�������������ַ���������Щ���ַ�����Ӧ������ֵ֮�͵��� i ��
 */
public class Code_2698 {
    public static void main(String[] args) {
        Code_2698 code = new Code_2698();
        System.out.println(code.punishmentNumber(45));
    }
    // key ��ǰֵ  set: ����ӵ�еĺ�
    private static Map<Integer, Set<Integer>> map = new HashMap<>();
    public int punishmentNumber(int n) {
        int res=0;
        for (int i = 1; i < n + 1; i++) {
            int m = i *i;
            if (isM(i,m)) {
                res+=i*i;
            }
        }
        return res;
    }
    private boolean isM(Integer count,Integer m) {
        //�������
        Set<Integer> set = map.get(m);
        if (set!=null) {
            return set.contains(count);
        } else {
            //1233
           return dfs(m).contains(count);
        }
    }

    /**
     * ����m�����н����map��
     * @param m
     */
    private Set<Integer> dfs(Integer m) {
        if (map.containsKey(m)) {
            return map.get(m);
        }
        Set<Integer> set = new HashSet<>();
        set.add(m);
        if (m>=10) {
            int a =10 ;
            while (m>=a) {
                int d =m%a;
                int s = m/a;
                Set<Integer> dfs = dfs(s);
                for (Integer df : dfs) {
                    set.add(df + d);
                }
                a=a*10;
            }
        }
        map.put(m,set);
        return set;
    }


}

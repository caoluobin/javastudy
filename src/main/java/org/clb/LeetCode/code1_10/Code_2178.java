package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ������ finalSum �����㽫����ֳ����ɸ� ������ͬ ����ż��֮�ͣ��Ҳ�ֳ�������ż����Ŀ ��� ��
 * �ȷ�˵������ finalSum = 12 ����ô��Щ����� ����Ҫ�� �ģ�������ͬ����ż���Һ�Ϊ finalSum����(2 + 10) ��(2 + 4 + 6) �� (4 + 8) ��
 * �����У�(2 + 4 + 6) ���������Ŀ��������ע�� finalSum ���ܲ�ֳ� (2 + 2 + 4 + 4) ����Ϊ��ֳ������������뻥����ͬ��
 * ���㷵��һ���������飬��ʾ��������ֳ� ��� ��Ŀ����ż�����顣���û�а취�� finalSum ���в�֣����㷵��һ�� �� ���顣����԰� ���� ˳�򷵻���Щ������
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

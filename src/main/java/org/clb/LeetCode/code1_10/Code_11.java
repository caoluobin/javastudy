package org.clb.LeetCode.code1_10;

import java.util.LinkedList;
import java.util.List;

/**
 * ����һ������Ϊ n ���������� height ���� n �����ߣ��� i ���ߵ������˵��� (i, 0) �� (i, height[i]) ��
 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
 * �����������Դ�������ˮ����
 */
public class Code_11 {

    public static void main(String[] args) {
        //������������maxArea��maxArea2�ķ��ؽ�����в��� �����һ�����
        for (int i = 0; i < 100; i++) {
            int[] ints = generateRandomArray(100, 100);
            int maxArea = new Code_11().maxArea(ints);
            int maxArea2 = new Code_11().maxArea2(ints);
            if (maxArea!=maxArea2) {
                System.out.println("maxArea = " + maxArea);
                System.out.println("maxArea2 = " + maxArea2);
                System.out.println("ints = " + ints);
                break;
            }
        }
    }

    /**
     * �����������
     * @param length ���鳤��
     * @param max ����Ԫ�����ֵ
     * @return
     */
    private static int[] generateRandomArray(int length, int max) {
        int[] ints = new int[length];
        for (int i = 0; i < length; i++) {
            ints[i] = (int) (Math.random() * max);
        }
        return ints;
    }
    /**
     * ˫ָ�� ���������м��ƶ� �ƶ��̵���һ�� ��Ϊ�ƶ�������һ�߲�����ʹ������� ֻ���ƶ��̵���һ�߲��п���ʹ������� �����ƶ��̵���һ��Ҳ��һ����ʹ������� �����ƶ��̵���һ��
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length-1;
        int max = 0;
        while (left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]) {
                int now = height[left];
                do {
                    left++;
                } while (now>=height[left]&&left<right);
            }else {
                int now = height[right];
                do {
                    right--;
                } while (height[right]<=now&&left<right);
            }
        }
        return max;
    }
    public int maxArea3(int[] height) {
        int max = 0;
        int heighta = 0;
        List<Area> areas = new LinkedList<>();
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, Math.min(height[0], height[i]) * (i));
            if (height[i] > heighta) {
                heighta = height[i];
                areas.add(new Area(i, height[i]));
            }
        }
        for (int i = 1; i < height.length; i++) {
            for (Area area : areas) {
                if (area.index < i) {
                    max = Math.max(max, Math.min(area.height, height[i]) * (i - area.index));
                }
            }

        }
        return max;
    }

    class Area {
        int index;
        int height;

        public Area(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
}

package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * 给出基数为 -2 的两个数 arr1 和 arr2，返回两数相加的结果。
 * 数字以 数组形式 给出：数组由若干 0 和 1 组成，按最高有效位到最低有效位的顺序排列。
 * 例如，arr = [1,1,0,1] 表示数字 (-2)^3 + (-2)^2 + (-2)^0 = -3。数组形式 中的数字 arr 也同样不含前导零：
 * 即 arr == [0] 或 arr[0] == 1。
 * 返回相同表示形式的 arr1 和 arr2 相加的结果。两数的表示形式为：不含前导零、由若干 0 和 1 组成的数组。
 * 输入：arr1 = [1,1,1,1,1], arr2 = [1,0,1]
 * 输出：[1,0,0,0,0]
 * 解释：arr1 表示 11，arr2 表示 5，输出表示 16 。
 */
public class Code_1073 {
    public static int[] addNegabinary(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int length = Math.max(length1,length2);
        int index = 1;
        List<Integer> list  = new LinkedList<>();
        int last = 0;
        int llast = 0;
        int lllast = 0;
        while (index<=length) {

            int a = index<=length1?arr1[length1-index]:0;
            int b = index<=length2?arr2[length2-index]:0;
            int sum = a+b+last;
            last=llast;
            llast=lllast;
            lllast=0;
            Integer res = 0;
            switch (sum) {
                case -1:res=1;last+=-1;llast+=1;lllast=1;break;
                case 0:res=0;last+=0;llast+=0;break;
                case 1:res=1;last+=0;llast+=0;break;
                case 2:res=0;last+=-1;llast+=0;break;
                case 3: res =1;last+=-1;llast+=0;break;
                default:
                    System.out.println("错误");
            }
            if (index==length && res==0&&last==0) break;
            list.add(res);
            index++;
        }
        if (last==-1) {
            list.add(1);
            list.add(1);
        }else if (last != 2 || llast != 1) {
            if (llast != 0) {
                list.add(last);
                list.add(llast);
            } else if (last != 0) {
                list.add(last);
            }
        }
        Collections.reverse(list);
        if (list.size()!=1) {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if (next==0) {
                    iterator.remove();
                } else {
                    break;
                }
            }
        }
        if (list.size()==0)  return new int[]{0};
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] other(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        List<Integer> ans = new ArrayList<Integer>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = carry;
            if (i >= 0) {
                x += arr1[i];
            }
            if (j >= 0) {
                x += arr2[j];
            }
            if (x >= 2) {
                ans.add(x - 2);
                carry = -1;
            } else if (x >= 0) {
                ans.add(x);
                carry = 0;
            } else {
                ans.add(1);
                carry = 1;
            }
            --i;
            --j;
        }
        while (ans.size() > 1 && ans.get(ans.size() - 1) == 0) {
            ans.remove(ans.size() - 1);
        }
        int[] arr = new int[ans.size()];
        for (i = 0, j = ans.size() - 1; j >= 0; i++, j--) {
            arr[i] = ans.get(j);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = addNegabinary(new int[]{1,1,1}, new int[]{1,1,0});//[1,0,1,0]
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
        System.out.println();
        //   -1 0   1 1 0
    }
}

package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。
 * 例如，str == ["abc", 3] =="abcabcabc" 。
 * 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。
 * 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。
 * 现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, n2] 。
 * 请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。
 */
public class Code_466 {

    public static void main(String[] args) {
        Code_466 code = new Code_466();
        code.test();
        System.out.println(code.getMaxRepetitions("i", 10, "i", 3));
        System.out.println(code.getMaxRepetitions2("i", 10, "i", 3));
    }

    private void test() {
        Code_466 code = new Code_466();
        for (int i = 0; i < 1000; i++) {
            //随机生成输入比较测试如果返回值不一样则打印
            String s1 = code.getRandomString(1, 5);
            String s2 = code.getRandomString(1, 5);
            int n1 = (int) (Math.random() * 10)+1;
            int n2 = (int) (Math.random() * n1)+1;
            int res1 = code.getMaxRepetitions(s1, n1, s2, n2);
            int res2 = code.getMaxRepetitions2(s1, n1, s2, n2);
            if (res1 != res2) {
                System.out.println("s1:" + s1 + " n1:" + n1 + " s2:" + s2 + " n2:" + n2);
                System.out.println("res1:" + res1 + " res2:" + res2);
                break;
            }
        }
    }
    private String getRandomString(int i, int i1) {
        int length = (int) (Math.random() * i1) + i;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < length; j++) {
            sb.append((char) (Math.random() * 26 + 'a'));
        }
        return sb.toString();
    }

    /**
     * map优化版
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int length1 = s1.length()*n1;
        //走过s2的次数结果值
        int res = 0;
        //s2的下标
        int index = 0;
        //标记每次s2开始的下标
        Map<Integer,Integer[]> maxMap = new HashMap<>();

        boolean flag =true;
        for (int i = 0; i < length1; i++) {
            if (s1.charAt(i % s1.length()) == s2.charAt(index % s2.length())) {
                index++;
                if (index%s2.length()==0) {//走完一遍s2
                    //此时结束的下标如果和之前某个s2的开始下标刚好是s1长度的整数倍
                    Integer a = i%s1.length();
                    if (maxMap.containsKey(a)&&flag){
                        Integer[] c=maxMap.get(a);
                        int lastIndex = c[0];
                        int lastCount = c[1];
                        //这段距离可以走s1Count个s1
                        int s1Count = (i+1-lastIndex)/s1.length();
                        //这段距离可以走s2Count个s2
                        int s2Count = res-lastCount;
                        //还可以走s1ReCount个(s1Count*s1)
                        int s1ReCount = (length1-i-1)/s1.length()/s1Count;
                        res +=s2Count*s1ReCount;
                        i+=s1ReCount*s1.length()*s1Count;
                        flag=false;
                    }
                    maxMap.put(a,new Integer[]{i+1,res});
                    res++;
                }
            }
        }
        return res/n2;
    }
    public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        int length1 = s1.length()*n1;
        //走过s2的次数结果值
        int res = 0;
        //s2的下标
        int index = 0;
        //标记每次s2开始的下标
        List<Integer> list =new ArrayList<>();
        Map<Integer,Integer> maxMap = new HashMap<>();
        list.add(0);

        for (int i = 0; i < length1; i++) {
            if (s1.charAt(i % s1.length()) == s2.charAt(index % s2.length())) {
                index++;
                if (index%s2.length()==0) {//走完一遍s2
                    //此时结束的下标如果和之前某个s2的开始下标刚好是s1长度的整数倍
                    for (int j = list.size()-1; j >=0 ; j--) {
                        if ((i+1-list.get(j))%s1.length()==0){
                            //这段距离可以走s1Count个s1
                            int s1Count = (i+1-list.get(j))/s1.length();
                            //这段距离可以走s2Count个s2
                            int s2Count = list.size()-j;
                            //还可以走s1ReCount个(s1Count*s1)
                            int s1ReCount = (length1-i-1)/s1.length()/s1Count;
                            res +=s2Count*s1ReCount;
                            i+=s1ReCount*s1.length()*s1Count;
                            break;
                        }
                    }
                    list.add(i+1);
                    res++;
                }
            }
        }
        return res/n2;
    }
}

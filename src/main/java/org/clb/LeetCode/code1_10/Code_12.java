package org.clb.LeetCode.code1_10;

/**
 * I  1 V  5  X  10 L  50 C  100 D  500 M  1000
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给你一个整数，将其转为罗马数字。
 */
public class Code_12 {

    public static void main(String[] args) {
        System.out.println(new Code_12().intToRoman(3999));
    }
    public String intToRoman(int num) {

        return "";
    }
    public String intToRoman2(int num) {
        //把num转成罗马数字
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
        String result = "";
        int i =0;
        while (num>0) {
            int temp = num % 10;
            switch (temp) {
                case 1:
                    result = roman[i] + result;
                    break;
                case 2:
                    result = roman[i] + roman[i] + result;
                    break;
                case 3:
                    result = roman[i] + roman[i] + roman[i] + result;
                    break;
                case 4:
                    result = roman[i] + roman[i + 1] + result;
                    break;
                case 5:
                    result = roman[i + 1] + result;
                    break;
                case 6:
                    result = roman[i + 1] + roman[i] + result;
                    break;
                case 7:
                    result = roman[i + 1] + roman[i] + roman[i] + result;
                    break;
                case 8:
                    result = roman[i + 1] + roman[i] + roman[i] + roman[i] + result;
                    break;
                case 9:
                    result = roman[i] + roman[i + 2] + result;
                    break;
            }
            i+=2;
            num = num / 10;
        }
        return result;
    }
}

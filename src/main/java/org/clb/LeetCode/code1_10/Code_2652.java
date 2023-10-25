package org.clb.LeetCode.code1_10;

import java.util.HashSet;
import java.util.Set;

public class Code_2652 {
    public static void main(String[] args) {
        Code_2652 code = new Code_2652();
        for (int i = 0; i < 100; i++) {
            if (code.sumOfMultiples(i)!= code.sumOfMultiples2(i)) {
                System.out.println(i);
            }
        }
        System.out.println(code.sumOfMultiples(20));
    }

    public int sumOfMultiples(int n) {
        int sum = 0;
        int m =1;
        while (true) {
            int m3 = m*3;
            if (m3<=n) {
                sum+=m3;
                m++;
            } else {
                break;
            }
        }
        m =1;
        while (true) {
            int m5 = m*5;
            if (m5<=n) {
                if (m5%3!=0){
                    sum+=m5;
                }
                m++;
            } else {
                break;
            }
        }
        m =1;
        while (true) {
            int m7 = m*7;
            if (m7<=n) {
                if (m7%3!=0&&m7%5!=0) {
                    sum+=m7;
                }
                m++;
            } else {
                break;
            }
        }
        return sum;

    }

    public int sumOfMultiples2(int n) {
        int sum =0;
        for (int i = 1; i <=n; i++) {
            if (i%3==0||i%5==0||i%7==0) {
                sum+=i;
            }
        }

        return sum;
    }
}

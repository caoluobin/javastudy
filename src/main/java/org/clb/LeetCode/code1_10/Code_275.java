package org.clb.LeetCode.code1_10;

/**
 * 一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
 */
public class Code_275 {

    public static void main(String[] args) {
        Code_275 code = new Code_275();
        code.hIndex(new int[]{3,4});
    }
    public int hIndex(int[] citations) {
        int length = citations.length;
        if (citations[length - 1] == 0) {
            return 0;
        }
        if (length==1&&citations[0]>=1) {
            return 1;
        }
        int left = 0 ;
        int right = length -1;
        while (left!=right) {// 1 2 4 5
            int mid = (left+right)/2;
            int h = citations[mid];
            int h2 = mid-1>=0 ? citations[mid-1]:Integer.MIN_VALUE;
            if (length - mid <= h && length - mid+1 >h2) {
                return length - mid;
            } else if (length - mid > h) {
                if (left==right-1) {
                    if (citations[right]>=length-right) {
                        return length-right;
                    } else {
                        return 0;
                    }
                } else {
                    left=mid;
                }
            } else {
                right = mid;
            }
        }
        return 0;
    }
}

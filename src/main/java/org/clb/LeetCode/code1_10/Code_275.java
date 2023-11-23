package org.clb.LeetCode.code1_10;

/**
 * һ��������Ա�� h ָ����ָ���������� ��n ƪ�����У��ܹ��� h ƪ���ķֱ����������� h �Ρ�
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

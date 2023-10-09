package org.clb.LeetCode.code1_10;

import lombok.var;

import java.util.*;

public class Code_1637 {

    public static void main(String[] args) {
        Code_1637 code = new Code_1637();
        int[][] cc= {{1,2},{2,8},{3,2},{4,1},{100,1}};
        System.out.println(code.acc(cc));
    }
    public int maxWidthOfVerticalArea2(int[][] points) {
        Arrays.sort(points, Comparator.comparing(a->a[0]));
        int max = 0;
        for (int i = 1; i < points.length; i++) {
            max= Math.max(max,points[i][0]-points[i-1][0]);
        }
        return max;
    }
    public int maxWidthOfVerticalArea(int[][] points) {
        int max =points[0][0];
        int min =points[0][0];
        for (int[] point : points) {
            max=Math.max(max,point[0]);
            min=Math.min(min,point[0]);
        }
        int count = max-min+1;
        if (count>points.length*Math.log(points.length)) {
            return maxWidthOfVerticalArea2(points);
        }

        Integer[] buckets = new Integer[count];
        for (int[] point : points) {
            int now = point[0];
            buckets[now-min]=now;
        }
        int res = 0;
        int last = min;
        for (Integer now : buckets) {
            if (now!=0) {
                res = Math.max(res,now-last);
                last = now;
            }
        }
        return res;
    }

    public int acc (int[][] points) {
        int n = points.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = points[i][0];
        }
        final int inf = 1 << 30;
        int mi = inf, mx = -inf;
        for (int v : nums) {
            mi = Math.min(mi, v);
            mx = Math.max(mx, v);
        }
        int bucketSize = Math.max(1, (mx - mi) / (n - 1));
        int bucketCount = (mx - mi) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][2];
        for (var bucket : buckets) {
            bucket[0] = inf;
            bucket[1] = -inf;
        }
        for (int v : nums) {
            int i = (v - mi) / bucketSize;
            buckets[i][0] = Math.min(buckets[i][0], v);
            buckets[i][1] = Math.max(buckets[i][1], v);
        }
        int prev = inf;
        int ans = 0;
        for (var bucket : buckets) {
            if (bucket[0] > bucket[1]) {
                continue;
            }
            ans = Math.max(ans, bucket[0] - prev);
            prev = bucket[1];
        }
        return ans;
    }
}

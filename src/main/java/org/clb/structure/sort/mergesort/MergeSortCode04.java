package org.clb.structure.sort.mergesort;

/**
 * @Description 给定一个数组arr,两个整数lower和Upper
 * 返回arr中有多少个子数组的累加和在[lower,upper]范围上
 * @Classname MergeSortCode04
 * @Date 2021/5/15 23:22
 * @Author clb
 */
public class MergeSortCode04 {
    public static int count(int[] arr,int lower,int upper){
        if (arr==null||arr.length<1){
            return 0;
        }
        return process(arr,0,arr.length-1,lower,upper);
    }

    private static int process(int[] arr, int l, int r, int lower, int upper) {
        if (r==l) return arr[l]>=l&&arr[l]<=upper?1:0;
        int mid=l+((r-l)>>1);
            return process(arr,l,mid,lower,upper)+process(arr,mid+1,r,lower,upper)+merge(arr,l,mid,r,lower,upper);

    }

    /**
     * 135 278  10 20
     * 1 2 3 5 7
     * @param arr
     * @param l
     * @param mid
     * @param r
     * @param lower
     * @param upper
     * @return
     */
    private static int merge(int[] arr, int l, int mid, int r, int lower, int upper) {
        int[] h=new int[r-l+1];
        int p=l;
        int q=mid+1;
        int count=0;
        int sum=0;
        int a=0;
        while (p<=mid&&q<=r){
            h[a++]=sum+=arr[p]>arr[q]?arr[q++]:arr[p++];
            if (sum>=lower&&sum<=upper) count++;
        }
        while (p<=mid){
            h[a++]=arr[p++];
        }
        while (q<=r){
            h[a++]=arr[q++];
        }
        for (int i = 0; i < h.length; i++) {
            arr[l+i]=h[i];
        }
        if (count==0) return 0;
        return (count+1)*count/2;
    }

    public static void main(String[] args) {
        int count = count(new int[]{1,5,7,8}, 10, 20);//1 2 3 3 6 7
        System.out.println(count);
    }
}

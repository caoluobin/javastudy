package org.clb.structure.sort.mergesort;

/** 求小和
 * 例如 2 3 3 6 5  和为 2*4 +3*2+3*2
 * @Description
 * @Classname MergeSortCode01
 * @Date 2021/5/13 4:06
 * @Author clb
 */
public class MergeSortCode01 {
    public static int  samllSum(int[] array){
        while (array==null||array.length<2){
            return 0;
        }
        return  process(array,0,array.length-1);
    }

    /**
     * 递归求小和
     * @param array
     * @param l 左下标
     * @param r 右下标
     * @return
     */
    private static int process(int[] array, int l, int r) {
        if (l==r){
            return 0;
        }
        int mid=l+((r-l)>>1);
        //小和等于左边的小和加上右边的小和加上合并过程中产生的小和
        return process(array,l,mid) +process(array,mid+1,r) +merge(array,l,mid,r);

    }

    /**
     * 分为左右两组  只有当左组数据小于右组数据的时候产生小和
     * 1357 2458 当相等时要先移右边的下标
     * 1
     * @param array
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private static int merge(int[] array, int l, int mid, int r) {
        int[] h=new int[r-l+1];
        int res=0;
        int a=0;//h的下标
        int p=l;//左下标 0
        int q=mid+1;//右下标 4
        while (p<=mid&&q<=r){
            res+=array[p]<array[q]?array[p]*(r-q+1):0;
            h[a++]=array[p]<array[q]?array[p++]:array[q++];
        }
        while (p<=mid){
            h[a++]=array[p++];
        }
        while (q<=r){
            h[a++]=array[q++];
        }
        for (int i = 0; i < h.length; i++) {
            array[l+i]=h[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int i = samllSum(new int[]{2, 3, 3, 6, 5});
        System.out.println(i);
        //System.out.println(4+((5-4)>>1));
    }
}

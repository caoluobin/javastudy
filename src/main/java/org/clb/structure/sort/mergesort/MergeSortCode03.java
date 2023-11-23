package org.clb.structure.sort.mergesort;

/**
 * @Description num右边有多少个数*2<num 求出数组中的个数和
 * 分一半 左边的加右边的  加上merge过程中产生的个数
 * @Classname MergeSortCode03
 * @Date 2021/5/13 5:53
 * @Author clb
 */
public class MergeSortCode03 {
    public static int count(int[] array){
        if (array==null||array.length<2){
            return 0;
        }
        return process(array,0,array.length-1);
    }

    private static int process(int[] array, int l, int r) {
        if (l==r) return 0;
        int mid=l+((r-l)>>1);
        return process(array,l,mid)+process(array,mid+1,r)+merge(array,l,mid,r);
    }

    /**
     * 合并数组
     * 146 237  1 2 3
     * @param array
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private static int merge(int[] array, int l, int mid, int r) {
        int count=0;
        int p=l;
        int q=mid+1;
        int a=l;
        int b=mid+1;
        int c=0;
        int[] h=new int[r-l+1];
        try {
            for ( p = l; p <=mid ; p++) {
                while ( q<=r&&array[p]>array[q]*2 ){
                    q++;
                }
                count+=q-mid-1;
            }
        }catch (Exception e){
            System.out.println(p+":"+q);
        }
        while (a<=mid&&b<=r){
            h[c++]=array[a]>array[b]?array[b++]:array[a++];
        }
        while (a<=mid){
            h[c++]=array[a++];
        }
        while (b<=r){
            h[c++]=array[b++];
        }
        for (int i = 0; i < h.length; i++) {
            array[i+l]=h[i];

        }
        return count;
    }

    public static void main(String[] args) {
        int[] a=new int[]{5,3,1,7,5,8,3};
        System.out.println(count(a));
    }
}

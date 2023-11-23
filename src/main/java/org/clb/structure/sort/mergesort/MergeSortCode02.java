package org.clb.structure.sort.mergesort;

/**
 * @Description 求数组中的逆序对的个数 和之前的反一反
 * 从右往左拷贝
 * @Classname MergeSortCode01
 * @Date 2021/5/13 4:06
 * @Author clb
 */
public class MergeSortCode02 {
    public static int count(int[] array){
        if (array==null||array.length<2) return 0;

        return reserverCount(array,0,array.length-1);
    }
    public static int reserverCount(int[] array,int l,int r){
        if (l==r) return 0;
        int mid=l+((r-l)>>1);
        return reserverCount(array,l,mid)+reserverCount(array,mid+1,r)+merge(array,l,mid,r);
    }

    /**
     * 对两个数组进行合并
     * 357 567   535677   2
     * @param array
     * @param l
     * @param mid
     * @param r
     * @return
     */
    private static int merge(int[] array, int l, int mid, int r) {
        int[] h=new int[r-l+1];//{3,2}
        int count=0;
        int p=r;//右数组 p=1
        int q=mid;//左数组 mid=0
        int a=r-l;//1
        while (p>=mid+1&&q>=l){//1>=1 0>=0
            count+=array[q]>array[p]?p-mid:0;//1
            h[a--]=array[q]>=array[p]?array[q--]:array[p--];//h[1]=
        }

        while (p>=mid+1){
            h[a--]=array[p--];
        }
        while (q>=l){
            h[a--]=array[q--];
        }
        for (int i = 0; i <h.length; i++) {
            array[l+i]=h[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a=new int[]{3,2,1,5,4,2};
        System.out.println(count(a));
    }

}

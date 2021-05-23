package org.clb.structure.sort.mergesort;

/** ��С��
 * ���� 2 3 3 6 5  ��Ϊ 2*4 +3*2+3*2
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
     * �ݹ���С��
     * @param array
     * @param l ���±�
     * @param r ���±�
     * @return
     */
    private static int process(int[] array, int l, int r) {
        if (l==r){
            return 0;
        }
        int mid=l+((r-l)>>1);
        //С�͵�����ߵ�С�ͼ����ұߵ�С�ͼ��Ϻϲ������в�����С��
        return process(array,l,mid) +process(array,mid+1,r) +merge(array,l,mid,r);

    }

    /**
     * ��Ϊ��������  ֻ�е���������С���������ݵ�ʱ�����С��
     * 1357 2458 �����ʱҪ�����ұߵ��±�
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
        int a=0;//h���±�
        int p=l;//���±� 0
        int q=mid+1;//���±� 4
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

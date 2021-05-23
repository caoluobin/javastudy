package org.clb.structure.binary_tree.complete_binary_tree.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Descriptionc ����߶��غ����⣨�öѵ�ʵ�֣� �����ܶ��߶� ÿ���߶�����������start��end����
 * �涨:1).�߶εĿ�ʼ�ͽ���λ��һ����������ֵ
 * 2).�߶��غ�����ĳ��ȱ���>=1 �󣺷����߶��غ���������У������˼����߶�
 * @Classname HeapCode03
 * @Date 2021/5/23 16:15
 * @Author clb
 */
public class HeapCode03 {

    static class Line {

        public int start;
        public int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    //�Զ���Ƚ�������Line������
    static class LineCompare implements Comparator<Line> {

        //��Line��start��������
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }

    public static int getResult(int[][] a) {
        int max = 0;
        //����Line���鲢���Զ���LineCompare��start��������
        Line[] lines=new Line[a.length];
        for (int i = 0; i < a.length; i++) {
            lines[i]=new Line(a[i][0],a[i][1]);
        }
        Arrays.sort(lines,new LineCompare());
        //��С���Ѵ�Ž�β��ֵ ���С�ڵ�ǰline��endֵ���Ƴ� С�����е���������Ϊ��ǰ�߶εĸ���
        PriorityQueue<Integer> heap=new PriorityQueue<>();//Ĭ��С����
//        PriorityQueue<Integer> heap2=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });//�����
        int index=0;
        while (index<lines.length){
            //�����е�ͷ������ݱȵ�ǰ�ڵ�start����Сʱ ����
            while (heap.peek()<=lines[index].start){
                heap.poll();//����Сֵ
            }
            heap.add(lines[index].end);
            max=Math.max(max,heap.size());
        }
        return max;
    }
}

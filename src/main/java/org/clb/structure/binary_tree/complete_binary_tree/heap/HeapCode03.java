package org.clb.structure.binary_tree.complete_binary_tree.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Descriptionc 最大线段重合问题（用堆的实现） 给定很多线段 每个线段有两个数【start，end】，
 * 规定:1).线段的开始和结束位置一定都是整数值
 * 2).线段重合区域的长度必须>=1 求：返回线段重合最多区域中，包含了几条线段
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
    //自定义比较器用于Line的排序
    static class LineCompare implements Comparator<Line> {

        //将Line按start升序排列
        public int compare(Line o1, Line o2) {
            return o1.start - o2.start;
        }
    }

    public static int getResult(int[][] a) {
        int max = 0;
        //生成Line数组并以自定义LineCompare按start升序排列
        Line[] lines=new Line[a.length];
        for (int i = 0; i < a.length; i++) {
            lines[i]=new Line(a[i][0],a[i][1]);
        }
        Arrays.sort(lines,new LineCompare());
        //用小根堆存放结尾数值 如果小于当前line的end值则移除 小根堆中的数据量就为当前线段的个数
        PriorityQueue<Integer> heap=new PriorityQueue<>();//默认小根堆
//        PriorityQueue<Integer> heap2=new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        });//大根堆
        int index=0;
        while (index<lines.length){
            //当堆中的头结点数据比当前节点start数据小时 弹出
            while (heap.peek()<=lines[index].start){
                heap.poll();//弹出小值
            }
            //将当前值放入
            heap.add(lines[index].end);
            max=Math.max(max,heap.size());
        }
        return max;
    }
}

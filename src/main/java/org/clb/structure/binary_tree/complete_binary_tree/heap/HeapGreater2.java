package org.clb.structure.binary_tree.complete_binary_tree.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Description ��ǿ�ѣ��Զ�������뷴��������ʹ�ÿ���ͨ��ֵ�ҵ��±��λ��
 * ��Ի������ͽ��а�һ��
 * @Classname HeapGreater
 * @Date 2021/5/23 21:41
 * @Author clb
 */

public class HeapGreater2<T> {
    //�����ڲ��� ���⵱T�ǻ�������ʱ��HashMap�б����ǣ�ʹ��ÿ��ֵ���ж�һ�޶����ڴ�ֵ
    class Inner<T>{
        public T value;

        public Inner(T value) {
            this.value = value;
        }
    }
    private ArrayList<Inner<T>> heap;
    //���������� ��¼�˶�Ӧ������±�
    private HashMap<Inner<T>,Integer> indexMap;
    //�Ѵ�С
    private int heapSize;
    private Comparator<? super Inner<T>> comp;

    public Inner<T> getInner(T obj){
        return new Inner<T>(obj);
    }
    public HeapGreater2(Comparator<? super Inner<T>> comp) {
        this.heap=new ArrayList<>();
        this.indexMap=new HashMap<>();
        heapSize=0;
        this.comp = comp;
    }
    public boolean isEmpty(){
        return heapSize==0;
    }
    public int size(){
        return heapSize;
    }
    public boolean contains(Inner<T> obj){
        return indexMap.containsKey(obj);
    }
    public Inner<T> peek(){
        return heap.get(0);
    }
    public void push(Inner<T>  t){
//        heap.add();
    }
    public Inner<T> pop(){
        Inner<T> ans= heap.get(0);
        swap(0,heapSize-1);
        indexMap.remove(ans);
        return ans;
    }

    private void swap(int index, int last) {

    }



}

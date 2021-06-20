package org.clb.structure.binary_tree.complete_binary_tree.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Description ��ǿ�ѣ��Զ�������뷴��������ʹ�ÿ���ͨ��ֵ�ҵ��±��λ��
 * T�����ǻ�������
 * @Classname HeapGreater
 * @Date 2021/5/23 21:41
 * @Author clb
 */

public class HeapGreater<T> {
    //�����ڲ��� ���⵱T�ǻ�������ʱ��HashMap�б����ǣ�ʹ��ÿ��ֵ���ж�һ�޶����ڴ�ֵ
    private ArrayList<T> heap;
    //���������� ��¼�˶�Ӧ������±�
    private HashMap<T,Integer> indexMap;
    //�Ѵ�С
    private int heapSize;
    private Comparator<? super T> comp;

    public HeapGreater(Comparator<? super T> comp) {
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
    public boolean contains(T obj){
        return indexMap.containsKey(obj);
    }
    public T peek(){
        return heap.get(0);
    }
    public void push(T  t){
        heap.add(t);
        indexMap.put(t,heapSize);
        heapSize++;
    }
    public T pop(){
        T ans= heap.get(0);
        swap(0,heapSize-1);//ͷβ�ڵ㽻��λ��
        indexMap.remove(--heapSize);
        heapify(0);
        return ans;
    }
    private void heapInsert(int index){
        while (comp.compare(heap.get(index),heap.get((index-1)/2))<0){
            swap(index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    //��obj����������
    private void resign(T obj){
        heapInsert(indexMap.get(obj));//���ϱȽ�����
        heapify(indexMap.get(obj));//���±Ƚ�����
    }

    private void heapify(int index) {

    }
    public void remove(T obj){
        T replace=heap.get(heapSize-1);
        int index=indexMap.get(obj);
        indexMap.remove(obj);
        heap.remove(--heapSize);
        if (obj!=replace){
            heap.set(index,replace);
            indexMap.put(replace,index);
            resign(replace);
        }
    }

    private void swap(int index, int last) {
        T o1 = heap.get(index);
        T o2 = heap.get(last);
        heap.set(index,o2);
        heap.set(last,o1);
        indexMap.put(o1,last);
        indexMap.put(o2,index);
    }



}

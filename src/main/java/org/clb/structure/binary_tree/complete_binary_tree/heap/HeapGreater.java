package org.clb.structure.binary_tree.complete_binary_tree.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Description 加强堆，对堆数组加入反向索引，使得可以通过值找到下标的位置
 * T不能是基础类型
 * @Classname HeapGreater
 * @Date 2021/5/23 21:41
 * @Author clb
 */

public class HeapGreater<T> {
    //定义内部类 避免当T是基础类型时在HashMap中被覆盖，使得每个值都有独一无二的内存值
    private ArrayList<T> heap;
    //反向索引表 记录了对应对象的下标
    private HashMap<T,Integer> indexMap;
    //堆大小
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
        swap(0,heapSize-1);//头尾节点交换位置
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
    //对obj进行重排序
    private void resign(T obj){
        heapInsert(indexMap.get(obj));//向上比较排序
        heapify(indexMap.get(obj));//向下比较排序
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

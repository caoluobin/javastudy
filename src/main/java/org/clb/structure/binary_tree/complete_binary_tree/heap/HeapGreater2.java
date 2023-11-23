package org.clb.structure.binary_tree.complete_binary_tree.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @Description 加强堆，对堆数组加入反向索引，使得可以通过值找到下标的位置
 * 针对基础类型进行包一层
 * @Classname HeapGreater
 * @Date 2021/5/23 21:41
 * @Author clb
 */

public class HeapGreater2<T> {
    //定义内部类 避免当T是基础类型时在HashMap中被覆盖，使得每个值都有独一无二的内存值
    class Inner<T>{
        public T value;

        public Inner(T value) {
            this.value = value;
        }
    }
    private ArrayList<Inner<T>> heap;
    //反向索引表 记录了对应对象的下标
    private HashMap<Inner<T>,Integer> indexMap;
    //堆大小
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

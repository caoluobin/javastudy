package org.clb.LeetCode.code1_10;

import org.clb.util.date.A;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ������Ʋ�ʵ��һ������  LRU (�������ʹ��) ���� Լ�������ݽṹ��
 * ʵ�� LRUCache �ࣺ
 * LRUCache(int capacity) �� ������ ��Ϊ���� capacity ��ʼ�� LRU ����
 * int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
 * void put(int key, int value) ����ؼ��� key �Ѿ����ڣ�����������ֵ value ����������ڣ����򻺴��в������ key-value ���������������¹ؼ����������� capacity ����Ӧ�� ��� ���δʹ�õĹؼ��֡�
 * ���� get �� put ������ O(1) ��ƽ��ʱ�临�Ӷ����С�
 */
public class Code_146 {


    public Map<Integer,Integer> map = new LinkedHashMap<>();
    public Integer capacity;
    public Code_146(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else if (map.size()>=capacity){
            Iterator<Integer> iterator = map.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        map.put(key,value);
    }

    public static void main(String[] args) {
        Map<Integer,Integer>  map = new LinkedHashMap<>();
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        Integer next = map.keySet().iterator().next();
        System.out.println(next);
    }
}

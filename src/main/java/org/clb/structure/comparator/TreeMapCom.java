package org.clb.structure.comparator;

import java.util.TreeMap;

/**
 * @Description
 * @Classname TreeMapCom
 * @Date 2021/5/22 17:44
 * @Author clb
 */
public class TreeMapCom {

    public static void main(String[] args) {
        //�����Լ������ıȽ����Ժ� ���������ڱȽ���������ȵ����ݾͲ������
        TreeMap<Student,String> map=new TreeMap<>(new StudengCom());
        map.put(new Student(1,2),"ѧ��1");
        map.put(new Student(2,20),"ѧ��1");
        map.put(new Student(3,12),"ѧ��1");
        map.put(new Student(4,33),"ѧ��1");
        map.put(new Student(5,20),"ѧ��1");
        for (Student s:map.keySet()) {
            System.out.println(s);
        }
    }
}

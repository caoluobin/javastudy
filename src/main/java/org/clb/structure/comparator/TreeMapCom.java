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
        //传入自己创建的比较器以后 如果放入对于比较器而言相等的数据就不会插入
        TreeMap<Student,String> map=new TreeMap<>(new StudengCom());
        map.put(new Student(1,2),"学生1");
        map.put(new Student(2,20),"学生1");
        map.put(new Student(3,12),"学生1");
        map.put(new Student(4,33),"学生1");
        map.put(new Student(5,20),"学生1");
        for (Student s:map.keySet()) {
            System.out.println(s);
        }
    }
}

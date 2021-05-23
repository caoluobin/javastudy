package org.clb.structure.comparator;

import java.util.Comparator;

/**
 * @Description �Ƚ���
 * compare �������ѭͳһ�淶
 * ���ظ�����ʱ�򣬵�һ��������ǰ��
 * ����������ʱ�򣬵ڶ���������ǰ��
 * ����0��ʱ�� ����ν
 * @Classname StudengCom
 * @Date 2021/5/21 0:01
 * @Author clb
 */
public class  StudengCom implements Comparator<Student> {


    //��age���� ���age��ͬ��id��������
    @Override
    public int compare(Student o1, Student o2) {
//        if (o1.age<o2.age){
//            return -1;
//        }else if (o1.age>o2.age){
//            return 1;
//        }else {
//            return 0;
//        }
        return o1.age!=o2.age?o1.age-o2.age:o1.id-o2.id;
    }
}

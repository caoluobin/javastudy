package org.clb.structure.comparator;

import java.util.Comparator;

/**
 * @Description 比较器
 * compare 方法里，遵循统一规范
 * 返回负数的时候，第一个参数排前面
 * 返回正数的时候，第二个参数排前面
 * 返回0的时候 无所谓
 * @Classname StudengCom
 * @Date 2021/5/21 0:01
 * @Author clb
 */
public class  StudengCom implements Comparator<Student> {


    //按age升序 如果age相同则按id升序排序
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

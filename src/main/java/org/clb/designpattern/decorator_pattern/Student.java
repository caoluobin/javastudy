package org.clb.designpattern.decorator_pattern;

import lombok.AllArgsConstructor;

/**
 * @Description
 * @Classname Student
 * @Date 2021/5/21 14:19
 * @Author clb
 */
public class Student implements Stu,Cloneable {
    String name;
    String clothes="空气";
    String a = "cccasfagajwoprqwporqpworiqpw j alksjaljdfalksjflkajwrriq i j jaljfalksfla2 g";
    String b = "cccasfagajwoprqwporqpworiqpw j alksjaljdfalksjflkajwrriq i j jaljfalksfla2s";
    String v = "cccasfagajwoprqwporqpworiqpw j alksjaljdfalksjflkajwrriq i j jaljfalksfla2 t";
    String s = "cccasfagajwoprqwporqpworiqpw j alksjaljdfalksjflkajwrriq i j jaljfalksfla2 s";
    String d = "cccasfagajwoprqwporqpworiqpw j alksjaljdfalksjflkajwrriq i j jaljfalksfla2 nn";
    String e = "cccasfagajwoprqwporqpworiqpw j alksjaljdfalksjflkajwrriq i j jaljfalksfla2 354235";


    public Student(String name, String clothes) {
        Integer count= 0 ;
        for (int i = 0; i < 1000; i++) {
            count++;
        }
        this.name = name;
        this.clothes = clothes;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        return (Student)super.clone();
    }

    @Override
    public String toString() {
        return "我叫'" + name + '\'' + ", 是一个穿了'" + clothes + '\'' + "的学生";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    @Override
    public void dress() {
        this.setClothes("空气");
    }
}

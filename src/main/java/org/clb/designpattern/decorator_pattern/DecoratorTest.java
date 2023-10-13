package org.clb.designpattern.decorator_pattern;

/**
 * @Description
 * @Classname DecoratorTest
 * @Date 2021/5/21 14:28
 * @Author clb
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Student stu=new Student("ccc","ddd");
        stu.setName("hapi");
        StudentDeCorator stu2=new StudentDressDecorator(stu);
         stu2.dress();
        System.out.println(stu);
    }

}

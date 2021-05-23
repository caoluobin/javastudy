package org.clb.designpattern.composite_pattern;

/**
 * @Description
 * @Classname ComTest
 * @Date 2021/5/21 16:51
 * @Author clb
 */
public class ComTest {

    public static void main(String[] args) {
        Component composite=new Composite();
        Component component1=new Composite();
        component1.add(new Leaf("�ڵ�1-1"));
        component1.add(new Leaf("�ڵ�1-2"));
        component1.add(new Leaf("�ڵ�1-3"));
        Component component2=new Composite();
        Component composite21 = new Composite();
        composite21.add(new Leaf("�ڵ�2-1-1"));
        composite21.add(new Leaf("�ڵ�2-1-2"));
        composite21.add(new Leaf("�ڵ�2-1-3"));
        component2.add(composite21);
        composite.add(component1);
        composite.add(component2);
        composite.operation();
    }

}

package org.clb.designpattern.mediator_pattern;

/**
 * @Description
 * @Classname TestMdediator
 * @Date 2021/6/2 11:47
 * @Author clb
 */
public class TestMdediator {

    public static void main(String[] args) {
        Mediator me=new Mediator();
        Colleague c1=new Colleague("1��");
        Colleague c2=new Colleague("2��");
        me.register(c1);
        me.register(c2);
        c1.send("2��ɵ��");
    }
}

package org.clb.designpattern.observer_pattern;

/**
 * @Description
 * @Classname Observer1
 * @Date 2021/5/24 11:54
 * @Author clb
 */
public class Observer1 implements Observer{


    @Override
    public void response() {
        System.out.println("第一个观察者被调用了");
    }
}

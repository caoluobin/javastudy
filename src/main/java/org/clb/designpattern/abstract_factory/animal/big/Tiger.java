package org.clb.designpattern.abstract_factory.animal.big;

/**
 * @Description
 * @Classname Tiger
 * @Date 2021/6/10 15:50
 * @Author clb
 */
public class Tiger extends BigAnimal {

    @Override public void getName() {
        System.out.println("老虎");
    }
}

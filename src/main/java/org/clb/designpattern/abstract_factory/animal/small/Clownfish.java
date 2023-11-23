package org.clb.designpattern.abstract_factory.animal.small;

/**
 * @Description
 * @Classname Clownfish
 * @Date 2021/6/10 15:51
 * @Author clb
 */
public class Clownfish extends SmallAnimal {

    @Override public void getName() {
        System.out.println("小丑鱼");
    }
}

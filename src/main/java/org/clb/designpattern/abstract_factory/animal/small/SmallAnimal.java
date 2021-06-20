package org.clb.designpattern.abstract_factory.animal.small;

import org.clb.designpattern.abstract_factory.animal.Animal;

/**
 * @Description
 * @Classname SmallAnimal
 * @Date 2021/6/10 16:20
 * @Author clb
 */
public abstract class SmallAnimal implements Animal {

    @Override public void shape() {
        System.out.println("С�Ͷ���");
    }
}

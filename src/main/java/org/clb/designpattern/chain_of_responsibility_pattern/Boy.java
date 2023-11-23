package org.clb.designpattern.chain_of_responsibility_pattern;

/**
 * @Description
 * @Classname Boy
 * @Date 2021/5/24 15:25
 * @Author clb
 */
public class Boy {
    public String shape;
    public String name;

    public Boy(String shape, String name) {
        this.shape = shape;
        this.name = name;
    }

    @Override
    public String toString() {
        String a=name+"被打成了"+shape;
        return a;
    }
}

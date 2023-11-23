package org.clb.designpattern.composite_pattern;

/**
 * @Description 子节点
 * @Classname leaf
 * @Date 2021/5/21 16:37
 * @Author clb
 */
public class Leaf implements Component{
    String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public boolean hasnext() {
        return false;
    }

    @Override
    public void add(Component component) {

    }

    @Override
    public void operation() {
        System.out.println(name);
    }
}

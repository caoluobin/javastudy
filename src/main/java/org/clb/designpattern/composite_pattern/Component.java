package org.clb.designpattern.composite_pattern;

import org.clb.designpattern.decorator_pattern.Student;

/**
 * @Description 组合模式接口
 * @Classname component
 * @Date 2021/5/21 16:31
 * @Author clb
 */
public interface Component extends C<Component>{
    public boolean hasnext();
    public void add(Component component);
    public void operation();

}

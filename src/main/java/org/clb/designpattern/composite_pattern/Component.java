package org.clb.designpattern.composite_pattern;

import org.clb.designpattern.decorator_pattern.Student;

/**
 * @Description ���ģʽ�ӿ�
 * @Classname component
 * @Date 2021/5/21 16:31
 * @Author clb
 */
public interface Component extends C<Component>{
    public boolean hasnext();
    public void add(Component component);
    public void operation();

}

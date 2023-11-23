package org.clb.designpattern.state_pattern;

/**
 * @Description
 * @Classname OpenState
 * @Date 2021/5/28 8:53
 * @Author clb
 */
public class CloseState extends State{

    @Override
    public void open() {
        super.myContext.setState(MyContext.openState);
        super.myContext.getState().open();
    }

    @Override
    public void close() {
        System.out.println("关门");
    }
}

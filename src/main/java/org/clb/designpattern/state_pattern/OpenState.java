package org.clb.designpattern.state_pattern;

/**
 * @Description
 * @Classname OpenState
 * @Date 2021/5/28 8:53
 * @Author clb
 */
public class OpenState extends State{

    @Override
    public void open() {
        System.out.println("开门");
    }

    @Override
    public void close() {
        super.myContext.setState(MyContext.closeState);
        super.myContext.getState().close();
    }
}

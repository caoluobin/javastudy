package org.clb.designpattern.mediator_pattern;

/**
 * @Description
 * @Classname Colleague
 * @Date 2021/6/2 11:39
 * @Author clb
 */
public class Colleague extends AbstractColleague {
    public String name;

    public Colleague(String name) {
        this.name = name;
    }

    @Override
    public void send(String msg) {
        this.msg=msg;
        this.mediator.relay(this);
    }

    @Override
    public void receive(Colleague current) {
        System.out.println(name+"接收到"+current.name+"的信息："+current.msg);
    }
}

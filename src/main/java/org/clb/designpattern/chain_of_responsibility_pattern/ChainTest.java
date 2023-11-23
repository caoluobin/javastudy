package org.clb.designpattern.chain_of_responsibility_pattern;

/**
 * @Description
 * @Classname ChainTest
 * @Date 2021/5/24 15:31
 * @Author clb
 */
public class ChainTest {

    public static void main(String[] args) {
        Handler father=new Father();
        father.setNext(new Mother());
        Boy boy=new Boy("","小明");
        father.handler(boy);
    }

}

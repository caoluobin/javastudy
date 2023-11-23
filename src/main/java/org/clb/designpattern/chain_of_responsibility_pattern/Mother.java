package org.clb.designpattern.chain_of_responsibility_pattern;

/**
 * @Description
 * @Classname Mother
 * @Date 2021/5/24 15:30
 * @Author clb
 */
public class Mother extends Handler {

    public void handler(Boy b) {
        b.shape="傻子";
        System.out.println("母亲一顿胖揍"+b);
        if (this.getNext()!=null){
            this.getNext().handler(b);
        }
    }
}

package org.clb.designpattern.chain_of_responsibility_pattern;

/**
 * @Description
 * @Classname Father
 * @Date 2021/5/24 15:28
 * @Author clb
 */
public class Father  extends Handler{

    @Override
    public void handler(Boy b) {
        b.shape="球";
        System.out.println("父亲一顿胖揍"+b);
        if (this.getNext()!=null){
            this.getNext().handler(b);
        }
    }
}

package org.clb.designpattern.visitor_pattren.visitor1;

/**
 * @Description
 * @Classname Visitor
 * @Date 2021/5/24 16:28
 * @Author clb
 */
public class VisitorA implements Visitor {
    public void visitA(ShopA a){
        System.out.println("visitA访问了a");
        a.operate();
    };
    public void visitB(ShopB b){
        b.operate();
    }

}

package org.clb.designpattern.visitor_pattren.visitor1;

/**
 * @Description
 * @Classname ShopA
 * @Date 2021/5/24 21:44
 * @Author clb
 */
public class ShopA {
    public void operate(){
        System.out.println("shopAִ��");
    }
    public void accept(VisitorA a){
        System.out.println("ShopA��a����");
        a.visitA(this);
    }
}

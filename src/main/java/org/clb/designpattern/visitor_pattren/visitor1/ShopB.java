package org.clb.designpattern.visitor_pattren.visitor1;

import java.util.concurrent.ScheduledExecutorService;

/**
 * @Description
 * @Classname ShopA
 * @Date 2021/5/24 21:44
 * @Author clb
 */
public class ShopB {
    public void operate(){
        System.out.println("shopB执行");

    }
    public void accept(VisitorB b){
        b.visitB(this);
    }
}


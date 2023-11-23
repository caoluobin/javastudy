package org.clb.designpattern.visitor_pattren.visitor2;

public class ConsumerVisitor implements Visitor{
    @Override
    public void visit(Shop shop) {//消费者  经销商
        System.out.println("消费者购买"+shop.getProduct());
    }

    @Override
    public void visit(FruitShop shop) {
        System.out.println("消费者购买水果A");
    }
}

package org.clb.designpattern.visitor_pattren.visitor2;

public class DealerVisitor implements Visitor{
    @Override
    public void visit(Shop shop) {
        System.out.println("经销商进货"+shop.getProduct());
    }

    @Override
    public void visit(FruitShop shop) {
        System.out.println("经销商给水果店进货");
    }
}

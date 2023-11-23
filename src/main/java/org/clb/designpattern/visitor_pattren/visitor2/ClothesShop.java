package org.clb.designpattern.visitor_pattren.visitor2;

public class ClothesShop implements Shop{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getProduct() {
        return "衣服";
    }
}

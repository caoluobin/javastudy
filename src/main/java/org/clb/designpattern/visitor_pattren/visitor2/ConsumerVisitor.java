package org.clb.designpattern.visitor_pattren.visitor2;

public class ConsumerVisitor implements Visitor{
    @Override
    public void visit(Shop shop) {//������  ������
        System.out.println("�����߹���"+shop.getProduct());
    }

    @Override
    public void visit(FruitShop shop) {
        System.out.println("�����߹���ˮ��A");
    }
}

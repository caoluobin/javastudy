package org.clb.designpattern.brige_pattern;

/**
 * @Description
 * @Classname HouseProduct
 * @Date 2021/5/17 15:58
 * @Author clb
 */
public class HouseProduct implements Product{//�ӿھ���ʵ��

  @Override
  public void selled() {
    System.out.println("���˷���");
  }

  @Override
  public void producted() {
    System.out.println("��������");
  }
}

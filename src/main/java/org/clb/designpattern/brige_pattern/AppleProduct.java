package org.clb.designpattern.brige_pattern;

/**
 * @Description
 * @Classname HouseProduct
 * @Date 2021/5/17 15:58
 * @Author clb
 */
public class AppleProduct implements Product{//�ӿھ���ʵ��

  @Override
  public void selled() {
    System.out.println("����ƻ��");
  }

  @Override
  public void producted() {
    System.out.println("����ƻ��");
  }
}

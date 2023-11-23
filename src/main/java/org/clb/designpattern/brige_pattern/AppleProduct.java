package org.clb.designpattern.brige_pattern;

/**
 * @Description
 * @Classname HouseProduct
 * @Date 2021/5/17 15:58
 * @Author clb
 */
public class AppleProduct implements Product{//接口具体实现

  @Override
  public void selled() {
    System.out.println("卖了苹果");
  }

  @Override
  public void producted() {
    System.out.println("生产苹果");
  }
}

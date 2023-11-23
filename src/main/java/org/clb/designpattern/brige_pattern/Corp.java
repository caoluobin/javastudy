package org.clb.designpattern.brige_pattern;

/**
 * @Description
 * @Classname Corp
 * @Date 2021/5/18 14:03
 * @Author clb
 */
public abstract class Corp {//抽象类
  protected Product product;

  public Corp() {
  }

  public Corp(Product product) {//调用接口
    this.product = product;
  }
  public abstract void make();//抽象方法由子类具体实现
}

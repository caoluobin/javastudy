package org.clb.designpattern.brige_pattern;

/**
 * @Description
 * @Classname Corp
 * @Date 2021/5/18 14:03
 * @Author clb
 */
public abstract class Corp {//������
  protected Product product;

  public Corp() {
  }

  public Corp(Product product) {//���ýӿ�
    this.product = product;
  }
  public abstract void make();//���󷽷����������ʵ��
}

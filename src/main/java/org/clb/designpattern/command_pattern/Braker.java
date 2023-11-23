package org.clb.designpattern.command_pattern;

import java.util.LinkedList;
import java.util.List;
import org.clb.designpattern.command_pattern.oreder.Order;

/**
 * @Description 接受并执行命令
 * @Classname Braker
 * @Date 2021/5/18 14:48
 * @Author clb
 */
public class Braker {
  public List<Order> orderList=new LinkedList<>();
  public void addOrder(Order order){
    orderList.add(order);
  }
  public void executeOrders(){
    for (Order o :
        orderList) {
      o.execute();
    }
    orderList.clear();
  }
}

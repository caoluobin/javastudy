package org.clb.designpattern.observer_pattern;

/**
 * @Description
 * @Classname ConcretObserverLsit
 * @Date 2021/5/24 11:52
 * @Author clb
 */
public class ConcretObserverList extends OberverList {

    @Override
    public void notifyAllObserver() {
        System.out.println("开始执行");
        for (int i = 0; i < list.size(); i++) {
            list.get(i).response();
        }
    }
}

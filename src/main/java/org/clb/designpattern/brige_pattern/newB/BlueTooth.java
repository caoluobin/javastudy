package org.clb.designpattern.brige_pattern.newB;

public class BlueTooth implements Connect{
    @Override
    public void con() {
        System.out.println("蓝牙连接");
    }
}

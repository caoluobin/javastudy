package org.clb.designpattern.decorator_pattern.example1;

public class GunTest {
    public static void main(String[] args) {
        Gun gun=new Ak47();
        gun.fire();
        FourMirror fourMirror=new FourMirror(gun,"�ı���");
        fourMirror.aim();
        fourMirror.fire();
    }
}

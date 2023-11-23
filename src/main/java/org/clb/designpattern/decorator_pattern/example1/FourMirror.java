package org.clb.designpattern.decorator_pattern.example1;

import lombok.Data;


public class FourMirror extends Mirror{
    public FourMirror(Gun gun, String mirrorName) {
        super(gun, mirrorName);
    }

    @Override
    public void aim() {
        System.out.println(this.getMirrorName()+"进入瞄准模式");
    }
}

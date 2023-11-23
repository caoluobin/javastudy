package org.clb.designpattern.decorator_pattern.example1;

import lombok.Data;

@Data
public abstract class Mirror implements Gun{
    private Gun gun;
    private String mirrorName;

    public Mirror(Gun gun, String mirrorName) {
        this.gun = gun;
        this.mirrorName = mirrorName;
    }
    public abstract void aim();

    @Override
    public void fire() {//弹夹
        gun.fire();
    }
}

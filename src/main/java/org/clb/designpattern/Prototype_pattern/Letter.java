package org.clb.designpattern.Prototype_pattern;

import lombok.AllArgsConstructor;

/**
 * @Description
 * @Classname Letter
 * @Date 2021/5/31 15:40
 * @Author clb
 */
@AllArgsConstructor
public class Letter implements Cloneable{
    String  msg;
    String toUser;
    Stamp stamp;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public Letter(String msg, String toUser) {
        this.msg = msg;
        this.toUser = toUser;
    }

    public String getMsg() {
        return msg;
    }

    public String getToUser() {
        return toUser;
    }

    public Stamp getStamp() {
        return stamp;
    }

    public void setStamp(Stamp stamp) {
        this.stamp = stamp;
    }

    @Override
    protected Letter clone() throws CloneNotSupportedException {
        Letter letter= (Letter)super.clone();
        letter.setStamp((Stamp)letter.getStamp().clone());
        return letter;
    }
    public void show(){
        System.out.println("发送"+msg);
    }
}

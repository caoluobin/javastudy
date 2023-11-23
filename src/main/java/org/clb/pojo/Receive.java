package org.clb.pojo;


/**
 * @Description
 * @Classname Receive
 * @Date 2021/7/2 15:54
 * @Author clb
 */
public class Receive {
    String title;
    //申报号
    String pid;
    String createTime;
    String type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Receive(String title, String pid, String createTime, String type) {
        this.title = title;
        this.pid = pid;
        this.createTime = createTime;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Receive{" + "title='" + title + '\'' + ", pid='" + pid + '\'' + ", createTime='" + createTime + '\'' + ", type='" + type + '\'' + '}';
    }
}

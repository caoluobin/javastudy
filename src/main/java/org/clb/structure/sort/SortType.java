package org.clb.structure.sort;

/**
 * @Description
 * @Classname SortType
 * @Date 2021/6/30 15:34
 * @Author clb
 */
public enum SortType {
    ASC(1,"升序"),
    DESC(2,"降序");
    Integer type;
    String name;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private SortType(Integer type, String name) {
        this.type = type;
        this.name = name;
    }
}

package org.clb.designpattern.facade_pattern;

/**
 * @Description 简历
 * @Classname CurriculumVitae
 * @Date 2021/6/10 17:25
 * @Author clb
 */
public class CurriculumVitae {
    String name;
    private Integer level;

    public CurriculumVitae(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    public CurriculumVitae(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}

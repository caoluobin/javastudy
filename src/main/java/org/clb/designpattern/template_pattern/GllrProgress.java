package org.clb.designpattern.template_pattern;

/**
 * @Description
 * @Classname GllrProgress
 * @Date 2021/7/13 11:28
 * @Author clb
 */
public class GllrProgress extends Progress{
    @Override
    public int getStatus(String pkid, String type) {
        //sql 查询
        return 0;
    }

    @Override
    public int returnProgress(String pkid, String type) {
        return 0;
    }
}

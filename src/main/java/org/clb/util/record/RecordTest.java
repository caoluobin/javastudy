package org.clb.util.record;

import lombok.Data;

@Data
public class RecordTest {
    @RecordAnnotation(name = "手机号")
    private String phone;

    @RecordAnnotation(name = "性别")
    private String sex;

    public RecordTest(String phone, String sex) {
        this.phone = phone;
        this.sex = sex;
    }

}

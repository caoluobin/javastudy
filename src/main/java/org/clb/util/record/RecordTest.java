package org.clb.util.record;

import lombok.Data;

@Data
public class RecordTest {
    @RecordAnnotation(name = "�ֻ���")
    private String phone;

    @RecordAnnotation(name = "�Ա�")
    private String sex;

    public RecordTest(String phone, String sex) {
        this.phone = phone;
        this.sex = sex;
    }

}

package org.clb;


import java.text.ParseException;
import java.util.Map;

/**
 * @Description
 * @Classname Test222
 * @Date 2021/6/6 17:14
 * @Author clb
 */
public class Test222 {

    public static void main(String[] args) throws ParseException {
        String a = "man_cz_nurse_num VARCHAR(32) default 0 comment '���Գ�֤����Ա' ;" +
                "man_cz_nurse_num_yes VARCHAR(32) default 0 comment '���Գ�֤����Ա' ;" +
                "woman_cz_nurse_num VARCHAR(32) default 0 comment 'Ů�Գ�֤����Ա' ;" +
                "woman_cz_nurse_num_yes VARCHAR(32) default 0 comment 'Ů�Գ�֤����Ա' ;" +
                "cz_cz_nurse_num VARCHAR(32) default 0 comment '���г�֤����Ա��' ;" +
                "cz_cz_nurse_num_yes VARCHAR(32) default 0 comment '���г�֤����Ա��' ;" +
                "gz_cz_nurse_num VARCHAR(32) default 0 comment '���г�֤����Ա��' ;" +
                "gz_cz_nurse_num_yes VARCHAR(32) default 0 comment '���г�֤����Ա��' ;" +
                "zz_cz_nurse_num VARCHAR(32) default 0 comment '��ְ/��ר��֤����Ա' ;" +
                "zz_cz_nurse_num_yes VARCHAR(32) default 0 comment '��ְ/��ר��֤����Ա' ;" +
                "dz_cz_nurse_num VARCHAR(32) default 0 comment '��ר��֤����Ա��' ;" +
                "dz_cz_nurse_num_yes VARCHAR(32) default 0 comment '��ר��֤����Ա��' ;" +
                "bk_cz_nurse_num VARCHAR(32) default 0 comment '���Ƴ�֤����Ա��' ;" +
                "bk_cz_nurse_num_yes VARCHAR(32) default 0 comment '���Ƴ�֤����Ա��' ;" +
                "yjs_cz_nurse_num VARCHAR(32) default 0 comment '�о�����֤����Ա��' ;" +
                "yjs_cz_nurse_num_yes VARCHAR(32) default 0 comment '�о�����֤����Ա��' ;" +
                "less_thirty_cz_nurse_num VARCHAR(32) default 0 comment '30���³�֤����Ա��' ;" +
                "less_thirty_cz_nurse_num_yes VARCHAR(32) default 0 comment '30���³�֤����Ա��' ;" +
                "thirty_cz_nurse_num VARCHAR(32) default 0 comment '30-39���³�֤����Ա��' ;" +
                "thirty_cz_nurse_num_yes VARCHAR(32) default 0 comment '30-39���³�֤����Ա��' ;" +
                "forty_cz_nurse_num VARCHAR(32) default 0 comment '40-49���³�֤����Ա��' ;" +
                "forty_cz_nurse_num_yes VARCHAR(32) default 0 comment '40-49���³�֤����Ա��' ;" +
                "more_fifty_cz_nurse_num VARCHAR(32) default 0 comment '50���ϳ�֤����Ա��' ;" +
                "more_fifty_cz_nurse_num_yes VARCHAR(32) default 0 comment '50���ϳ�֤����Ա��' ;";
        String[] split = a.split(" VARCHAR");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                result.append(split[i] + ",");
            } else if (i < split.length - 1) {

                result.append(split[i].split(";")[1] + ",");
            }

        }
        System.out.println(result.toString());
        String[] split1 = result.toString().split(",");
        for (int i = 0; i < split1.length; i++) {
            System.out.print(split1[i] + "=?,");
        }

    }
    //        String year = datetime.substring(0,4);
    //        String month = datetime.substring(0,7);
    //        String date = datetime.substring(0,10);
    //        System.out.println(year);
    //        System.out.println(month);
    //        System.out.println(date);
    public static void a(Map<String, Object> map) {
        map.put("status", (Integer) map.get("status") + 1);
    }

}

package org.clb.util.sql;

public class GetSqlString {
    public static String get(int count) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++) {
            result.append(",?");
        }
        return result.toString();
    }

    public static String getUpdateSql(String alterSql, String type) {
        StringBuilder result = new StringBuilder();
        String[] split = alterSql.split(type);
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                result.append("," + split[i] + "=?");
            } else if (i < split.length - 1) {
                result.append("," + split[i].split(";")[1] + "=?");
            }
        }
        return result.toString();
    }

    public static String getInsertSql(String alterSql, String type) {
        StringBuilder result = new StringBuilder();
        String[] split = alterSql.split(type);
        for (int i = 0; i < split.length; i++) {
            if (i == 0) {
                result.append("," + split[i] + "");
            } else if (i < split.length - 1) {
                result.append("," + split[i].split(";")[1] + "");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String a = "man_nurse_num'男性护理员' ;" +
                "man_nurse_num_yes'男性护理员' ;" +
                "woman_nurse_num'女性护理员' ;" +
                "woman_nurse_num_yes'女性护理员' ;" +
                "cz_yl_nurse_num'初中护理员数' ;" +
                "cz_yl_nurse_num_yes'初中护理员数' ;" +
                "gz_nurse_num'高中护理员数' ;" +
                "gz_nurse_num_yes'高中护理员数' ;" +
                "zz_nurse_num'中职/中专护理员' ;" +
                "zz_nurse_num_yes'中职/中专护理员' ;" +
                "dz_nurse_num'大专护理员数' ;" +
                "dz_nurse_num_yes'大专护理员数' ;" +
                "bk_nurse_num'本科护理员数' ;" +
                "bk_nurse_num_yes'本科护理员数' ;" +
                "yjs_nurse_num'研究生护理员数' ;" +
                "yjs_nurse_num_yes'研究生护理员数' ;" +
                "less_thirty_nurse_num'30以下护理员数' ;" +
                "less_thirty_nurse_num_yes'30以下护理员数' ;" +
                "thirty_nurse_num'30-39以下护理员数' ;" +
                "thirty_nurse_num_yes'30-39以下护理员数' ;" +
                "forty_nurse_num'40-49以下护理员数' ;" +
                "forty_nurse_num_yes'40-49以下护理员数' ;" +
                "more_fifty_nurse_num'50以上护理员数' ;" +
                "more_fifty_nurse_num_yes'50以上护理员数' ;" +
                "nurse_num'养老护理员';" +
                "nurse_num_yes'养老护理员';";

        String[] split = a.split(";");
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            if (i % 2 == 0) {
                str.append(split[i] + "\n");
            }
        }

        System.out.println(str.toString());
//        System.out.println(getUpdateSql(a, "VARCHAR"));
//        System.out.println(getInsertSql(a, "VARCHAR"));
//        System.out.println(get(26));
    }
}

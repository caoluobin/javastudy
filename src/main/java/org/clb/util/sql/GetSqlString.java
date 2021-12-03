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
        String a = "man_nurse_num'���Ի���Ա' ;" +
                "man_nurse_num_yes'���Ի���Ա' ;" +
                "woman_nurse_num'Ů�Ի���Ա' ;" +
                "woman_nurse_num_yes'Ů�Ի���Ա' ;" +
                "cz_yl_nurse_num'���л���Ա��' ;" +
                "cz_yl_nurse_num_yes'���л���Ա��' ;" +
                "gz_nurse_num'���л���Ա��' ;" +
                "gz_nurse_num_yes'���л���Ա��' ;" +
                "zz_nurse_num'��ְ/��ר����Ա' ;" +
                "zz_nurse_num_yes'��ְ/��ר����Ա' ;" +
                "dz_nurse_num'��ר����Ա��' ;" +
                "dz_nurse_num_yes'��ר����Ա��' ;" +
                "bk_nurse_num'���ƻ���Ա��' ;" +
                "bk_nurse_num_yes'���ƻ���Ա��' ;" +
                "yjs_nurse_num'�о�������Ա��' ;" +
                "yjs_nurse_num_yes'�о�������Ա��' ;" +
                "less_thirty_nurse_num'30���»���Ա��' ;" +
                "less_thirty_nurse_num_yes'30���»���Ա��' ;" +
                "thirty_nurse_num'30-39���»���Ա��' ;" +
                "thirty_nurse_num_yes'30-39���»���Ա��' ;" +
                "forty_nurse_num'40-49���»���Ա��' ;" +
                "forty_nurse_num_yes'40-49���»���Ա��' ;" +
                "more_fifty_nurse_num'50���ϻ���Ա��' ;" +
                "more_fifty_nurse_num_yes'50���ϻ���Ա��' ;" +
                "nurse_num'���ϻ���Ա';" +
                "nurse_num_yes'���ϻ���Ա';";

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

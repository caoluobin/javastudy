package org.clb.LeetCode.code1_10;

/**
 * ������ʵ��һ�� myAtoi(string s) ������ʹ���ܽ��ַ���ת����һ�� 32 λ�з������������� C/C++ �е� atoi ��������
 * ���� myAtoi(string s) ���㷨���£�
 * �����ַ������������õ�ǰ���ո�
 * �����һ���ַ������軹δ���ַ�ĩβ��Ϊ�����Ǹ��ţ���ȡ���ַ�������У��� ȷ�����ս���Ǹ������������� ������߶������ڣ���ٶ����Ϊ����
 * ������һ���ַ���ֱ��������һ���������ַ��򵽴�����Ľ�β���ַ��������ಿ�ֽ������ԡ�
 * ��ǰ�沽��������Щ����ת��Ϊ����������"123" -> 123�� "0032" -> 32�������û�ж������֣�������Ϊ 0 ����Ҫʱ���ķ��ţ��Ӳ��� 2 ��ʼ����
 * ������������� 32 λ�з���������Χ [?231,  231 ? 1] ����Ҫ�ض����������ʹ�䱣���������Χ�ڡ�������˵��С�� ?231 ������Ӧ�ñ��̶�Ϊ ?231 ������ 231 ? 1 ������Ӧ�ñ��̶�Ϊ 231 ? 1 ��
 * ����������Ϊ���ս����
 */
public class Code_8 {
    public static void main(String[] args) {
        String a="-000012200-";
        System.out.println(Long.parseLong("0000"));
        System.out.println(new Code_8().myAtoi(a));
    }
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]==' ') {
                if (str.length()!=0) break;
                continue;
            }
            if (chars[i]=='-'||chars[i]=='+') {
                if(str.indexOf("-")!=-1||str.indexOf("+")!=-1||str.length()!=0) {
                    if (str.length()==1) {
                        str = new StringBuilder();
                    }
                    break;
                }
                str.append(chars[i]);
            }else if ((chars[i]>='0'&&chars[i]<='9')) {
                if (str.length()!=0&&str.charAt(0)=='0') {
                    str = new StringBuilder();
                }
                if (str.length()!=0&&(str.charAt(0)=='-'||str.charAt(0)=='+')&&chars[i]=='0'&&(str.length()==1||str.charAt(1)=='0')) {
                    continue;
                }
                str.append(chars[i]);
            }else {
                break;
            }

        }
        String res = str.toString();
        return res.length()==0||(res.length()==1&&(res.charAt(0)=='-'||res.charAt(0)=='+'))?0:res.length()>11?res.charAt(0)=='-'?Integer.MIN_VALUE:Integer.MAX_VALUE:Long.parseLong(res)>Integer.MAX_VALUE?Integer.MAX_VALUE:Long.parseLong(res)<Integer.MIN_VALUE?Integer.MIN_VALUE:Integer.parseInt(res);
    }

}

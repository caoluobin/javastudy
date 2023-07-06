package org.clb.LeetCode.HWCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
�� Unix ������һ���ļ��ľ���·��������Ҫ���������߻��仰˵������ת��Ϊ�淶·����

�� Unix �����ļ�ϵͳ�У�һ���㣨.����ʾ��ǰĿ¼�������⣬������ ��..�� ��ʾ��Ŀ¼�л�����һ����ָ��Ŀ¼�������߶������Ǹ������·������ɲ��֡�������Ϣ����ģ�Linux / Unix�еľ���·�� vs ���·��

��ע�⣬���صĹ淶·������ʼ����б�� / ��ͷ����������Ŀ¼��֮�����ֻ��һ��б�� /�����һ��Ŀ¼����������ڣ������� / ��β�����⣬�淶·�������Ǳ�ʾ����·��������ַ�����
ʾ�� 1��
���룺"/home/"
�����"/home"  ֻ��home
���ͣ�ע�⣬���һ��Ŀ¼������û��б�ܡ�
ʾ�� 2��
���룺"/../"
�����"/"  ..
���ͣ��Ӹ�Ŀ¼����һ���ǲ����еģ���Ϊ��������Ե������߼���
ʾ�� 3��
���룺"/home//foo/"
�����"/home/foo"   home foo
���ͣ��ڹ淶·���У��������б����Ҫ��һ��б���滻��
ʾ�� 4��
���룺"/a/./b/../../c/"
�����"/c"  a  .  ..   ..  c
ʾ�� 5��

���룺"/a/../../b/../c//.//"
�����"/c"
ʾ�� 6��

���룺"/a//b////c/d//././/.."
�����"/a/b/c"
 */
public class HW_Code2 {

    public static void main(String[] args) {
        System.out.println(getTarget("/a/../../b/../c//.//"));
    }

    public static String getTarget(String path) {
        // ͨ��б�˻���
        String[] split = path.split("/");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            if ("".equals(s)) continue;
            if ("..".equals(s)&&list.size()!=0) {
                list.remove(list.size()-1);
            } else if (!"..".equals(s)&&!".".equals(s)) {
                list.add(s);
            }
        }
        StringBuilder str =new StringBuilder();
        if (list.size()==0) {
            str.append("/");
        }
        for (String s : list) {
            str.append("/"+s);
        }
        return str.toString();
    }



}

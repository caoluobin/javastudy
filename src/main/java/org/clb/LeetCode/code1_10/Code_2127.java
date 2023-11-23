package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * һ����˾׼����֯һ�����飬������������ n λԱ������˾׼����һ�� Բ�� �����ӣ��������� ������Ŀ ��Ա����
 * Ա�����Ϊ 0 �� n - 1 ��ÿλԱ������һλ ϲ�� ��Ա����ÿλԱ�� ���ҽ��� ����������ϲ��Ա�����Աߣ����Ż�μӻ��顣ÿλԱ��ϲ����Ա�� ���� �����Լ���
 * ����һ���±�� 0 ��ʼ���������� favorite ������ favorite[i] ��ʾ�� i λԱ��ϲ����Ա�������㷵�زμӻ���� ���Ա����Ŀ ��
 */
public class Code_2127 {
    int count = 0;

    public static void main(String[] args) {
        Code_2127 code = new Code_2127();
        //15
        System.out.println(code.maximumInvitations2(new int[]{1,0,0,2,3,2}));
        System.out.println(code.count);
    }
    public int maximumInvitations2(int[] favorite) {
        int n = favorite.length;
        int[] deg = new int[n];
        for (int f : favorite) {
            deg[f]++; // ͳ�ƻ�����ÿ���ڵ�����
        }

        int[] maxDepth = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) { // �������򣬼���ͼ��������֦
            int x = q.poll();
            int y = favorite[x]; // x ֻ��һ������
            maxDepth[y] = maxDepth[x] + 1;//�����ں�����滻ǰ���
            if (--deg[y] == 0) {
                q.add(y);
            }
        }


        return 0;
    }
    public int maximumInvitations(int[] favorite) {//2 2 1 2
        if (favorite.length<=3) {
            return favorite.length;
        }
        int max =0;
        //0:��ǰ��󳤶�   1����� 0:�����ջ� 1:����ջ�  2 ���ջ� 3:��������
        //3: ��¼�ڵ�����
        Integer[][] df = new Integer[favorite.length][3];
        for (int emp = 0; emp < favorite.length; emp++) {
            getEmpJoinMaxNum(emp,favorite,df);
        }
        int twoOnly =0;
        for (Integer[] a : df) {
            Integer type = a[1];

            if (type==0) {
                twoOnly+=1+a[0];
            } else if (type==1) {
                max=Math.max(max,a[0]);
            }

        }
        for (int i = 0; i < favorite.length; i++) {
            System.out.println(String.format("%2d %2d %2d %2d",i,favorite[i],df[i][0],df[i][1]));
        }
        System.out.println(favorite.length);
        return Math.max(max,twoOnly);
    }


    private void getEmpJoinMaxNum(int emp, int[] favorite,Integer[][] df) {
        if (df[emp][0]!=null) {//����Ѿ�������
            return ;
        }
        if (emp==favorite[favorite[emp]] ) {//����ǻ��нڵ�
            if (df[emp][0] ==null) {
                df[emp][0] =0;
                df[emp][1] =0;
                df[emp][2] =favorite[emp];
            }
            if (df[favorite[emp]][0]==null) {
                df[favorite[emp]][0] =0;
                df[favorite[emp]][1] =0;
                df[favorite[emp]][2] =emp;
            }
            return ;
        }
        if (df[favorite[emp]][0]!=null ) {
            if ( df[favorite[emp]][1] ==2) {
                df[emp][0] = df[favorite[emp]][0]+1;
                df[emp][1] = df[favorite[emp]][1];
                df[emp][2] = df[favorite[emp]][2];
                df[df[favorite[emp]][2]][0] =Math.max(df[emp][0]-2,df[df[favorite[emp]][2]][0]);
                return;
            } else if (df[favorite[emp]][1] ==3||df[favorite[emp]][1] ==1) {
                df[emp][0] = 0;//���ʧ�� ����0
                df[emp][1] = 3;//���ʧ��
                return;
            }else if (df[favorite[emp]][1] ==0) {
                df[emp][0] = 3;//
                df[emp][1] = 2;//
                df[emp][2] = favorite[emp];//
                df[favorite[emp]][0] =Math.max(1,df[favorite[emp]][0]);
                return;
            }
        }
        Set<Integer> res= new HashSet<>();
        res.add(emp);
        int last =emp;
        while (true) {
            int now = favorite[last];
            if (res.contains(now)){//�����ʼ�ظ�
                if (now!=emp&&last!=favorite[now]) {//�����ǰ�ڵ㲻ϲ����һ�����ߵ�ǰ�ڵ�ϲ���Ĳ�����һ���ڵ�
                    df[emp][0] = 0;//���ʧ�� ����0
                    df[emp][1] = 3;//���ʧ��
                    return ;
                }
                if (last == favorite[now]) {//��������ջ�
                    df[now][0] =df[now][0]==null?res.size()-2: Math.max(res.size()-2,df[now][0]);//������һ�ߵ������ⳤ��
                    df[now][1] =0;
                    df[now][2] =last;
                    last = emp;
                    int count =res.size();
                    while (true) {
                        if (last==now) {
                            return;
                        }
                        df[last][0] = count--;
                        df[last][1] = 2;
                        df[last][2] = now;
                        last=favorite[last];
                    }
                }
                if (now == emp) {
                    while (true) {
                        df[now][0]=res.size();
                        df[now][1]=1;
                        now=favorite[now];
                        if (now==emp) {
                            return ;
                        }
                    }
                }
            }
            res.add(now);
            last=now;
        }
    }
}

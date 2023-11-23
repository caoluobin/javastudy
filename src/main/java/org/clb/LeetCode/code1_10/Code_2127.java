package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * 一个公司准备组织一场会议，邀请名单上有 n 位员工。公司准备了一张 圆形 的桌子，可以坐下 任意数目 的员工。
 * 员工编号为 0 到 n - 1 。每位员工都有一位 喜欢 的员工，每位员工 当且仅当 他被安排在喜欢员工的旁边，他才会参加会议。每位员工喜欢的员工 不会 是他自己。
 * 给你一个下标从 0 开始的整数数组 favorite ，其中 favorite[i] 表示第 i 位员工喜欢的员工。请你返回参加会议的 最多员工数目 。
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
            deg[f]++; // 统计基环树每个节点的入度
        }

        int[] maxDepth = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) { // 拓扑排序，剪掉图上所有树枝
            int x = q.poll();
            int y = favorite[x]; // x 只有一条出边
            maxDepth[y] = maxDepth[x] + 1;//长的在后面会替换前面的
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
        //0:当前最大长度   1：情况 0:两个闭环 1:多个闭环  2 不闭环 3:错误数据
        //3: 记录节点索引
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
        if (df[emp][0]!=null) {//如果已经遍历过
            return ;
        }
        if (emp==favorite[favorite[emp]] ) {//如果是环中节点
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
                df[emp][0] = 0;//组队失败 返回0
                df[emp][1] = 3;//组队失败
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
            if (res.contains(now)){//如果开始重复
                if (now!=emp&&last!=favorite[now]) {//如果当前节点不喜欢上一个或者当前节点喜欢的不是上一个节点
                    df[emp][0] = 0;//组队失败 返回0
                    df[emp][1] = 3;//组队失败
                    return ;
                }
                if (last == favorite[now]) {//如果两个闭环
                    df[now][0] =df[now][0]==null?res.size()-2: Math.max(res.size()-2,df[now][0]);//代表这一边的最大额外长度
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

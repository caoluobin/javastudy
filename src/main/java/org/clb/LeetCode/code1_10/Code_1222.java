package org.clb.LeetCode.code1_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Code_1222 {
    public static void main(String[] args) {
        Code_1222 code = new Code_1222();
        List<Integer> integers = null;
        code.deal(integers,1,2);
        integers.get(0);

    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> list =new ArrayList<>(8);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        List<Integer> list5 = new ArrayList<>();
        List<Integer> list6 = new ArrayList<>();
        List<Integer> list7 = new ArrayList<>();
        List<Integer> list8 = new ArrayList<>();
        int kingX = king[0];
        int kingY = king[1];
        for (int[] queen : queens) {
            int x = queen[0];
            int y = queen[1];
            if (x<kingX&&y<kingY&&(kingX-x==kingY-y)) {
                if (list1.isEmpty()||list1.get(0)<x) {
                    deal(list1,x,y);
                }
            } else  if (x==kingX&&y<kingY) {
                if (list2.isEmpty() || list2.get(1) < y) {
                    deal(list2,x,y);
                }
            } else  if (x>kingX&&y<kingY&&(kingX-x==y-kingY)) {
                if (list3.isEmpty() || list3.get(0) > x) {
                    deal(list3,x,y);
                }
            } else  if (y==kingY&&x<kingX) {
                if (list4.isEmpty() || list4.get(0) < x) {
                    deal(list4,x,y);
                }
            }else  if (y==kingY&&x>kingX) {
                if (list5.isEmpty() || list5.get(0) > x) {
                    deal(list5,x,y);
                }
            }else  if (x<kingX&&y>kingY&&(kingX-x==y-kingY)) {
                if (list6.isEmpty() || list6.get(0) < x) {
                    deal(list6,x,y);
                }
            }else  if (x==kingX&&y>kingY) {
                if (list7.isEmpty() || list7.get(1) > y) {
                    deal(list7,x,y);
                }
            }else  if (x>kingX&&y>kingY&&(kingX-x==kingY-y)) {
                if (list8.isEmpty() || list8.get(0) > x) {
                    deal(list8,x,y);
                }
            }
        }
        addList(list,list1);
        addList(list,list2);
        addList(list,list3);
        addList(list,list4);
        addList(list,list5);
        addList(list,list6);
        addList(list,list7);
        addList(list,list8);
        return list;
    }
    public void deal(List<Integer> list,int x,int y) {
        if (list.isEmpty()) {
            list.add(0,x);
            list.add(1,y);
        } else {
            list.set(0,x);
            list.set(1,y);
        }
    }
    public void addList(List<List<Integer>> list,List<Integer> list2) {
        if (!list2.isEmpty()) {
            list.add(list2);
        }
    }
}

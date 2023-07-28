package org.clb.LeetCode.code1_10;

import lombok.Data;
import org.checkerframework.checker.units.qual.C;

import java.util.*;

/**
 * ����һ������ n ����ʾ�� n �ڿΣ��γ̱�Ŵ� 1 �� n ��ͬʱ����һ����ά�������� relations ������ relations[j] = [prevCoursej, nextCoursej] ��
 * ��ʾ�γ� prevCoursej �����ڿγ� nextCoursej ֮ǰ ��ɣ����޿εĹ�ϵ����ͬʱ����һ���±�� 0 ��ʼ���������� time ������ time[i] ��ʾ��ɵ� (i+1) �ſγ���Ҫ���ѵ� �·� ����
 * ����������¹������������пγ�����Ҫ�� ���� �·�����
 * ���һ�ſε��������޿ζ��Ѿ���ɣ�������� ���� ʱ�俪ʼ���ſγ̡�
 * ����� ͬʱ �� �����ſγ� ��
 * ���㷵��������пγ�����Ҫ�� ���� �·�����
 */
public class Code_2050 {
    public static void main(String[] args) {
        //[1, 3][1, 2][2, 3]
//        int[][] relations = {{1, 3}, {1, 2}, {2, 3}};
//        int[] time = {0, 7, 8};
//        int n = 3;
//        System.out.println(new Code_2050().minimumTime(n, relations, time));
//        System.out.println(new Code_2050().minimumTime2(n, relations, time));
        test();
    }
    public static void test (){
        Random random = new Random();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 10000; i++) {
            int n = 10;
            int reLength =5;
            int[][] relations = new int[reLength][2];
            int[] time = new int[n];
            for (int j = 0; j < n; j++) {
                time[j] = random.nextInt(10)+1;
            }
            for (int j = 0; j < reLength; j++) {
                int[] relation = new int[2];

                do {
                    relation[0] = random.nextInt(n)+1;
                    int c =relation[0];
                    relation[1] = random.nextInt(n-c+1)+relation[0];
                } while (set.contains(relation[0] + "" + relation[1])||set.contains(relation[1] + "" + relation[0])||relation[0]>=relation[1]);
                set.add(relation[0] + "" + relation[1]);
                relations[j] = relation;
            }
            int res1 = new Code_2050().minimumTime(n, relations, time);
            int res2 = new Code_2050().minimumTime1(n, relations, time);
            if (res1!=res2) {
                System.out.println(res1+"  "+res2);
                System.out.println(Arrays.toString(time));
                for (int[] relation : relations) {
                    System.out.print(Arrays.toString(relation));
                }
                System.out.println("");
                System.out.println("====================================");
            }
            set.clear();
        }

    }


    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, Course> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            map.put(i + 1, new Course(time[i]));
        }
        for (int i = 0; i < relations.length; i++) {
            int[] relation = relations[i];
            Course course = map.get(relation[0]);
            course.nextSet.add(map.get(relation[1]));
        }
        int res = 0;
        for (Map.Entry<Integer, Course> entry : map.entrySet()) {
            Course course = entry.getValue();
            course.nextTime = deal(course);
            res = Math.max(res,course.nextTime );
        }
        return res;
    }
    public int minimumTime1(int n, int[][] relations, int[] time) {
        Map<Integer,Set<Integer>> relMap = new HashMap<>();
        for (int i = 0; i < relations.length; i++) {
            int[] relation = relations[i];
            Set<Integer> set = relMap.computeIfAbsent(relation[0], k -> new HashSet<>());
            set.add(relation[1]);
        }
        int res = 0;
        int[] dp = new int[n];
        for (int i = 0; i < time.length; i++) {
            int max = deal1(i , relMap, time, dp);
            res = Math.max(res,max);
            dp[i] = max;
        }
        return res;
    }
    public int deal1(int index,Map<Integer,Set<Integer>> relMap,int[] time,int[] dp) {
        Set<Integer> nextSet = relMap.getOrDefault(index + 1, new HashSet<>());
        if (nextSet.size() == 0) {
            return time[index];
        }
        if (dp[index] != 0)
            return dp[index];
        int sonMax = 0;
        for (Integer next : nextSet) {
            int son = deal1(next - 1, relMap, time, dp);
            sonMax = Math.max(sonMax,son);
        }
//        for (Course nextCourse : course.nextSet) {
//            int preTime = course.time+course.preTime;
//            if (nextCourse.preTime <preTime ) {
//                nextCourse.preTime = preTime;
//                if (nextCourse.nextTime == 0)
//                    nextCourse.nextTime = deal(nextCourse);
//            } else if (nextCourse.preTime == preTime) {
//                nextCourse.preTime = preTime;
//            }
//            sonMax = Math.max(sonMax,nextCourse.nextTime);
//        }
        return sonMax + time[index];
    }
    public int deal(Course course) {
        if (course.nextSet.size() == 0) {
            return course.time;
        }
        if (course.nextTime != 0)
            return course.nextTime;
        int sonMax = 0;
        for (Course nextCourse : course.nextSet) {
            int preTime = course.time+course.preTime;
            if (nextCourse.preTime <preTime ) {
                nextCourse.preTime = preTime;
                if (nextCourse.nextTime == 0)
                    nextCourse.nextTime = deal(nextCourse);
            } else if (nextCourse.preTime == preTime) {
                nextCourse.preTime = preTime;
            }
            sonMax = Math.max(sonMax,nextCourse.nextTime);
        }
        return sonMax + course.time;
    }
    public int minimumTime2(int n, int[][] relations, int[] time) {
        Map<Integer, Course> map = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            map.put(i + 1, new Course(time[i]));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < relations.length; i++) {
            int[] relation = relations[i];
            Course course = map.get(relation[0]);
            course.nextSet.add(map.get(relation[1]));
            set.add(relation[1]);
        }
        for (Integer integer : set) {
            map.remove(integer);
        }
        int res = 0;
        for (Map.Entry<Integer, Course> entry : map.entrySet()) {
            Course course = entry.getValue();
            res = Math.max(res, deal2(course));
        }
        return res;
    }
    public int deal2(Course course) {
        if (course.nextSet.size() == 0) {
            return course.time;
        }
        int sonMax = 0;
        for (Course nextCourse : course.nextSet) {
            if (nextCourse.preTime < course.time+course.preTime) {
                nextCourse.preTime = course.time+course.preTime;
                sonMax = Math.max(sonMax,deal2(nextCourse) );
            }
        }
        return sonMax + course.time;
    }


    private static class Course {//�γ�
        int time;
        int preTime;
        int nextTime;
        //        public Set<Course> preSet = new HashSet<>();
        public Set<Course> nextSet = new HashSet<>();
//        public Map<Course,String> preMap = new HashMap<>();

        public Course(int time) {
            this.time = time;
        }
    }
}

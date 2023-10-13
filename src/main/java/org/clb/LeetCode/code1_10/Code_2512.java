package org.clb.LeetCode.code1_10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给你两个字符串数组 positive_feedback 和 negative_feedback ，分别包含表示正面的和负面的词汇。不会 有单词同时是正面的和负面的。
 * 一开始，每位学生分数为 0 。每个正面的单词会给学生的分数 加 3 分，每个负面的词会给学生的分数 减  1 分。
 * 给你 n 个学生的评语，用一个下标从 0 开始的字符串数组 report 和一个下标从 0 开始的整数数组 student_id 表示，其中 student_id[i] 表示这名学生的 ID ，
 * 这名学生的评语是 report[i] 。每名学生的 ID 互不相同。
 * 给你一个整数 k ，请你返回按照得分 从高到低 最顶尖的 k 名学生。如果有多名学生分数相同，ID 越小排名越前。
 */
public class Code_2512 {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Map<String,Integer> map = new HashMap<>();
        for (String s : positive_feedback) {
            map.put(s,3);
        }
        for (String s : negative_feedback) {
            map.put(s,-1);
        }
        List<Student> list = new ArrayList<>();
        for (int i = 0; i < report.length; i++) {
            String s = report[i];
            String[] strings = s.split(" ");
            int grade = 0;


            for (String string : strings) {
                grade+=map.getOrDefault(string,0);
            }
            list.add(new Student(student_id[i],grade));
        }

        list.sort((a,b) ->{
            if (Objects.equals(a.grade, b.grade)) {
                return a.id.compareTo(b.id);
            }
            return b.grade.compareTo(a.grade);
        });
        return list.subList(0,k).stream().map(Student::getId).collect(Collectors.toList());

    }

    private class Student {
        private Integer id;
        private Integer grade;

        public Integer getId() {
            return id;
        }

        public Integer getGrade() {
            return grade;
        }

        public Student(Integer id, Integer grade) {
            this.id = id;
            this.grade = grade;
        }
    }
}

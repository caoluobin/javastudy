package org.clb.LeetCode.code1_10;

import java.util.*;
import java.util.stream.Collectors;

/**
 * ���������ַ������� positive_feedback �� negative_feedback ���ֱ������ʾ����ĺ͸���Ĵʻ㡣���� �е���ͬʱ������ĺ͸���ġ�
 * һ��ʼ��ÿλѧ������Ϊ 0 ��ÿ������ĵ��ʻ��ѧ���ķ��� �� 3 �֣�ÿ������Ĵʻ��ѧ���ķ��� ��  1 �֡�
 * ���� n ��ѧ���������һ���±�� 0 ��ʼ���ַ������� report ��һ���±�� 0 ��ʼ���������� student_id ��ʾ������ student_id[i] ��ʾ����ѧ���� ID ��
 * ����ѧ���������� report[i] ��ÿ��ѧ���� ID ������ͬ��
 * ����һ������ k �����㷵�ذ��յ÷� �Ӹߵ��� ���� k ��ѧ��������ж���ѧ��������ͬ��ID ԽС����Խǰ��
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

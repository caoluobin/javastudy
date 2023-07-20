package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * ��������һ�����޴�С�� XY ����ƽ�������ߣ��ӵ� (0, 0) ����ʼ���������򱱷����û����˿��Խ��������������͵����� commands ��
 * -2 ������ת 90 ��
 * -1 ������ת 90 ��
 * 1 <= x <= 9 ����ǰ�ƶ� x ����λ����
 * ����������һЩ���ӱ���Ϊ�ϰ��� obstacles ���� i ���ϰ���λ�������  obstacles[i] = (xi, yi) ��
 * �������޷��ߵ��ϰ����ϣ�������ͣ�����ϰ����ǰһ�����񷽿��ϣ�����Ȼ���Լ������Խ��и�·�ߵ����ಿ�֡�
 * ���ش�ԭ�㵽���������о�����·���㣨����Ϊ�����������ŷʽ�����ƽ�����������������Ϊ 5 ���򷵻� 25 ��
 */
public class Code_874 {
    public static void main(String[] args) {
        int[] commands = {6, -1, -1, 6};
        int[][] obstacles = {{-1, 3}, {0, 1}, {-1, 5}, {-2, -4}, {5, 4}, {-2, -3}, {5, -1}, {1, -1}, {5, 5}, {5, 2}};
        System.out.println(new Code_874().robotSim(commands, obstacles));
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        //����
        int direction = 0;
        Map<Integer, List<int[]>> mapX = new HashMap<>();
        Map<Integer, List<int[]>> mapY = new HashMap<>();
        for (int[] obstacle : obstacles) {
            if (mapX.containsKey(obstacle[0])) {
                mapX.get(obstacle[0]).add(obstacle);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(obstacle);
                mapX.put(obstacle[0], list);
            }
            if (mapY.containsKey(obstacle[1])) {
                mapY.get(obstacle[1]).add(obstacle);
            } else {
                List<int[]> list = new ArrayList<>();
                list.add(obstacle);
                mapY.put(obstacle[1], list);
            }
        }
        int max = 0;
        for (int command : commands) {
            if (command == -1) {
                direction = (direction + 1) % 4;
            } else if (command == -2) {
                direction = (direction + 3) % 4;
            } else {
                switch (direction) {
                    case 0:
                        List<int[]> list = mapX.getOrDefault(x, new ArrayList<>());
                        for (int[] obstacle : list) {
                            if (obstacle[1] > y) {
                                command = Math.min(command, obstacle[1] - y-1);
                            }
                        }
                        y += command;
                        break;
                    case 1:
                        List<int[]> list1 = mapY.getOrDefault(y, new ArrayList<>());
                        for (int[] obstacle : list1) {
                            if (obstacle[0] > x) {
                                command = Math.min(command, obstacle[0] - x-1);
                            }
                        }
                        x += command;
                        break;
                    case 2:
                        List<int[]> list2 = mapX.getOrDefault(x, new ArrayList<>());
                        for (int[] obstacle : list2) {
                            if (obstacle[1] < y) {
                                command = Math.min(command, y - obstacle[1]-1);
                            }
                        }
                        y -= command;
                        break;
                    case 3:
                        List<int[]> list3 = mapY.getOrDefault(y, new ArrayList<>());
                        for (int[] obstacle : list3) {
                            if (obstacle[0] < x) {
                                command = Math.min(command, x - obstacle[0]-1);
                            }
                        }
                        x -= command;
                        break;
                }
                max = Math.max(max, x * x + y * y);
            }
        }
        return max;
    }

}

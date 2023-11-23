package org.clb.LeetCode.code1_10;

import java.util.*;

/**
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 */
public class Code_874 {
    public static void main(String[] args) {
        int[] commands = {6, -1, -1, 6};
        int[][] obstacles = {{-1, 3}, {0, 1}, {-1, 5}, {-2, -4}, {5, 4}, {-2, -3}, {5, -1}, {1, -1}, {5, 5}, {5, 2}};
        System.out.println(new Code_874().robotSim(commands, obstacles));
    }
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        //方向
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

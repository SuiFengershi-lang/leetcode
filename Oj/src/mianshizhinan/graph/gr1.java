/*
* 课程表
* */
package mianshizhinan.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class gr1 {

    public static void main(String[] args) {
        int numCourse = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        boolean flag = canFinish(numCourse, prerequisites);
        System.out.println(flag);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        // 特判
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }
        int[] inDegree = new int[numCourses];   // 入队数组
        HashSet<Integer>[] adj = new HashSet[numCourses];   // 邻接数组
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {     // 初始化入队数组和邻接数组
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int cnt = 0;    // 记录出队的数量
        while (!queue.isEmpty()) {
            Integer pop = queue.poll();
            cnt += 1;
            for (int successor : adj[pop]) {        // 遍历当前出队节点的所有后继节点
                inDegree[successor]--;              // 入队度数减一
                if (inDegree[successor] == 0) {     // 将所有入度为0的节点入队
                    queue.add(successor);
                }
            }
        }
        return cnt == numCourses;
    }
}

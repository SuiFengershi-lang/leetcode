package mianshizhinan.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class gr2 {

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int[] order = findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(order));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {		// 特殊情况
            return new int[0];
        }
        HashSet<Integer>[] adj = new HashSet[numCourses];	// 邻接矩阵
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new HashSet<>();
        }
        int[] inDegree = new int[numCourses];	// 入队数组
        for (int[] p: prerequisites) {
            inDegree[p[0]]++;
            adj[p[1]].add(p[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {		// 将所有入度为0的节点入队
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int[] res = new int[numCourses];
        int count = 0;	// 当前结果集列表里面的元素个数
        while (!queue.isEmpty()) {
            Integer head = queue.poll();
            res[count] = head;
            count++;
            for(Integer nextCourse : adj[head]) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        if (count == numCourses) {
            return res;
        }
        return new int[0];
    }
}

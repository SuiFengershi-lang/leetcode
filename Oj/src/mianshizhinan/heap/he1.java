/*
* 最后一块石头的重量
* */
package mianshizhinan.heap;

import java.util.PriorityQueue;

public class he1 {

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        int res = lastStoneWeight(stones);
        System.out.println(res);
    }

    public static int lastStoneWeight(int[] stones) {
        // 构造一个大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        // 把每个石头的重量存入大顶堆中
        for (int stone : stones) {
            queue.offer(stone);
        }
        // 一直选出两个最大的进行比较,直到队列的元素个数小于2
        while (queue.size() > 1) {
            int a = queue.poll();
            int b = queue.poll();
            if (a > b) {
                queue.offer(a - b);
            }
        }
        return queue.isEmpty() ? 0 : queue.poll();
    }
}

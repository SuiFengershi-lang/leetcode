package mianshizhinan.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class he2 {

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4, 1};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        // 构造一个大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 1; i < k; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}

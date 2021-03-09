/*
* 给定一个区间的集合, 找到需要移除区间的最小数量, 使剩余区间互不重叠
* */
package mianshizhinan.greedy;

import java.util.Arrays;

public class gr1 {

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
        };
        int res = eraseOverlapIntervals(intervals);
        System.out.println(res);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        // 特殊情况
        if (intervals.length == 0) {
            return 0;
        }
        // 根据两个区间的头进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // 记录区间尾部的位置
        int end = intervals[0][1];
        // 需要移除的数量
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 发生了重叠, 必须移除一个
            if (intervals[i][0] < end) {
                // 选择尾部位置较小的
                end = Math.min(end, intervals[i][1]);
                count++;
            } else {
                // 没有发生重叠, 直接更新尾部位置
                end = intervals[i][1];
            }
        }
        return count;
    }
}

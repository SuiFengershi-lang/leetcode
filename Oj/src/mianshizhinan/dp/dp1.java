/*
* 给定一个整数数组, 找到一个
* 具有最大和的连续子数组, 返回其最大和
* */
package mianshizhinan.dp;

public class dp1 {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }

    public static int maxSubArray(int[] nums) {
        // dp[i]表示以第 i 个元素结尾的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            // 状态转移方程
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

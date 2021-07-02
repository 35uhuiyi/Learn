package alg4.Leetcode.DP;
/*
给定一个整数数组，找出总和最大的连续数列，并返回总和。

        示例：

        输入： [-2,1,-3,4,-1,2,1,-5,4]
        输出： 6
        解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。*/
public class maxSubArray {
    private int f(int[] nums){
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = max;//dpi表示当前最大
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray maxSubArray = new maxSubArray();
        System.out.println(maxSubArray.f(nums));
    }
}

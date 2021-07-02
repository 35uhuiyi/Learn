package LeetCode.DP;

import java.util.Arrays;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/16 22:12
 */
public class maxSubArray {
    public int f(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i], Math.max(dp[i-1]+nums[i], nums[i]));
        }
        System.out.println(Arrays.toString(dp));
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray maxSubArray = new maxSubArray();
        System.out.println(maxSubArray.f(nums));
    }
}

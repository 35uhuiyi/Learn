package alg4.Leetcode.array;

import java.util.Arrays;

/*剑指 Offer 57. 和为s的两个数字
        输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。



        示例 1：

        输入：nums = [2,7,11,15], target = 9
        输出：[2,7] 或者 [7,2]
        示例 2：

        输入：nums = [10,26,30,31,47,60], target = 40
        输出：[10,30] 或者 [30,10]*/
public class twoSum {
    public int[] twoSumf(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int s = nums[i] + nums[j];
            if(s>target){
                j--;
            }else if(s<target){
                i++;
            }else {
                return new int[] { nums[i], nums[j] };
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = {10,26,30,10,47,60};
        int target = 40;
        twoSum twoSum = new twoSum();
        int[] ints = twoSum.twoSumf(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}

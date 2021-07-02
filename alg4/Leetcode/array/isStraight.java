package alg4.Leetcode.array;

import java.util.Arrays;

public class isStraight {

    public boolean isStraightf(int[] nums) {
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]&&nums[i]!=0) return false;
            if(nums[i]==0) joker++;
        }
        return nums[4]-nums[joker]<5;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,2,5};
        int[] nums2 = {1,2,3,6,0};
        isStraight isStraight = new isStraight();
        System.out.println(isStraight.isStraightf(nums2));
    }
}

package alg4.Leetcode.array;

import java.util.Arrays;

public class searchRange {
    public int[] fun(int[] nums, int target) {
        if(nums==null||nums.length==0) return new int[]{-1,-1};
        int L = findL(nums, target);
        int R = -1;
        for(int i=L+1;i<nums.length;i++){
            if(nums[i]!=target){
                R=i-1;
                break;
            }
        }
        return new int[]{L,R};
    }
    private int findL(int[] nums,int target){
        int left = 0;
        int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]<target){
                left =mid+1;
            }else if(nums[mid]==target){
                right = mid;
            }else{
                right = mid-1;
            }
        }
        if(nums[left]==target) return left;
        return -1;
    }

    private int findR(int[] nums,int target){
        int left = 0;
        int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left+1)/2;
            if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]==target){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,7,7,9,10};
        int target =7;
        searchRange searchRange = new searchRange();
        int[] i = searchRange.fun(nums,target);
        System.out.println(Arrays.toString(i));
    }
}

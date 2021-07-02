package alg4.Leetcode.array;

import java.util.Arrays;

public class merge {
    public int[] f(int[] nums1, int m, int[] nums2, int n) {
        int a = 0, b=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[a]>=nums2[b]){
                nums1[i] = nums2[b++];
            }
            if(nums1[a]< nums2[b]){
                nums1[i] = nums1[a++];
            }
            if(a>m) nums1[i] = nums2[b++];
            if(b>n) nums1[i] = nums1[a++];
        }
        return nums1;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3, n=3;
        int[] ans;
        int[] nums2 = {2,5,6};
        merge merge = new merge();
        ans = merge.f(nums1,m,nums2,n);
        System.out.println(Arrays.toString(ans));
    }
}

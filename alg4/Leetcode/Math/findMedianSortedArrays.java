package alg4.Leetcode.Math;

import java.util.Arrays;

/**
 * @author yang
 * @version 1.0
 * @date 2021/5/24 22:01
 */
public class findMedianSortedArrays {

    public double f(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int s = m+n;
        int[] merge = new int[m+n];
        int p1=0,p2=0,cur=0;
        while(p1<m&&p2<n){
            if(nums1[p1]<=nums2[p2]){
                merge[cur++] = nums1[p1++];
            }else{
                merge[cur++] = nums2[p2++];
            }
        }

        while(p1<m){
            merge[cur++] = nums1[p1++];
        }
        while(p2<n){
            merge[cur++] = nums2[p2++];
        }
        System.out.print("merge:");
        System.out.println(Arrays.toString(merge));
        return s%2==0? ((merge[s/2-1]+merge[s/2])/2.0) : merge[s/2];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        findMedianSortedArrays find = new findMedianSortedArrays();
        double f = find.f(nums1, nums2);
        System.out.println(f);
    }
}

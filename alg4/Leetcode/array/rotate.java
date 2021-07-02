package alg4.Leetcode.array;

import java.util.Arrays;
import java.util.HashSet;

public class rotate {
    public void f(int[][] matrix) {
        int n = matrix.length;
        //1.先水平翻转
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j] = temp;
            }
        }
        //2.再沿主对角线翻转
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        rotate rotate = new rotate();
        rotate.f(nums);
        for (int[] num : nums) {
            for (int i : num) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        int[] nums1 = {1};
        System.out.println(Arrays.stream(nums1).sum());
    }
}

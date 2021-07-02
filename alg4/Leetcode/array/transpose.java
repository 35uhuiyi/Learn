package alg4.Leetcode.array;

import java.util.Arrays;

/*867. 转置矩阵
        给定一个矩阵 A， 返回 A 的转置矩阵。

        矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。



        示例 1：

        输入：[[1,2,3],[4,5,6],[7,8,9]]
        输出：[[1,4,7],[2,5,8],[3,6,9]]
        示例 2：

        输入：[[1,2,3],[4,5,6]]
        输出：[[1,4],[2,5],[3,6]]


        提示：

        1 <= A.length <= 1000
        1 <= A[0].length <= 1000*/
public class transpose {
    public int[][] transposef(int[][] A) {
        int m = A.length;//行数
        int n = A[0].length;//列数
        int[][] B = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        transpose transpose = new transpose();
        int[][] transposef = transpose.transposef(A);
        for (int[] ints : transposef) {
            System.out.print(Arrays.toString(ints)+" ");
        }
        System.out.println();
    }
}

package alg4.Leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*1380. 矩阵中的幸运数
        给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。

        幸运数是指矩阵中满足同时下列两个条件的元素：

        在同一行的所有元素中最小
        在同一列的所有元素中最大


        示例 1：

        输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
        输出：[15]
        解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
        示例 2：

        输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
        输出：[12]
        解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
        示例 3：

        输入：matrix = [[7,8],[1,2]]
        输出：[7]*/
public class luckyNumbers {
    public List<Integer> luckyNumbersf (int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            rows[i] = matrix[i][0];
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < rows[i])
                    rows[i] = matrix[i][j];
                if (matrix[i][j] > cols[j])
                    cols[j] = matrix[i][j];
            }
        }
        System.out.println(Arrays.toString(rows));
        System.out.println(Arrays.toString(cols));
        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (rows[i] == cols[j]) {
                    list.add(rows[i]);
                    break;
                }
            }
        }
        return list;

    }


    public static void main(String[] args) {
        int[][] mat = {{7,7},{1,2}};
        int[] arr = { 7,7,8,6,3,3};
        luckyNumbers luckyNumbers = new luckyNumbers();
        List<Integer> integers = luckyNumbers.luckyNumbersf(mat);
        System.out.println(integers);

    }
}

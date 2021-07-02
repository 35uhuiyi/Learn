package alg4.Leetcode.array;
/*给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

        示例 1:

        输入:
        [
        [ 1, 2, 3 ],
        [ 4, 5, 6 ],
        [ 7, 8, 9 ]
        ]
        输出: [1,2,3,6,9,8,7,4,5]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class spiraOrder {
    public int spiralOrderf(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int k=0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int l=0,t=0,r=n-1,b=m-1;
        while(k<=m*n){
            for(int i=l;i<=r;i++){
                list.add(matrix[t][i]);
                res[k++] = matrix[t][i];
            }
            t++;
            if(t>b) break;
            for(int i=t;i<=b;i++){
                list.add(matrix[i][r]);
                res[k++] = matrix[i][r];
            }
            r--;
            if(r<l) break;
            for(int i=r;i>=l;i--){
                list.add(matrix[b][i]);
                res[k++] = matrix[b][i];
            }
            b--;
            if(b<t) break;
            for(int i=b;i>=t;i--){
                list.add(matrix[i][l]);
                res[k++] = matrix[i][l];
            }
            l++;
            if(l>r) break;
        }
        System.out.println(Arrays.toString(res));
        return 1;
    }

    public static void main(String[] args) {
        int[][] matrix = {{ 1,2,3,4 },{5,6,7,8},{9,10,11,12}};
        spiraOrder spiraOrder = new spiraOrder();
        spiraOrder.spiralOrderf(matrix);

    }
}

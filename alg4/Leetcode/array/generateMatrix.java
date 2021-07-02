package alg4.Leetcode.array;
/*给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

        示例:

        输入: 3
        输出:
        [
        [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]
        ]*/

import java.util.Arrays;

public class generateMatrix {
    public int[][] generateMatrixf(int n) {
        int[][] ans = new int[n][n];
        int l=0,t=0,r=n-1,b=n-1;
        int num = 1,tar = n*n;
        while(num<=tar){
            for(int i=l;i<=r;i++) {
                ans[t][i] = num++;
            }
            t++;
            for(int i=t;i<=b;i++){
                ans[i][r] = num++;
            }
            r--;
            for(int i=r;i>=l;i--){
                ans[b][i] = num++;
            }
            b--;
            for(int i=b;i>=t;i--){
                ans[i][l] = num++;
            }
            l++;
        }
        return ans;
    }
    public static void main(String[] args) {
        generateMatrix generateMatrix = new generateMatrix();
        int[][] ints = generateMatrix.generateMatrixf(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
            System.out.println();
        }
    }
}

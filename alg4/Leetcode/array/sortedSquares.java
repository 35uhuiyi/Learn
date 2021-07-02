package alg4.Leetcode.array;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;

/*977. 有序数组的平方
        给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。



        示例 1：

        输入：[-4,-1,0,3,10]
        输出：[0,1,9,16,100]
        示例 2：

        输入：[-7,-3,2,3,11]
        输出：[4,9,9,49,121]


        提示：

        1 <= A.length <= 10000
        -10000 <= A[i] <= 10000
        A 已按非递减顺序排序。*/
public class sortedSquares {
    private int[] sortedSquaresf(int[] A) {
        int N = A.length;
        int[] B = new int[N];
        int j=0;//寻找非负开始的地方
        while (j<N&&A[j]<0){
            j++;
        }
        int i=j-1;//负值结束的地方
        int t=0;
        while (j<N&&i>=0){
            int a = A[j]*A[j];
            int b = A[i]*A[i];
            if(a<b){
                B[t++]=a;
                j++;
            }else {
                B[t++]=b;
                i--;
            }
        }
        //j还没走完
        while (j<N){
            B[t++]=A[j]*A[j];
            j++;
        }
        //i还没走完
        while (i>=0){
            B[t++]=A[i]*A[i];
            i--;
        }
        return B;
    }
    public static void main(String[] args) {
        int[] A = {-7,-3,2,3,11};
        sortedSquares sortedSquares = new sortedSquares();
        int[] ints = sortedSquares.sortedSquaresf(A);
        System.out.println(Arrays.toString(ints));
    }
}

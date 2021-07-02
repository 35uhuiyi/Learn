package alg4.Leetcode.Math;

import java.util.HashMap;
import java.util.Map;

/*如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：

        n >= 3
        对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
        给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。

        （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）

         

        示例 1：

        输入: [1,2,3,4,5,6,7,8]
        输出: 5
        解释:
        最长的斐波那契式子序列为：[1,2,3,5,8] 。*/
public class lenLongestFibSubseq {
    public int lenLongestFibSubseqf(int[] A) {
        int retData = 0;
        int length = A.length;
        Map<Integer,Integer> dataMap = new HashMap<>();
        for(int i=0;i<length;i++){
            dataMap.put(A[i],i);
        }
        int[][] tmpData = new int[length][length];
        for(int i=length-1; i>=0; i--){
            for(int j=i+1; j<length; j++){
                if(dataMap.get(A[i] + A[j]) != null){
                    int tmp = A[i] + A[j];
                    int position = dataMap.get(tmp);
                    tmpData[i][j] = tmpData[j][position] + 1;
                    retData = Math.max(retData,tmpData[i][j]);
                }else {
                    tmpData[i][j] = 2;
                }
            }
        }
        return retData;
    }

    public static void main(String[] args) {
        int[] A = {1,3,7,11,12,14,18};
        lenLongestFibSubseq lenLongestFibSubseq = new lenLongestFibSubseq();
        int i = lenLongestFibSubseq.lenLongestFibSubseqf(A);
        System.out.println(i);
    }
}

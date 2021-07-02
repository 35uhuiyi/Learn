package alg4.Leetcode.array;

import java.util.ArrayList;
import java.util.List;

/*1588. 所有奇数长度子数组的和
        给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。

        子数组 定义为原数组中的一个连续子序列。

        请你返回 arr 中 所有奇数长度子数组的和 。



        示例 1：

        输入：arr = [1,4,2,5,3]
        输出：58
        解释：所有奇数长度子数组和它们的和为：
        [1] = 1
        [4] = 4
        [2] = 2
        [5] = 5
        [3] = 3
        [1,4,2] = 7
        [4,2,5] = 11
        [2,5,3] = 10
        [1,4,2,5,3] = 15
        我们将所有值求和得到 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58*/
public class sumOddLengthSubarrays {
    public int sumOddLengthSubarraysf(int[] arr) {
        int sum=0;
        int len=arr.length;
        for(int i=1;i<=len;i+=2){
            int left = 0;
            while (left+i<=len){//i为个数，left为起点,向后走
                for(int j=left;j<left+i;j++){
                    sum += arr[j];
                }
                left++;
            }
        }
        return sum;
    }


    public int sumOddLengthSubarraysf2(int[] arr) {
        int sum=0;
        for(int i=0;i<arr.length;i++){
            int left = i+1;
            int right = arr.length-i;
            int left_even = (left+1)/2,left_odd=left/2;
            int right_even = (right+1)/2,right_odd=right/2;
            sum += arr[i]*(left_even*right_even+left_odd*right_odd);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr={1,4,2,5,3};
        sumOddLengthSubarrays sumOddLengthSubarrays = new sumOddLengthSubarrays();
        int i = sumOddLengthSubarrays.sumOddLengthSubarraysf2(arr);
        System.out.println(i);
    }


}

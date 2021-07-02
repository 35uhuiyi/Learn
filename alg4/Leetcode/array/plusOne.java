package alg4.Leetcode.array;

import java.util.Arrays;

/*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。

        示例 1:

        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。*/
public class plusOne {
    public int[] plusOnef(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9,8,7,6,5,4,3,2,1,9};
        plusOne plusOne = new plusOne();
        int[] ints = plusOne.plusOnef(digits);
        System.out.println(Arrays.toString(ints));
    }
}

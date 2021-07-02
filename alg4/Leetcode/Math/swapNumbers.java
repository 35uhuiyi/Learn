package alg4.Leetcode.Math;
/*编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。

        示例：

        输入: numbers = [1,2]
        输出: [2,1]*/

import java.util.Arrays;

/*
* 不能numbers[0] = (numbers[0]+numbers[1])-numbers[0];
      numbers[1] = (numbers[0]+numbers[1])-numbers[1];
      相加会越界
* */
public class swapNumbers {
    public static void main(String[] args) {
        int[] numbers={0,2147483647};
        numbers[0] = numbers[0]-numbers[1];
        numbers[1] = numbers[0]+numbers[1];//第一个元素先减去第二个元素再加上第二个元素还是自身赋给第二个元素
        numbers[0] = numbers[1]-numbers[0];//相当于numbers[0] =（numbers[1]-（numbers[0]-numbers[1]））
        System.out.println(Arrays.toString(numbers));
    }
}
package alg4.Leetcode.Math;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
/*728. 自除数
        自除数 是指可以被它包含的每一位数除尽的数。

        例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。

        还有，自除数不允许包含 0 。

        给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。

        示例 1：

        输入：
        上边界left = 1, 下边界right = 22
        输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]*/
public class selfDividingNumbers {
    public List<Integer> selfDividingNumbersf(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(judge(i)) ans.add(i);
        }
        return ans;
    }
    private boolean judge(int i){
        for (char c: String.valueOf(i).toCharArray()) {
            if (c == '0' || (i % (c - '0') > 0)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        selfDividingNumbers selfDividingNumbers = new selfDividingNumbers();
        List<Integer> integers = selfDividingNumbers.selfDividingNumbersf(1, 22);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}

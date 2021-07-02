package alg4.Leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;

/*1389. 按既定顺序创建目标数组
        给你两个整数数组 nums 和 index。你需要按照以下规则创建目标数组：

        目标数组 target 最初为空。
        按从左到右的顺序依次读取 nums[i] 和 index[i]，在 target 数组中的下标 index[i] 处插入值 nums[i] 。
        重复上一步，直到在 nums 和 index 中都没有要读取的元素。
        请你返回目标数组。

        题目保证数字插入位置总是存在。

        示例 1：

        输入：nums = [0,1,2,3,4], index = [0,1,2,2,1]
        输出：[0,4,1,3,2]
        解释：
        nums       index     target
        0            0        [0]
        1            1        [0,1]
        2            2        [0,1,2]
        3            2        [0,1,3,2]
        4            1        [0,4,1,3,2]

        提示：

        1 <= nums.length, index.length <= 100
        nums.length == index.length
        0 <= nums[i] <= 100
        0 <= index[i] <= i*/
public class createTargetArray {
    private int[] createTargetArrayf(int[] nums, int[] index) {
        if(nums.length==1) return nums;
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for(int j=nums.length-1;j>index[i];j--){
                res[j] = res[j-1];
            }
            res[index[i]] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "abc";
        int b = 'c';
        System.out.println(b);

        int[] nums={0,1,2,3,4};
        int[] index={0,1,2,2,1};
        createTargetArray createTargetArray = new createTargetArray();
        int[] targetArrayf = createTargetArray.createTargetArrayf(nums, index);
        System.out.println(Arrays.toString(targetArrayf));
    }
}

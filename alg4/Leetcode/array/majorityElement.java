package alg4.Leetcode.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*面试题 17.10. 主要元素
        数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。

        示例 1：

        输入：[1,2,5,9,5,9,5,5,5]
        输出：5


        示例 2：

        输入：[3,2]
        输出：-1


        示例 3：

        输入：[2,2,1,1,1,2,2]
        输出：2


        说明：
        你有办法在时间复杂度为 O(N)，空间复杂度为 O(1) 内完成吗？*/
public class majorityElement {
    private int test(int[] nums){
        int l = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                Integer integer = map.get(nums[i]);
                map.put(nums[i],++integer);
                if(integer>l){
                    return nums[i];
                }
            }else {
                map.put(nums[i],1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
            Integer key = entry.getKey();
            System.out.println(key+" "+value);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        int[] nums2 = {1,2,5,9,5,9,5,5,5};
        int[] nums3 = {2,2,2,2};
        majorityElement majorityElement = new majorityElement();
        int test = majorityElement.test(nums);
        System.out.println(test);
    }
}

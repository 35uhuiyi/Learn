package alg4.Leetcode.array;
/*剑指 Offer 39. 数组中出现次数超过一半的数字
        数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
        你可以假设数组是非空的，并且给定的数组总是存在多数元素。



        示例 1:

        输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
        输出: 2*/
public class majorityElement2 {
    public int majorityElement(int[] nums) {
        int x= 0;
        int cnt=0;
        for (int i = 0; i < nums.length; i++) {
            if(cnt==0){
                x=nums[i];
            }
            cnt += x==nums[i] ? 1: -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        majorityElement2 majorityElement2 = new majorityElement2();
        int i = majorityElement2.majorityElement(nums);
        System.out.println(i);
    }
}

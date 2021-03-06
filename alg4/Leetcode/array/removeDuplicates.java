package alg4.Leetcode.array;
/*26. 删除排序数组中的重复项
        给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

        不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



        示例 1:

        给定数组 nums = [1,1,2],

        函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。

        你不需要考虑数组中超出新长度后面的元素。*/
public class removeDuplicates {
    private static int removeDuplicatesf(int[] nums) {
        int i = 0;//不同个数索引
        for (int j = 1; j < nums.length; j++) {
            if(nums[j]!=nums[i]){
                nums[++i]=nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,2};
        int i = removeDuplicatesf(arr);
        System.out.println("共："+i+"个");
        for (int j = 0; j < i; j++) {
            System.out.print(arr[j]+" ");
        }
    }
}

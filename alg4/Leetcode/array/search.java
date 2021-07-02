package alg4.Leetcode.array;
/*统计一个数字在排序数组中出现的次数。



        示例 1:

        输入: nums = [5,7,7,8,8,10], target = 8
        输出: 2*/
public class search {
    public int searchf1(int[] nums, int target) {
        //寻找右边
        int i=0,j=nums.length-1;
        while(i<=j){
            int m = (i+j)/2;
            if(nums[m]<=target){
                i = m+1;
            }else{
                j = m-1;
            }
        }
        int right = i;
        if(j>0&&nums[j]!=target) return 0;
        //寻找左边
        i=0;j=nums.length-1;
        while(i<=j){
            int m = (i+j)/2;
            if(nums[m]<target){
                i = m+1;
            }else{
                j = m-1;
            }
            System.out.println(j);
        }
        int left = j;
        return right-left-1;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        search search = new search();
        int i = search.searchf1(nums, target);
        System.out.println(i);
    }
}

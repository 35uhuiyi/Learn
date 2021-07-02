

import java.util.*;

public class test {
    public int findKthLargest(int[] nums, int k) {
        //快速排序,升序
        return select(nums, 0,nums.length-1, nums.length-k);
    }
    private int select(int[] nums, int l, int r, int index){
        int q = partition(nums, l, r);
        if(q==index){
            return nums[q];
        }else{
            return q>index ? select(nums, l, q-1, index) : select(nums, q+1, r, index);
        }
    }
    private void swap(int[] nums, int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    private int partition(int[] nums, int l, int r){
        int i = l-1;
        int v = nums[r];
        for(int j=l;j<r;++j){
            if(nums[j] <= v){
                swap(nums, ++i, j);
            }
        }
        swap(nums, i+1, r);
        return i+1;
    }


    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for(int n: nums){
            if(list.size()==0||list.get(list.size()-1)<n){
                list.add(n);
            }else{
                int pos = Collections.binarySearch(list, n);
                int p = (pos<0)? -pos-1:pos;
                list.set(p, n);
            }
        }
        System.out.println(Arrays.toString(list.stream().mapToInt(Integer::valueOf).toArray()));
        return list.size();
    }





    public static void main(String[] args) {
        test test = new test();
        int[] nums = {10,9,2,5,3,7,101,18};   //4:0123
//        int kthLargest = test.findKthLargest(nums, 1);
        System.out.println(test.lengthOfLIS(nums));
    }

}

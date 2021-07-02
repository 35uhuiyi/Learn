package alg4.Leetcode.Math;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public int fun(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int c = map.getOrDefault(nums[i], 0);
            map.put(nums[i], c+=1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()==1){
                return entry.getKey();
            }
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        return -1;
    }

    public static void main(String[] args) {
        SingleNumber2 singleNumber2 = new SingleNumber2();
        int fun = singleNumber2.fun(new int[]{3, 4, 3, 3});
        System.out.println(fun);

    }
}

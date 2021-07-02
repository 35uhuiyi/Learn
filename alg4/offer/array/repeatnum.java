package alg4.offer.array;

import java.util.Arrays;

public class repeatnum {

    public static int[] nums = {2,3,1,0,2,5,3};

    public static void main(String[] args) {
        int l = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < l; i++) {
            int num = nums[i];
            if(num != i){

            }
            System.out.print(num+" ");
        }
        System.out.println();
    }

}

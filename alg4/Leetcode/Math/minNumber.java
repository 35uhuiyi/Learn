package alg4.Leetcode.Math;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/20 22:09
 */
public class minNumber {

    private String f1(int[] nums){
        Queue<String> queue  = new PriorityQueue<>((o1,o2)->(o1+o2).compareTo(o2+o1));
        for (int num : nums) {
            queue.add(num+"");
        }
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    private String f2(int[] nums){

        return Arrays.stream(nums).mapToObj(String::valueOf)
                .sorted((a,b)->(a+b).compareTo(b+a))
                .collect(Collectors.joining());
    }

    private String f3(int[] nums){

        String collect = Arrays.stream(nums).mapToObj(String::valueOf).sorted((a, b) -> (a + b).compareTo(b + a)).collect(Collectors.joining());
        return collect;
    }




    public static void main(String[] args) {
        minNumber minNumber = new minNumber();
        System.out.println(minNumber.f2(new int[]{3,30}));


    }

}

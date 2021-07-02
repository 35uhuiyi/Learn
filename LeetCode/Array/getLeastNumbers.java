package LeetCode.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/15 22:28
 */
public class getLeastNumbers {

    public int[] f(int[] arr, int k) {
        int[] res = new int[k];
        if(k==0) {return res;}
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i=0;i<k;i++){
            heap.offer(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i]>heap.peek()){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        for(int i=0;i<k;i++){
            res[i] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        getLeastNumbers getLeastNumbers = new getLeastNumbers();
        int[] f = getLeastNumbers.f(arr, 1);
        System.out.println(Arrays.toString(f));
    }
}

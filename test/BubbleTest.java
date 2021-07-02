package test;

import sort.Bubble;

import java.util.Arrays;

public class BubbleTest {
    public static void main(String[] args) {
        Integer[] arr = {4,6,5,3,2,1};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

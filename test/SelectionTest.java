package test;

import sort.Selection;

import java.util.Arrays;

public class SelectionTest {
    public static void main(String[] args) {
        Integer[] arr = {4,6,8,9,1};
        Selection.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

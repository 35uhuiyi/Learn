package test;

import sort.Insertion;
import sort.Selection;

import java.util.Arrays;

public class InsertionTest {
    public static void main(String[] args) {
        Integer[] arr = {4,6,8,9,1};
        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

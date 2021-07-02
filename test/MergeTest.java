package test;

import sort.Merge;
import sort.Selection;

import java.util.Arrays;

public class MergeTest {
    public static void main(String[] args) {
        Integer[] arr = {7,5,6,4,3};
        Merge.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Merge.getCount());
    }
}

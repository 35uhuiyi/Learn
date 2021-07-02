package test;

import sort.Quick;
import sort.Quick2;
import sort.Quick3way;
import sort.Shell;

import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        Integer[] arr = {4,6,8,9,1,8};
        Quick3way.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

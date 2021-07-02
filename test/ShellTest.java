package test;

import sort.Selection;
import sort.Shell;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        Integer[] arr = {4,6,8,9,1};
        Shell.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

package LeetCode.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/5 20:33
 */
public class merge {


    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(4);
        l.add(63);
        System.out.println(l.stream().mapToInt(Integer::valueOf).sum());

    }
}

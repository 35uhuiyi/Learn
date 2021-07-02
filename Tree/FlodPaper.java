package Tree;

import java.util.ArrayList;
import java.util.List;

public class FlodPaper {
    static List<String> list = new ArrayList<>();
    public static void inOrder(int n, boolean isDown){
        if(n == 0){
            return;
        }
        inOrder(n - 1, true);
        if(isDown) {
            list.add("down");
        }else {
            list.add("up");
        }
        inOrder(n - 1, false);
    }
    public static String[] foldPaper(int n) {
        // write code here
        inOrder(n, true);
        String[] strs = list.toArray(new String[]{});
        return strs;
    }

    public static void main(String[] args) {
        String[] strings = foldPaper(3);
        System.out.println(list);

    }
}

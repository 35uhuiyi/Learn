package Tree;

import java.util.Scanner;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/16 16:06
 */
public class RBTreeTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RBTree<String, Object> rbt = new RBTree<>();
        //rbt.insert("1",null);


        while(true){
            System.out.println("input key:");
            String key = scanner.next();
            System.out.println();
            rbt.insert(key,key);
            TreeOperation.show(rbt.getRoot());
        }
    }
}

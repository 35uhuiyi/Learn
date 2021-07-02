package test;

import Tree.BinaryTree;

import linear.Queue_ny;

public class BinaryTreeErgodicTest {
     //测试遍历
    public static void main(String[] args) {
        //创建树对象
        BinaryTree<String, String> tree = new BinaryTree<>();
        //往树中添加数据
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");
        tree.put("aa","9");
        System.out.println(tree.maxDepth());

        /*//前序遍历
        Queue_ny<String> keys = tree.preErgodic();
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }*/
        /*//中序遍历
        Queue_ny<String> keys = tree.midErgodic();
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }*/
      /*  //后序遍历
        Queue_ny<String> keys = tree.afterErgodic();
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }*/
        /*//层序遍历
        Queue_ny<String> keys = tree.layerErgodic();
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }*/
    }
}

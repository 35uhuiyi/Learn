package test;

import Tree.BinaryTree;

public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();

        tree.put(1,"a");
        tree.put(2,"b");
        tree.put(3,"c");
        tree.put(4,"d");

        System.out.println(tree.size());

        tree.delete(3);
        System.out.println(tree.size());
        String s = tree.get(4);
        System.out.println(s);
        System.out.println(tree.max());


    }
}

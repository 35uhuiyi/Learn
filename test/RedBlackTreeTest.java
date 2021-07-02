package test;

import Tree.RedBlackTree;

public class RedBlackTreeTest {
    public static void main(String[] args) {
        RedBlackTree<String, String> tree = new RedBlackTree<String, String>();
        tree.put("1","aaa");
        tree.put("2","bbb");
        tree.put("3","ccc");


        String s1 = tree.get("1");
        System.out.println(s1);

        String s2 = tree.get("2");
        System.out.println(s2);

        String s3 = tree.get("3");
        System.out.println(s3);
    }
}

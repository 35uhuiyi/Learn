package LeetCode.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/3 21:52
 */
public class node {


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    List<Integer> list = Arrays.asList(1, 2,3,4,5);

    public TreeNode increasingBST() {
        TreeNode res = new TreeNode(0);
        TreeNode cur = res;
        for (int i : list) {
            cur.right = new TreeNode(i);
            cur = cur.right;
        }
        return res.right;
    }

    public static void main(String[] args) {
        node node = new node();
        node.increasingBST();
    }
}
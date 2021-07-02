package alg4.Leetcode.Linked;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*给定一棵二叉搜索树，请找出其中第k大的节点。

         

        示例 1:

        输入: root = [3,1,4,null,2], k = 1
         3
        / \
       1   4
        \
         2
        输出: 4
        示例 2:

        输入: root = [5,3,6,2,4,null,null,1], k = 3
         5
        / \
       3   6
      / \
     2   4
        /
        1
        输出: 4*/
public class KthLargest {
      public class TreeNode {
          int val;
         TreeNode left;
         TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        preErgodic(root,list);
        return list.get(list.size()-k);
    }
    private void preErgodic(TreeNode root,List<Integer> list)
    {
        if(root==null){
            return;
        }
        if(root.left!=null){
            preErgodic(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            preErgodic(root.right,list);
        }
    }
}

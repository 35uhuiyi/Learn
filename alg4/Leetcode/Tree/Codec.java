package alg4.Leetcode.Tree;

import LeetCode.DFS.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node!=null){
                    sb.append(node.val+",");
                    if(node.left!=null) queue.offer(node.left);
                    if(node.right!=null) queue.offer(node.right);
                }else{
                    sb.append("null,");
                }
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")) return null;
        data = data.substring(1,data.length()-1);
        String[] strNode = data.split(",");
        System.out.println(Arrays.toString(strNode));
        TreeNode root = new TreeNode(Integer.parseInt(strNode[0]));  //建立根结点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1; //数组指针
        //一层一退
        while(!queue.isEmpty()&&i<strNode.length){
            TreeNode node = queue.poll();
            //加左结点
            if(!strNode[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(strNode[i]));
                //该层结点入队
                queue.offer(node.left);
            }
            //指针移动
            i++;
            if(!strNode[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(strNode[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.deserialize("[1,2,3,null,null,4,5]");
    }
}


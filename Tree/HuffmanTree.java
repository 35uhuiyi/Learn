package Tree;

import java.util.ArrayList;
import java.util.Collections;

//赫夫曼树
public class HuffmanTree {
    private static class Node implements Comparable<Node>{
        int val;
        Node left;
        Node right;
        public Node(int val,Node left,Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.val-o.val;
        }
    }
    public static Node createTree(int[] arr){
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i],null,null));
        }
        while (nodes.size()>1){
            Collections.sort(nodes);

            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);

            Node p = new Node(leftNode.val+rightNode.val,leftNode,rightNode);
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            nodes.add(p);
        }
        return nodes.get(0);
    }
    public static void print(Node x){
        //前序遍历
        System.out.print(x.val+" ");
        if(x.left!=null){
            print(x.left);
        }
        if(x.right!=null){
            print(x.right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node root = createTree(arr);
        print(root);

    }
}

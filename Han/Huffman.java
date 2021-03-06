package Han;

import java.util.*;

//赫夫曼编码
public class Huffman {

    private static List<Node> getNodes(byte[] bytes){
        ArrayList<Node> nodes = new ArrayList<>();
        //遍历bytes，统计到map
        HashMap<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if(count==null){
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    //前序遍历的方法
    private static void preOrder(Node root) {
        if(root != null) {
            root.preOrder();
        }else {
            System.out.println("赫夫曼树为空");
        }
    }
    //可以通过List 创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes) {
        while(nodes.size() > 1) {
            //排序, 从小到大
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二颗最小的二叉树
            Node rightNode = nodes.get(1);
            //创建一颗新的二叉树,它的根节点 没有data, 只有权值
            Node parent = new Node(null, leftNode.weight + rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //将已经处理的两颗二叉树从nodes删除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树，加入到nodes
            nodes.add(parent);

        }
        //nodes 最后的结点，就是赫夫曼树的根结点
        return nodes.get(0);

    }
    private static byte[] zip(byte[] bytes, Map<Byte, String> HuffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bytes) {
            stringBuilder.append(HuffmanCodes.get(b));
        }
        int len = (stringBuilder.length()+7)/8;
        byte[] huffmanCodeBytes = new byte[len];
        int index=0;
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            //每8位对应一个byte
            String strByte;
            if(i+8>stringBuilder.length()){
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }
            huffmanCodeBytes[index] = (byte)Integer.parseInt(strByte,2);
            index++;
        }
        return huffmanCodeBytes;
    }








}
//创建Node ,待数据和权值
class Node implements Comparable<Node>  {
    Byte data; // 存放数据(字符)本身，比如'a' => 97 ' ' => 32
    int weight; //权值, 表示字符出现的次数
    Node left;//
    Node right;
    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node o) {
        // 从小到大排序
        return this.weight - o.weight;
    }

    public String toString() {
        return "Node [data = " + data + " weight=" + weight + "]";
    }
    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if(this.left != null) {
            this.left.preOrder();
        }
        if(this.right != null) {
            this.right.preOrder();
        }
    }
}
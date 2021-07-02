package Tree;


import edu.princeton.cs.algs4.In;
import linear.Queue_ny;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//二叉查找树实现
public class BinaryTree<Key extends Comparable<Key>,Value> {
    private class Node{
        private Key key;
        private Value value;
        private Node right;
        private Node left;
        private Node(Key key, Value value, Node right, Node left) {
            this.key = key;
            this.value = value;
            this.right = right;
            this.left = left;
        }
    }
    private Node root;
    private int N;
    public BinaryTree(){
        this.N=0;
        this.root=null;
    }
    //获取个数
    public int size(){
        return N;
    }
    //向树中插入一个键值对
    public void put(Key key,Value value){
        //调用重载
        root = put(this.root, key, value);
    }
    //给指定树x插入一个键值对,返回该节点
    private Node put(Node x, Key key, Value value){//递归调用
        if(x==null){
            //空树,找到了空位置，放入元素
            N++;
            return new Node(key,value,null,null);
        }
        int c = key.compareTo(x.key);
        if(c>0){
            //从该节点的右子树中继续寻找
            x.right = put(x.right, key, value);//递归
        }else if(c<0){
            //从该节点的左子树中继续寻找
            x.left = put(x.left,key,value);
        }else{
            //Key值相同替换元素
            x.value=value;
        }
        return x;
    }
    //根据Key,从树中寻找Value
    public Value get(Key key){
        return get(root,key);
    }
    //根据Key,从指定树中寻找Value
    private Value get(Node x, Key key){
        if(x==null){
            return null;//空树
        }
        int c = key.compareTo(x.key);
        if(c>0){
            //从该节点的右子树中继续寻找，返回结果
            return get(x.right, key);//递归
        }else if(c<0){
            //从该节点的左子树中继续寻找
            return get(x.left,key);
        }else{
            //Key值相同,找到元素
            return x.value;
        }
    }
    //根据Key,从树中删除节点
    public void delete(Key key){
        delete(root,key);

    }
    //根据Key,从指定树中删除节点,返回删除后的该节点（已被替换的节点）
    private Node delete(Node x, Key key){
        if(x==null){
            //空树
            return null;
        }
        int c = key.compareTo(x.key);
        if(c>0){
            //从该节点的右子树中继续寻找
            x.right = delete(x.right, key);//递归
        }else if(c<0){
            //从该节点的左子树中继续寻找
            x.left = delete(x.left,key);
        }else{
            //Key值相同,删除该元素

            N--;
            //如果该节点的右子节点为空
            if(x.right==null){
                return x.left;
            }
            //如果该节点的左子节点为空
            if(x.left==null){
                return x.right;
            }
            //左右子节点都有时，找到右子节点的最小节点（最左）
            Node minNode = x.right;
            while (minNode.left!=null){
                minNode=minNode.left;
            }
            Node n=x.right;//记录删除节点的父节点，使其指向为空
            while(n.left!=null){
                if(n.left.left==null){
                    n.left=null;
                }
                n=n.left;
            }
            //让原左子树变为minNode的左子树
            minNode.left=x.left;
            //让原右子树变为minNode的右子树
            minNode.right=x.right;
            //让x节点的父节点指向minNode
            x = minNode;
        }
        return x;
    }
    //查找最小
    public Key min(){
        return min(root).key;
    }
    private Node min(Node x){
        if(x.left!=null){
            return min(x.left);
        }else {
            return x;
        }
    }
    //查找最大
    public Key max(){
        return max(root).key;
    }
    private Node max(Node x){
        if(x.right!=null){
            return max(x.right);
        }else {
            return x;
        }
    }
    //前序遍历
    public Queue_ny<Key> preErgodic(){
        Queue_ny<Key> keys = new Queue_ny<>();
        preErgodic(root,keys);
        return keys;
    }
    private void preErgodic(Node x,Queue_ny<Key> keys){
        if(x==null){
            return;
        }
        //根
        keys.enqueue(x.key);
        //左
        if(x.left!=null){
            preErgodic(x.left,keys);
        }
        //右
        if(x.right!=null){
            preErgodic(x.right,keys);
        }
    }
    //中序遍历
    public Queue_ny<Key> midErgodic(){
        Queue_ny<Key> keys = new Queue_ny<>();
        midErgodic(root,keys);
        return keys;
    }
    private void midErgodic(Node x,Queue_ny<Key> keys){
        if(x==null){
            return;
        }
        //左
        if(x.left!=null){
            midErgodic(x.left,keys);
        }
        //根
        keys.enqueue(x.key);
        //右
        if(x.right!=null){
            midErgodic(x.right,keys);
        }
    }
    //后序遍历
    public Queue_ny<Key> afterErgodic(){
        Queue_ny<Key> keys = new Queue_ny<>();
        afterErgodic(root,keys);
        return keys;
    }
    private void afterErgodic(Node x,Queue_ny<Key> keys){
        if(x==null){
            return;
        }
        //左
        if(x.left!=null){
            afterErgodic(x.left,keys);
        }
        //右
        if(x.right!=null){
            afterErgodic(x.right,keys);
        }
        //根
        keys.enqueue(x.key);
    }
    //层序遍历获取键，借助于两个队列
    public Queue_ny<Key> layerErgodic(){
        Queue_ny<Key> keys = new Queue_ny<>();//存储结果键
        Queue_ny<Node> nodes = new Queue_ny<>();//操作节点的队列
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            //弹出一个节点，其键值放入keys
            Node n = nodes.dequeue();
            keys.enqueue(n.key);
            //如果该节点有左子节点，放入nodes
            if(n.left!=null){
                nodes.enqueue(n.left);
            }
            //如果有右子节点，放入
            if(n.right!=null){
                nodes.enqueue(n.right);
            }
        }
        return keys;
    }
    //树的最大深度,从根开始递归，找最大子树深度+1
    public int maxDepth(){
        return maxDepth(root);
    }
    private int maxDepth(Node x){
        if(x==null){
            return 0;
        }
        int max=0;
        int maxL=0;
        int maxR=0;
        //找左子树的最大深度
        if(x.left!=null){
            maxL=maxDepth(x.left);
        }
        //找右子树的最大深度
        if(x.right!=null){
            maxR=maxDepth(x.right);
        }
        //判断最大子树深度
        max = maxL>maxR?maxL:maxR;
        return max+1;

    }
}

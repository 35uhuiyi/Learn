package Tree;
//红黑树实现
public class RedBlackTree<Key extends Comparable<Key>,Value> {
    private class Node{//节点类
        private Key key;
        private Value value;
        Node left;
        Node right;
        boolean color;
        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
    private Node root;
    private int N;
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    public RedBlackTree() {
        this.root = null;
        this.N = 0;
    }
    //判断当前节点的父节点指向连接是否为红色
    private boolean isRed(Node x){
        if (x==null){
            return false;
        }
        return x.color==RED;
    }
    //获取元素个数
    private int size(){
        return N;
    }
    //左旋
    private Node rotateLeft(Node h){
        Node x=h.right;
        h.right=x.left;
        x.left=h;
        //颜色继承
        x.color=h.color;
        //变红
        h.color=RED;
        return x;
    }
    //右旋
    private Node rotateRight(Node h){
        Node x=h.left;
        h.left=x.right;
        x.right=h;
        //颜色继承
        x.color=h.color;
        //变红
        h.color=RED;
        return x;
    }
    //颜色反转,相当于拆分4-节点
    private void filpColors(Node h){
        h.color=RED;//父节点变为红色
        //左右子节点变为黑色
        h.left.color=BLACK;
        h.right.color=BLACK;
    }
    //在整个树上完成插入
    public void put(Key key,Value value){
        root = put(root,key,value);
        root.color=BLACK;//根总是黑色的
    }
    //指定树h插入
    private Node put(Node h,Key key,Value value){
        if(h==null){//找到位置插入
            N++;
            return new Node(key,value,null,null,RED);
        }
        //比较key大小
        int cmp = h.key.compareTo(key);
        if(cmp>0){
            //向左走
            //递归
            h.left = put(h.left,key,value);
        }else if(cmp<0){
            //向右走
            h.right = put(h.right,key,value);
        }else{
            //替换
            h.value=value;
        }
        //如果左右子节点都是红色，则变色
        if(isRed(h.left)&&isRed(h.right)){
            filpColors(h);
        }
        //如果左子节点及它的左子节点都为红色，则右旋
        if(isRed(h.left)&&isRed(h.left.left)){
            h = rotateRight(h);
        }
        //如果该节点的右子节点为红色，则左旋
        if(isRed(h.right)&&!isRed(h.left)){
            h = rotateLeft(h);
        }
        return h;
    }
    //根据Key从树中找出对应的值
    public Value get(Key key){
        return get(root,key);
    }
    //从指定树x中获取值
    private Value get(Node x,Key key){
        if(x==null){//递归未找到
            return null;
        }
        int cmp=x.key.compareTo(key);
        if(cmp>0){
            //向左走
            return get(x.left,key);
        }else if(cmp<0){
            //向右走
            return get(x.right,key);
        }else{//找到
            return x.value;
        }
    }
}

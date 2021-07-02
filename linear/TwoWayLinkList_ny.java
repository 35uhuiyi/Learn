package linear;

import java.util.Iterator;

public class TwoWayLinkList_ny<T> implements Iterable<T>{
    private Node head;
    private Node last;
    private int N;
    private class Node{
        T item;
        Node pre;
        Node next;
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    public TwoWayLinkList_ny() {
        this.head = new Node(null,null,null);
        this.last = null;//初始化无尾节点
        this.N = 0;
    }

    //清空线性表
    public void clear(){
        head.next=null;
        last=null;
        this.N=0;
    }
    //判断是否为空
    public boolean isEmpty(){
        return N==0;
    }
    //获取元素个数
    public int length(){
        return N;
    }
    //读取第i个值
    public T get(int i){
        if(i>N){return null;}
        Node node = head;
        for (int j = 0; j <= i; j++) {
            node=node.next;
        }
        return node.item;
    }
    //默认添加一个元素
    public void insert(T t){
        if(isEmpty()){
            //如果是空表，则直接添加为尾节点
            Node newNode = new Node(t, head, null);
            head.next=newNode;
            last=newNode;
        }else{
            //不是空表,追加到尾部节点之后
            Node newNode = new Node(t, last, null);
            last.next=newNode;
            last=newNode;
        }
        N++;
    }
    //指定插入
    public void insert(int i,T t){
        if(i>N){
            System.out.println("越界");
        }
        if(i==0){
            insert(t);
        }
        Node preNode = head;
        for(int index = 0;index<=i-1;index++){
            preNode=preNode.next;
        }
        Node currentNode = preNode.next;//原来第i个节点
        Node newNode = new Node(t, preNode, currentNode);
        preNode.next=newNode;
        currentNode.pre=newNode;
        N++;
    }
    //删除并返回第个i元素
    public T remove(int i){
        if(i>N){ System.out.println("越界");}
        Node preNode = head;
        for(int index=0;index<=i-1;index++){
            preNode=preNode.next;
        }
        Node iNode = preNode.next;
        Node nextNode = iNode.next;
        preNode.next=nextNode;
        nextNode.pre=preNode;
        N--;
        return iNode.item;
    }
    //返回首个出现指定元素的索引
    public int indexOf(T t){
        Node node = head;
        for(int i=0;node.next!=null;i++){
            node=node.next;
            if(node.item.equals(t)){
                return i;
            }
        }
        return -1;
    }
    //获取首元素
    public T getFirst(){
        if(isEmpty()){
            System.out.println("空表");
            return null;
        }else{
            return head.next.item;
        }
    }
    //获取尾元素
    public T getLast(){
        if(isEmpty()){
            System.out.println("空表");
            return null;
        }else{
            return last.item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iiterator();
    }

    private class Iiterator implements Iterator<T>{
        private Node node;
        public Iiterator(){
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next!=null;
        }

        @Override
        public T next() {
            node=node.next;
            return node.item;
        }
    }


}

package linear;

import java.util.Iterator;

//单向链表实现
public class LinkList_ny<T> implements Iterable{
    private Node head;
    private int N;

    private class Node{//节点类
        T item;
        Node next;

        public Node(T item, Node next){//节点类构造
            this.item=item;
            this.next=next;
        }
    }
    public LinkList_ny(){
        this.head=new Node(null,null);
        this.N=0;
    }

    //清空链表
    public void clear(){
        head.next=null;
        this.N=0;
    }
    //判断表是否为空，是返回true
    public boolean isEmpty(){
        return N==0;
    }
    //获取元素个数
    public int length(){
        return N;
    }
    //读取第i个元素的值
    public T get(int i){
        Node node=head;
        for(int index=0;index<=i;index++){
            node=node.next;
        }
        return node.item;
    }
    //向表中默认添加元素
    public void insert(T t){
        Node node=head;
        while(node.next!=null){
            node=node.next;
        }
        Node newNode = new Node(t,null);
        node.next=newNode;
        N++;
    }
    //在指定位置i处添加元素
    public void insert(int i,T t){
        Node preNode = head;
        for(int index=0;index<=i-1;index++){
            preNode=preNode.next;
        }
        Node nextNode = preNode.next;
        Node currentNode = new Node(t,nextNode);
        preNode.next=currentNode;
        N++;
    }
    //删除并返回第i个元素
    public T remove(int i){
        Node preNode=head;
        for(int index=0;index<=i-1;index++){
            preNode=preNode.next;
        }
        Node iNode = preNode.next;
        Node nextNode = iNode.next;
        preNode.next=nextNode;
        N--;
        return iNode.item;
    }
    //返回线性表中首次出现指定元素的索引
    public int indexOf(T t){
        Node node = head;
        for(int index=0;node.next!=null;index++){
            node=node.next;
            if(node.item.equals(t)){
                return index;
            }
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {

        return new iterator();
    }
    public class iterator implements Iterator{
        private Node n;
        public iterator(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.item;
        }
    }

    //反转链表
    public void reverse(){
        if(isEmpty()){//空表返回
            return;
        }
        reverse(head.next);//从头开始反转
    }
    public  Node reverse(Node curr){//反转节点函数
        if(curr.next==null){//直到结束
            head.next=curr;
            return curr;
        }
        Node ptr = reverse(curr.next);//反转当前节点的下一个节点
        ptr.next=curr;//反转后的下一个节点指向当前节点
        curr.next=null;//当前节点指向空
        return curr;
    }

}

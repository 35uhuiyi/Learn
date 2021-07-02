package alg4.c1.c1_3;

import java.util.Iterator;

//双向队列--双向链表实现
public class Dequeue<Item> implements Iterable<Item>{
    private class Node{
        private Item item;
        private Node pre;
        private Node next;
        public Node(Item item) {
            this.item = item;
        }
    }
    private int N;
    private Node head;
    private Node last;
    public Dequeue() {
        this.N = 0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void pushLeft(Item t){
        //左端插入
        if(isEmpty()){
            //插入第一个元素
            head = new Node(t);
            last=head;
        }else{
            Node oldLeft = this.head;
            head = new Node(t);
            head.next=oldLeft;
            oldLeft.pre=head;
        }
        N++;//末尾再加
    }
    public void pushRight(Item t){
        //右端插入
        if(isEmpty()){
            last = new Node(t);
            head=last;
        }
        Node oldRight = last;
        last = new Node(t);
        oldRight.next=last;
        last.pre=oldRight;
        N++;
    }
    public Item popLeft(){
        //左端弹出元素
        if(isEmpty()){
            return null;
        }
        Item item = head.item;
        head=head.next;//重新赋head
        if(N==1){
            head=null;
            last=null;
        }else{
            head.pre=null;//删除旧head
        }
        N--;
        return item;
    }
    public Item popRight(){
        //删除尾节点
        if(isEmpty()){
            return null;
        }
        Item item = last.item;
        last=last.pre;//重新pre
        if(N==1){
            head=null;
            last=null;
        }else{
            last.next=null;//删除旧pre
        }
        N--;
        return item;
    }

    // 输出链表
    public void sysNode() {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.item + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void print(){
        Node current=head;
        while(current!=null){
            System.out.print(current.item+"  ");
            current=current.next;
        }
        System.out.println();
    }


    @Override
    public Iterator<Item> iterator() {
        return new DIterarot();
    }
    private class DIterarot implements Iterator{

        private Node n;

        public DIterarot() {
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n!=null;
        }

        @Override
        public Object next() {
            Item item = n.item;
            n=n.next;
            return item;
        }
    }


}

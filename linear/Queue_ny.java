package linear;

import java.util.Iterator;

//队列实现
public class Queue_ny<T> implements Iterable<T> {


    private class Node{
        T item;
        Node next;
        public Node(T t,Node next){
            this.item=t;
            this.next=next;
        }
    }
    private Node head;
    private int N;
    private Node last;

    public Queue_ny(){
        this.N=0;
        this.head=new Node(null,null);
        this.last=null;
    }
    //判断空
    public boolean isEmpty(){
        return N==0;
    }
    //获取个数
    public int size(){
        return N;
    }
    //插入元素
    public void enqueue(T t){
        if(isEmpty()){
            //如果是空表，插入的即是尾节点
            Node newNode = new Node(t,null);
            last=newNode;
            head.next=newNode;
        }else {
            //非空,新插入的元素变为尾节点
            Node oldLast = last;//原尾
            Node newLast = new Node(t,null);
            oldLast.next=newLast;
            last=newLast;
        }
        N++;
    }
    //拿出元素
    public T dequeue(){
        if(isEmpty()){
            last=null;//拿出为空表后，重置last为空
            return null;
        }
        Node oldFirst =head.next;//原来首节点
        head.next=oldFirst.next;
        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new QIterator();
    }

    public class QIterator implements Iterator{
        private Node n;
        public QIterator(){
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




}

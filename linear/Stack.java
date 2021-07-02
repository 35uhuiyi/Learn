package linear;
import java.util.ArrayList;
import java.util.Iterator;

//利用单向链表实现栈
public class Stack<T> implements Iterable<T>{//遍历用泛型

    private class Node{//不用泛型
        T item;
        Node next;
        public Node(T t,Node next){
            this.item=t;
            this.next=next;
        }
    }
    private Node head;
    private int N;
    public Stack(){
        this.head=new Node(null,null);
        this.N=0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    //压栈
    public void push(T t){
        Node oldFirst = head.next;//原栈顶元素
        Node newNode = new Node(t, null);
        newNode.next=oldFirst;
        head.next=newNode;
        N++;
    }
    //弹栈
    public T pop(){
        Node oldFirst = head.next;
        if(oldFirst==null){
            return null;
        }
        head.next=oldFirst.next;
        N--;
        return oldFirst.item;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }
    public class SIterator implements Iterator{
        private Node n;
        public SIterator() {
            this.n = head;
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

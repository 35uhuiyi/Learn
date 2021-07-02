package SymbolTable;

import java.util.Iterator;

//利用单向链表实现符号表
public class SymbolTable<Key, Value> implements Iterable<Key> {

    private class Node{
        Key key;
        Value value;
        Node next;
        public Node(Key key,Value value,Node next){
            this.key=key;
            this.value=value;
            this.next=next;
        }
    }
    private Node head;
    private int N;
    public SymbolTable(){
        this.head=new Node(null,null,null);
        this.N=0;

    }
    //大小
    public int size(){
        return N;
    }
    //插入键值对方法
    public void put(Key key,Value value){
        //如果已有Key,替换value
        Node n=head;
        while (n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                n.value=value;
                return;//不用减N,直接退出
            }
        }
        //没有直接加
        Node oldFirst = head.next;
        Node newNode = new Node(key, value, oldFirst);
        head.next=newNode;
        N++;
    }
    //删除键key
    public void delete(Key key){
        Node n=head;
        while (n.next!=null){
            if(n.next.key.equals(key)){
                n.next=n.next.next;
                N--;
                return;
            }
            n=n.next;
        }
    }
    //根据Key获取Value
    public Value get(Key key){
        Node n=head;
        while (n.next!=null){
            n=n.next;
            if(n.key.equals(key)){
                return n.value;
            }
        }
        return null;
    }
    @Override
    public Iterator<Key> iterator() {
        return null;
    }
    public class SItertor implements Iterator{
        private Node n;
        public SItertor(){
            this.n=head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n=n.next;
            return n.key;
        }
    }

}

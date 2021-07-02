package alg4.c1.test;

import java.util.Iterator;

public class Dequeue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;


    public Dequeue(){

    }

    private class Node{
        private Node pre;
        private Node next;
        private Item item;
    }
    private int size(){
        return N;
    }

    private boolean isEmpty(){
        return N==0;
    }

    public void pushLeft(Item item){
        if(isEmpty()){
            first=new Node();
            first.item=item;
            last=first;
        }
        else{
            Node oldFirst=first;
            first=new Node();
            first.item=item;
            first.next=oldFirst;
            oldFirst.pre=first;
        }
        N++;
    }

    public void pushRight(Item item){
        if(isEmpty()){
            last=new Node();
            last.item=item;
            first=last;
        }else{
            Node oldLast=last;
            last=new Node();
            last.item=item;
            last.pre=oldLast;
            oldLast.next=last;
        }
        N++;
    }

    public Item popLeft() throws Exception{
        //当为空时报错
        if(isEmpty()){
            throw new Exception("没有了");
        }
        Item item=first.item;
        first=first.next;
        if(N==1){
            first=last=null;
            //只有一个值在队列中，first=first.next;last,first都为null了
        }
        else{
            first.pre=null;
        }
        N--;
        return item;
    }

    public Item popRight() throws Exception{
        if(isEmpty()){
            throw new Exception("没有啦");
        }
        Item item=last.item;
        last=last.pre;
        if(N==1){
            first=last=null;
        }
        else{
            last.next=null;
        }
        N--;
        return item;
    }

    public void print(){
        Node current=first;
        while(current!=null){
            System.out.print(current.item+"  ");
            current=current.next;
        }
        System.out.println();
    }




    @Override
    public Iterator iterator() {
        return new Iterator(){
            Node current=first;
            @Override
            public boolean hasNext() {
                return current!=null;
            }

            @Override
            public Item next() {
                Item item=current.item;
                current=current.next;
                return item;
            }
        };
    }

    //反向迭代
    public Iterable reverseIterator(){
        return new Iterable(){
            @Override
            public Iterator iterator() {
                return new Iterator(){
                    Node current=last;
                    @Override
                    public boolean hasNext() {
                        return current!=null;
                    }

                    @Override
                    public Item next() {
                        Item item=current.item;
                        current=current.pre;
                        return item;
                    }
                };
            }

        };

    }
}

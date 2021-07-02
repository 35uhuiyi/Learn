package SymbolTable;
//有序的符号表
public class OrderSymbolTable<Key extends Comparable,Value> {
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
    public OrderSymbolTable(){
        this.head=new Node(null,null,null);
        this.N=0;

    }
    //大小
    public int size(){
        return N;
    }
    //插入键值对方法
    public void put(Key key,Value value){
        Node curr = head.next;//要插入的位置
        Node pre = head;//插入位置的前一个位置
        while(curr!=null&&key.compareTo(curr.key)>0){//当前位置不为空，
            //后移
            pre=curr;
            curr=curr.next;
        }
        if(curr!=null && key.compareTo(curr.key)==0){
            //键相同，替换元素
            curr.value=value;
            return;
        }
        //插入元素
        Node newNode = new Node(key, value, curr);
        pre.next=newNode;
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
}

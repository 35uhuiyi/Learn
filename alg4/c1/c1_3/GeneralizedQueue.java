package alg4.c1.c1_3;
//队列删除第k个元素
//链表实现
public class GeneralizedQueue<Item> {
    private int N;
    private Node first;
    private Node last;
    private  class Node{
        private Item item;
        private Node next;
        public Node(Item t) {
            this.item = t;
        }
    }
    public GeneralizedQueue() {
        N = 0;
    }
    public boolean isEmpty(){
        return N==0;
    }
    public int size(){
        return N;
    }
    public void insert(Item t){
        if(isEmpty()){
            first = new Node(t);
            last=first;
        }else{
            //尾部插入
            Node oldLast = last;
            Node newNode =  new Node(t);
            oldLast.next=newNode;
            last=newNode;
        }
        N++;
    }
    public Item delete(int k){
        Node n=first;
        for (int i = 1; i < k-2; i++) {
            n=n.next;
        }
        n.next=n.next.next;
        N--;
        return n.next.item;
    }
}

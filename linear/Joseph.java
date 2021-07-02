package linear;
//约瑟夫问题
public class Joseph {
    private static class Node<T>{//节点类
        T item;
        Node next;
        public Node(T t, Node next){
            this.item=t;
            this.next=next;
        }
    }
    public static void main(String[] args) {
        Node<Integer> firstNode = null;
        Node<Integer> prePtr = null;//前一个节点的指针
        //1.生成循环单向链表1-41
        for(int i=1;i<=7;i++){
            if(i==1){
               firstNode = new Node<>(i,null);
               prePtr = firstNode;
               continue;
            }
            Node newNode = new Node<>(i,null);
            prePtr.next=newNode;
            prePtr=newNode;
            if(i==7){
                prePtr.next=firstNode;
            }
        }
        //2.报数
        int count = 0;
        //3.删除元素
        //从1号开始
        Node<Integer> node = firstNode;
        //定义一个临时节点---前一个节点
        Node<Integer> preNode = null;

        while (node!=node.next){
            count++;
            if(count==2){
                preNode.next=node.next;//前一个直接指向后一个
                count=0;
                node=node.next;
                System.out.print(node.item+",");
            }else {
                //没到3时
                preNode=node;
                node=node.next;
            }
        }
        System.out.println("最后的元素："+node.item);
    }
}

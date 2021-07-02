package alg4.c1.c1_3;

import edu.princeton.cs.algs4.In;

//用链表实现约瑟夫问题
public class JosephusList {
    private static class Node{
        private int i;
        private Node next;
        public Node(int i) {
            this.i = i;
        }
    }
    //生成循环表
    public static void main(String[] args) {
        int N=7;
        int M=2;
        Node first = null;
        Node pre = null;
        for (int i = 0; i < N; i++) {
            if(i==0){
                //首节点
                first = new Node(i);
                pre=first;
                continue;
            }
            Node newNode = new Node(i);
            pre.next=newNode;
            pre=newNode;
            if(i==N-1){
                pre.next=first;
            }
        }
        int cnt=0;
        Node p = null;
        Node n = first;
        while (n.next!=n){
            cnt++;
            if(cnt==M){
                p.next=n.next;
                System.out.println("del:"+n.i);
                cnt=0;
                n=n.next;//继续移动！！
                continue;
            }
            p=n;
            n=n.next;
        }
        System.out.println("last:"+n.i);
    }
}

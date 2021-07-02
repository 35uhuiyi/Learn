package alg4.c1.c1_3;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

//前移编码--链表实现
public class MoveToFront<Item> {
    private int N;
    private Node first;
    //
    private class Node {
        Item item;
        Node next;
    }
    //
    public void insertToFirst(Item item)
    {
        Node oldfirst=first;
        first=new Node();
        first.item=item;
        first.next=oldfirst;
        N++;

        Node current=first;
        while(current.next!=null)
        {
            if(current.next.item.equals(item))
            {
                Node repeat=current.next;
                current.next=current.next.next;
                repeat.next=null;
                N--;
                break;
            }
            current=current.next;
        }
    }

    public boolean isEmpty()
    {return N==0;}

    public int size()
    {return N;}

    public void showAll()
    {
        Node current=first;
        while(current!=null)
        {
            StdOut.print(current.item+" ");
            current=current.next;
        }
    }

    public static void main(String[] args)
    {
        MoveToFront<String> list=new MoveToFront<String>();
        String item="abcdec";
        list.insertToFirst(item);
        list.showAll();
    }//end main
}//end class
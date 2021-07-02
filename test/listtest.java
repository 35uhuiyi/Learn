package test;

import linear.LinkList_ny;
import linear.SequenceList;
import linear.TwoWayLinkList_ny;
import sort.Insertion;

public class listtest {

    public static void main(String[] args) {
        LinkList_ny<Integer> ll = new LinkList_ny<Integer>();
        //SequenceList<Integer> ll = new SequenceList<>(4);
        //TwoWayLinkList_ny<Integer> ll = new TwoWayLinkList_ny<>();
        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);

        //System.out.println(ll.get(1));
        ll.insert(3,90);
        //ll.clear();
        for (Object o : ll) {
            System.out.println(o
            );
        }
        //System.out.println(ll.length());
       /* ll.insert(3,90);
        System.out.println(ll.get(4));
        System.out.println(ll.length());*/
     /*  ll.reverse();
        for (Object o : ll) {
            System.out.println(o);
        }
*/
    }
}

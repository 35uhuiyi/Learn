package alg4.Leetcode.ListNode;

import java.util.TreeSet;

public class reverse {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


  //迭代法：从前向后,一个一个的转
  public ListNode r1(ListNode node){
        ListNode pre = null;
        ListNode curr = node;
        while (curr!=null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
  }

  //递归法，由大及小
    public ListNode dgf(ListNode x){
        //即第一个结点，与后面所有结点的集合，这两个组之间的调用互转
        if (x == null || x.next ==null) {
            //出口，即只剩下最后一个结点了
            return x;
        }
        ListNode p = dgf(x.next);
        x.next.next = x;
        x.next = null;
        return p;

    }

}

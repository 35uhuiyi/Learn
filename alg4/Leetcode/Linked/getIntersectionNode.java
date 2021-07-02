package alg4.Leetcode.Linked;


/*160. 相交链表
        编写一个程序，找到两个单链表相交的起始节点。

        如下面的两个链表：
        输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

。*/
public class getIntersectionNode {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
             next = null;
          }
      }

    public static ListNode getIntersectionNodef(ListNode headA, ListNode headB) {
          ListNode pA = headA;
          ListNode pB = headB;
          int i=0;
/*          while (pA!=pB){
            pA = pA==null?headB:pA.next;
            pB = pB==null?headA:pB.next;
          }*/
            while (pA.next!=null){
                pA=pA.next;
            }
            int a = pA.val;
            while (pB.next!=null){
                pB= pB.next;
            }
            int b = pB.val;
            if(a!=b){
                System.out.println("none");
            }
          return pA;
    }

    public static void main(String[] args) {
          ListNode headA = new ListNode(4);
          ListNode headA2 = new ListNode(1);
          ListNode headA3 = new ListNode(8);
          ListNode headA4 = new ListNode(4);
          ListNode headA5 = new ListNode(5);
          headA.next = headA2;
          headA2.next = headA3;
          headA3.next = headA4;
          headA4.next = headA5;

        ListNode headB = new ListNode(5);
        ListNode headB2 = new ListNode(0);
        ListNode headB3 = new ListNode(1);
        ListNode headB4 = new ListNode(8);
        ListNode headB5 = new ListNode(4);
        ListNode headB6 = new ListNode(5);
        headB.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;


        ListNode interf = getIntersectionNode.getIntersectionNodef(headA, headB);
        System.out.println(interf.val);


    }

}

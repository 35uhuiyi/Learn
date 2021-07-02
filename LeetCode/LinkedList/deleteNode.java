package LeetCode.LinkedList;

/**
 * @author yang
 * @version 1.0
 * @date 2021/4/14 21:52
 */



public class deleteNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode delete(ListNode head, int val){
        if(head.val==val){
            return head.next;
        }
        ListNode pre = head, cur = head.next;
        while(cur!=null&&cur.val!=val){
            pre = cur;
            cur = cur.next;
        }
        if(cur!=null){
            pre.next = cur.next;
        }
        return head;
    }

}

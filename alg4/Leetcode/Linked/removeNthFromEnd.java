package alg4.Leetcode.Linked;
/*19. 删除链表的倒数第N个节点
        给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

        示例：

        给定一个链表: 1->2->3->4->5, 和 n = 2.

        当删除了倒数第二个节点后，链表变为 1->2->3->5.
        说明：

        给定的 n 保证是有效的。

        进阶：

        你能尝试使用一趟扫描实现吗？*/
public class removeNthFromEnd {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(){
      }
      ListNode(int x) { val = x;}
    }
    public static ListNode removeNthFromEndf(ListNode head, int n) {
        ListNode newNode = new ListNode(0);//头指针，
        newNode.next = head;
        ListNode fast = newNode;
        ListNode slow = newNode;
        for (int i = 0; i < n+1; i++) {//因为有头指针，多走一步
            fast = fast.next;
        }
        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        printListNode(l1);
        ListNode re = removeNthFromEndf(l1, 2);
        printListNode(re);
    }
    public static void printListNode(ListNode x){
        StringBuilder sb = new StringBuilder();
        while (x!=null){
            sb.append(x.val+"->");
            x = x.next;
        }
        String s = sb.toString();
        System.out.println(s.substring(0,s.length()-2));
    }

}

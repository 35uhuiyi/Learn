package alg4.offer;

import java.util.List;

/**
 * @author yang
 * @version 1.0
 * @date 2021/6/3 21:39
 */


class ListNode {
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
    }
}
public class linkSUm {


    public ListNode addInList (ListNode head1, ListNode head2) {
        int a = 0, b=0;
        while(head1!=null){
            a = 10*a+head1.val;
            head1=head1.next;
        }
        while (head2!=null){
            b = 10*b+head2.val;
            head2 = head2.next;
        }
        String s = a+b+"";

        ListNode res= new ListNode(0);
        for(int i=0;i<s.length();i++){
            add(res, s.charAt(i)-'0');
        }
        return res.next;
    }
    private void add(ListNode node,int x){
        while(node!=null){
            if(node.next==null){
                node.next = new ListNode(x);
                break;
            }
            node = node.next;
        }
    }

    private ListNode reverse(ListNode node){
        if(node==null||node.next==null) return node;
        ListNode p = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return p;
    }



    private ListNode h(ListNode l1, ListNode l2){
        l1 = reverse(l1);
        l2 = reverse(l2);
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(l1!=null||l2!=null||carry!=0){
            int sum = carry;
            if(l1!=null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                sum += l2.val;
                l2 = l2.next;
            }
            node.next = new ListNode(sum%10);
            carry = sum/10;
            node = node.next;
        }
        return dummy.next;
    }



    private ListNode l1 = new ListNode(9);
    ListNode l2 = new ListNode(3);
    ListNode l3 = new ListNode(7);

    ListNode l4 = new ListNode(6);
    ListNode l5 = new ListNode(3);


    public linkSUm(){
        l1.next = l2;
        l2.next = l3;
        l4.next = l5;
    }


    public static void main(String[] args) {
        linkSUm s = new linkSUm();
        ListNode node = s.reverse(s.l1);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }

}

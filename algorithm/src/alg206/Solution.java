package alg206;

/**
 * 反转链表
 * @author LaZY(李志一)
 * @create 2019-04-18 13:35
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public ListNode reverseList(ListNode head){
//        if(head == null){
//            return null;
//        }
//        ListNode node = head;
//        while(head.next != null){
//            head = head.next;
//            ListNode current = head;
//            current.next = node;
//            node = current;
//        }
//        return node;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

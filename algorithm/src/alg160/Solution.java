package alg160;

/**
 * @author LaZY(李志一)
 * @create 2019-04-15 21:30
 */
public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode nodeA = circl(headA);
        ListNode nodeB = circl(headB);
        if(nodeA != null && nodeB != null){
            //有环
            if(nodeA == nodeB){

            }else {
                ListNode cur = nodeA;
                while (cur != null){
                    if(cur == nodeB){
                        return nodeB;
                    }
                    cur = cur.next;
                }
            }
        }else {
            //无环
            int lenthA = listLenth(headA);
            int lenthB = listLenth(headB);
            int len = lenthA - lenthB;
            if(len > 0){
                for (int i = 0; i < len; i++) {
                    headA = headA.next;
                }
            }else {
                for (int i = 0; i < len; i++) {
                    headB = headB.next;
                }
            }
            while (headA != null && headB != null){
                if(headA == headB){
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    private int listLenth(ListNode headA) {
        int lenthA = 1;
        while (headA != null){
            headA = headA.next;
            lenthA++;
        }
        return lenthA;
    }

    private ListNode circl(ListNode headA) {
        ListNode fast = headA;
        ListNode slow = headA;
        while (fast != null && fast.next != null && slow!= null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if(slow == fast){
            fast = headA;
            while (true){
                if (fast == slow){
                    return fast;
                }
            }
        }else {
            return null;
        }
    }

}

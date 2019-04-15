package alg142;

/**LeetCode142. 环形链表 II
 * @author LaZY(李志一)
 * @create 2019-04-15 8:15
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode sp = head;
        ListNode fp = head;
        if (head == null) {
            return null;
        }
        while (true) {
            if (fp.next == null || fp.next.next == null) {
                return null;
            }
            sp = sp.next;
            fp = fp.next.next;
            if (sp == fp) {
                break;
            }
        }
        sp = head;
        while (sp != fp) {
            sp = sp.next;
            fp = fp.next;
        }
        return sp;
    }
}

package alg21;


/**
 * 合并两个有序链表
 * @author LaZY(李志一)
 * @create 2019-04-15 10:49
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

    /***
     *
     * @param l1
     * @param l2
     * @return
     */
    public  ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        ListNode res = new ListNode(Integer.MAX_VALUE);
        ListNode head = res;
        while(l1 != null && l2 != null){
            //遍历相同长度部分
            int min = 0;
            if(l1.val < l2.val){
                res.next = new ListNode(l1.val);
                l1 = l1.next;
                res = res.next;
            }else {
                res.next = new ListNode(l2.val);
                l2 = l2.next;
                res = res.next;
            }
        }
        res.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);//124
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);//134
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);


        ListNode res = new Solution().mergeTwoLists(l1,l2);
        while (res!= null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}

package alg2;

/**
 * 题目：
 * 给出两个 非空 的链表用来表示两个非负的整数。
 * 其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author LaZY(李志一)
 * @create 2019-02-14 19:07
 */
public class Solution {

    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode listNode = new ListNode(0);
        ListNode p =listNode;//指针
        int carry = 0;// 进位携带
        int sum = 0;
        while(l1 != null || l2 != null){//可能两个链表长度不相同
            int n1 = (l1 != null ) ? l1.val : 0;
            int n2 = (l2 != null ) ? l2.val : 0;
            sum = n1 + n2 + carry;
            carry = sum / 10;// 进位携带
            p.next = new ListNode(sum % 10);
            p = p.next;

            if(l1!=null) l1 = l1.next;//可能两个链表长度不相同
            if(l2!=null) l2 = l2.next;
        }
        if (carry > 0){//最后，进位处理
            sum += carry * 10;
        }
        return  listNode.next;//
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = new Solution().addTwoNumbers(l1, l2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}

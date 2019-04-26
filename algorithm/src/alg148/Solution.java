package alg148;

/**
 * 链表排序
 * 解题思路：
 * 题目要求：O(N*logN)时间复杂度，会很敏感的想到归并排序。
 * 接下来要说的就是根据归并排序找到中间点，这个困扰了我，虽然做了很多题，但还是忘记了快慢指针！
 * 找到中间点以后就是合并部分，这个就是合并两个链表/数组的问题
 * 总体思路还是很清晰，剩下就是代码能力了。
 *
 * code易错点：获取到中间点后，在合并的时候，前半部分要去掉中间点之后的部分
 * 引用传递
 * @author LaZY(李志一)
 * @create 2019-04-26 20:19
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return head == null ? null:mergeSort(head);
    }

    public ListNode mergeSort(ListNode head) {
        if (head.next == null){//basecase
            return head;
        }

        ListNode premid = getMid(head);//中间点的前一个节点
        ListNode mid = premid.next;//中间节点
        premid.next = null;//让前半部分中间点之后割掉
        head = mergeSort(head);//两部分分别做归并排序
        mid = mergeSort(mid);
        return merge(head,mid);//合并
    }

    /***
     * 获取中间点(返回的是他的前一个节点)
     * @param head
     * @return
     */
    public ListNode getMid(ListNode head) {
        ListNode slow = head;//慢指针
        ListNode fast = head;//快指针
        ListNode preSlow = null;//慢指针的前一个节点
        while(fast != null && fast.next != null){
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return preSlow;
    }

    /***
     * 合并两个链表
     * @param head
     * @param mid
     * @return
     */
    public ListNode merge(ListNode head,ListNode mid){
        ListNode merge = new ListNode(0);
        ListNode p = merge;
        while(head != null && mid != null){
            if(head.val <= mid.val){
                p.next = head;
                p = p.next;
                head = head.next;
            }else {
                p.next = mid;
                p = p.next;
                mid = mid.next;
            }
            if(head != null){
                p.next = head;
            }else if(mid != null){
                p.next = mid;
            }
        }
        return merge.next;
    }
}

class ListNode {
    int val; // 当前节点的数值
    ListNode next; // 下一个节点

    ListNode(int x) { // 给当前节点的数值赋值
        val = x;
    }
}

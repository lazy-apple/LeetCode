package alg141;

import java.util.HashSet;

/**
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * @author LaZY(李志一)
 * @create 2019-02-22 19:14
 */
public class Solution {
    /***
     * 哈希表法：
     *  1.哈希表中不存在节点，返回true;
     *  2.不存在，哈希表中添加节点,指针指向下一个节点
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head){
        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        while (head != null){
            if (hashSet.contains(head)){
                return true;
            }else {
                hashSet.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /***
     * 快慢指针法：
     * 如果是环，一定存在一刻相遇
     * @param listNode
     * @return
     */
    public static boolean hasCycle2(ListNode listNode){
        if(listNode == null || listNode.next == null){
            return false;
        }
        ListNode fast = listNode.next;
        ListNode slow = listNode;
        while (slow != fast){
            if (fast == null || fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }
}

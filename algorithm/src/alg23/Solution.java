package alg23;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

 示例:

 输入:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 输出: 1->1->2->3->4->4->5->6

 * @author LaZY(李志一)
 * @create 2019-02-23 9:31
 */
public class Solution {
    /***
     * 1.验证参数（0,1）
     * 2.含有两个以上链表，则两两合并
     * 3.合并：取两个链表的元素比较，添加到新的链表（注意链表长度）
     * @param lists
     */
    public static ListNode mergeLists(ListNode[] lists){
        ListNode res = null;
        if(lists == null || lists.length == 0){
            return null;
        }
        if (lists.length == 1){
            return lists[0];
        }
        for(int i = 0;i<lists.length;i++){
            res = mergeTwo(lists[i],res);
        }
        return res;
    }
    public static ListNode mergeTwo(ListNode node1,ListNode node2){
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (node1 != null && node2 != null){
            if (node1.val < node2.val){
                p.next = node1;
                node1 = node1.next;
            }else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        //处理两个链表长度不等情况
        if (node1 != null){
            p.next = node1;
        }else if (node2 != null){
            p.next = node2;
        }
        return res.next;
    }
}


//class MinStack {
////
////    public ListNode merge2Lists(ListNode l1,ListNode l2){
////        if(l1 == null) return l2;
////        if(l2 == null) return l1;
////        ListNode dummy = new ListNode(0);
////        ListNode l3 = dummy;
////        while(l1!=null&&l2!=null){
////            if(l1.val>l2.val){
////                ListNode node = new ListNode(l2.val);
////                l3.next = node;
////                l3 = l3.next;
////                l2 = l2.next;
////            }else{
////                ListNode node = new ListNode(l1.val);
////                l3.next = node;
////                l3 = l3.next;
////                l1 = l1.next;
////            }
////        }
////        if(l1!=null){
////            l3.next = l1;
////        }
////        if(l2!=null){
////            l3.next = l2;
////        }
////        return dummy.next;
////
////    }
////
////    public ListNode mergeKLists(ListNode[] lists) {
////        if(lists==null || lists.length == 0) return null;
////
////        int len = lists.length;
////        while(len>1){
////            int k = (len+1)/2;
////            //前半部分，后半部分，两两合并
////            for(int i = 0;i<len/2;i++) lists[i] = merge2Lists(lists[i],lists[k+i]);
////            len = k;
////        }
////        return lists[0];
////
////    }
////}

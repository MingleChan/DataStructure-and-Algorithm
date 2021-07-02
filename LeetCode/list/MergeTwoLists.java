package list;

/**
 * LeetCode 21. 合并两个有序链表
 */
class MergeTwoLists {
    /**
     * 迭代法合并两个单链表
     * @param p1
     * @param p2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode p1, ListNode p2) {
        if(p1 == null) return p2;
        if(p2 == null) return p1;
        ListNode prehead = new ListNode(-1);
        ListNode cur = prehead;
        while(p1 != null && p2 != null){
            if(p1.val < p2.val){
                cur.next = p1;
                p1 = p1.next;
            } else {
                cur.next = p2;
                p2 = p2.next;
            }
            cur = cur.next;
        }
        cur.next = p1 == null ? p2:p1;
        return prehead.next;
    }

    /**
     * 递归法合并两个单链表
     * @param p1
     * @param p2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode p1, ListNode p2) {
        if(p1 == null)
            return p2;
        else if(p2 == null)
            return p1;
        else {
            ListNode head = null;
            if(p1.val < p2.val){
                head = p1;
                head.next = mergeTwoLists2(p1.next, p2);
            } else{
                head = p2;
                head.next = mergeTwoLists2(p1, p2.next);
            }
            return head;
        }
    }
}

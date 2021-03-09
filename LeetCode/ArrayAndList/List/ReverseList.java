package ArrayAndList.List;

/**
 * LeetCode 206. 反转链表
 */
class ReverseList {
    /**
     * 迭代法实现反转链表
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归法实现反转链表
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

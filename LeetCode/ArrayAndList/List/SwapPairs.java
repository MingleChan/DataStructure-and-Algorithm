package ArrayAndList.List;

/**
 * LeetCode 24. 两两交换链表中的节点
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

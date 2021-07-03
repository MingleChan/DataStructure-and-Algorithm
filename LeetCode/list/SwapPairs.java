package list;

/**
 * 24. 两两交换链表中的节点
 */
class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    public static void main(String[] args) {
        ListNode L5 = new ListNode(5);
        ListNode L4 = new ListNode(4, L5);
        ListNode L3 = new ListNode(3, L4);
        ListNode L2 = new ListNode(2, L3);
        ListNode L1 = new ListNode(1, L2);
        SwapPairs s = new SwapPairs();
        ListNode head = s.swapPairs(L1);
        ListNode.printList(head);
    }
}

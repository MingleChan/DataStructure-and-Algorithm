package list;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null)
            return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode L5 = new ListNode(5);
        ListNode L4 = new ListNode(4, L5);
        ListNode L3 = new ListNode(3, L4);
        ListNode L2 = new ListNode(2, L3);
        ListNode L1 = new ListNode(1, L2);
        int n = 2;
        RemoveNthFromEnd r = new RemoveNthFromEnd();
        ListNode cur = r.removeNthFromEnd(L1, n);
        ListNode.printList(cur);
    }
}

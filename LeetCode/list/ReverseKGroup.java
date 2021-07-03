package list;

/**
 * 25. K 个一组翻转链表
 */
class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode pre = newHead;
        ListNode tail = pre;

        while (head != null) {
            for (int i = 0; i < k; ++i){
                tail = tail.next;
                if(tail == null)
                    return newHead.next;
            }
            ListNode nex = tail.next;
            tail.next = null;
            tail = head;
            head = innerReverse(tail);
            pre.next = head;
            tail.next = nex;
            pre = tail;
            head = pre.next;
        }
        return newHead.next;
    }

    private ListNode innerReverse(ListNode head){
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode L5 = new ListNode(5);
        ListNode L4 = new ListNode(4, L5);
        ListNode L3 = new ListNode(3, L4);
        ListNode L2 = new ListNode(2, L3);
        ListNode L1 = new ListNode(1, L2);
        int k = 2;
        ReverseKGroup r = new ReverseKGroup();
        ListNode head = r.reverseKGroup(L1, k);
        ListNode.printList(head);
    }
}

package list;

/**
 * LeetCode 25. K 个一组翻转链表
 */
public class ReverseKGroup {
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

    public ListNode innerReverse(ListNode head){
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
}

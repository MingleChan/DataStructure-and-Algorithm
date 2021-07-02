package list;

/**
 * 160. 相交链表
 */
class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        ListNode C3 = new ListNode(5);
        ListNode C2 = new ListNode(4, C3);
        ListNode C1 = new ListNode(8, C2);
        ListNode A2 = new ListNode(1, C1);
        ListNode A1 = new ListNode(4, A2);
        ListNode B3 = new ListNode(1, C1);
        ListNode B2 = new ListNode(0, B3);
        ListNode B1 = new ListNode(5, B2);
        GetIntersectionNode g = new GetIntersectionNode();
        ListNode cur = g.getIntersectionNode(A1, B1);
        ListNode.printList(cur);
    }
}

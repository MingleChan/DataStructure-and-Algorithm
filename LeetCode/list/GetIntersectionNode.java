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
        ListNode A1 = new ListNode(4);
        ListNode A2 = new ListNode(1);
        ListNode B1 = new ListNode(5);
        ListNode B2 = new ListNode(0);
        ListNode B3 = new ListNode(1);
        ListNode C1 = new ListNode(8);
        ListNode C2 = new ListNode(4);
        ListNode C3 = new ListNode(5);
        C1.next = C2;
        C2.next = C3;
        A1.next = A2;
        A2.next = C1;
        B1.next = B2;
        B2.next = B3;
        B3.next = C1;
        GetIntersectionNode g = new GetIntersectionNode();
        ListNode cur = g.getIntersectionNode(A1, B1);
        StringBuilder sb = new StringBuilder("[");
        while (cur != null) {
            sb.append(cur.val);
            sb.append(',');
            cur = cur.next;
        }
        if (sb.length() == 1)
            sb.append(']');
        else
            sb.setCharAt(sb.length()-1,']');
        String res = sb.toString();
        System.out.println(res);
    }
}

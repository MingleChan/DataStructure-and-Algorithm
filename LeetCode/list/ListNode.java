package list;

/**
 * ListNode
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static void printList(ListNode cur){
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

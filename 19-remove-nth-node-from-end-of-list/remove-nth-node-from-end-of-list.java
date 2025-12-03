public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 1) Find length
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        // Clamp n to [1, len]
        if (n < 1) n = 1;
        if (n > len) n = len;

        // 2) Move to the (len - n)-th node (the node before the one we remove)
        cur = dummy;
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }

        // 3) Remove
        if (cur.next != null) {
            cur.next = cur.next.next;
        }

        return dummy.next;
    }
}

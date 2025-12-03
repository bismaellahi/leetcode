// Keep default package (no `package` line).

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // Optional: Build list from a string like "[1,1,2,3,3]"
    public static ListNode deserialize(String data) {
        if (data == null) return null;
        data = data.trim();
        if (data.isEmpty() || data.equals("[]")) return null;
        data = data.replace("[", "").replace("]", "").replaceAll("\\s+", "");
        if (data.isEmpty()) return null;

        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (String p : parts) {
            if (!p.isEmpty()) {
                cur.next = new ListNode(Integer.parseInt(p));
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // Optional: Convert list to string "[1,2,3]"
    public static String serialize(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode cur = head;
        while (cur != null) {
            sb.append(cur.val);
            if (cur.next != null) sb.append(",");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // skip duplicate
            } else {
                curr = curr.next; // advance only when values differ
            }
        }
        return head;
    }

    // Local test
    public static void main(String[] args) {
        String input = "[1,1,2,3,3]";
        ListNode head = ListNode.deserialize(input);
        ListNode res = new Solution().deleteDuplicates(head);
        System.out.println(ListNode.serialize(res)); // Expected: [1,2,3]
    }
}

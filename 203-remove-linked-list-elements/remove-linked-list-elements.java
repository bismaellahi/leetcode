// No package line — keep default package so the driver can see classes.

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    // EXACT signature the driver expects:
    public static ListNode deserialize(String data) {
        if (data == null) return null;
        data = data.trim();
        // Accept "", "[]", or null as empty
        if (data.isEmpty() || data.equals("[]")) return null;

        // Normalize formats: "[1,2,3]" or "1,2,3"
        data = data.replace("[", "").replace("]", "").replaceAll("\\s+", "");
        if (data.isEmpty()) return null;

        String[] parts = data.split(",");
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (String part : parts) {
            if (part.isEmpty()) continue;
            current.next = new ListNode(Integer.parseInt(part));
            current = current.next;
        }
        return dummy.next;
    }

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    // Simple local test harness
    public static void main(String[] args) {
        String input = "[1,2,6,3,4,5,6]";
        int val = 6;

        ListNode head = ListNode.deserialize(input);
        ListNode result = new Solution().removeElements(head, val);
        System.out.println(ListNode.serialize(result)); // Expected: [1,2,3,4,5]
    }
}

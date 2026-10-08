public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            carry = sum / 10;
        }
        return dummy.next;
    }

    private static ListNode build(int... digits) {
        ListNode dummy = new ListNode(0), tail = dummy;
        for (int d : digits) {
            tail.next = new ListNode(d);
            tail = tail.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode res = addTwoNumbers(build(2, 4, 3), build(5, 6, 4));
        StringBuilder sb = new StringBuilder();
        for (; res != null; res = res.next) sb.append(res.val).append(' ');
        System.out.println(sb.toString().trim()); // 7 0 8
    }
}

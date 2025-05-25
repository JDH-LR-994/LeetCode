package jdh.lr.LeetCode.Medium;

public class InsertGreatestCommonDivisorsInLinkedList {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null && head.next == null) return head;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            ListNode divisor = new ListNode(gcd(prev.val, curr.val));
            divisor.next = curr;
            prev.next = divisor;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

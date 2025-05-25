package jdh.lr.LeetCode.Medium;


class ListNode {
    int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int remainder = 0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                cur.next = new ListNode((l2.val + remainder) % 10);
                remainder = (l2.val + remainder) / 10;
                l2 = l2.next;
            } else if (l2 == null) {
                cur.next = new ListNode((l1.val + remainder) % 10);
                remainder = (l1.val + remainder) / 10;
                l1 = l1.next;
            } else {
                cur.next = new ListNode((l1.val + l2.val + remainder) % 10);
                remainder = (l1.val + l2.val + remainder) >= 10 ? 1 : 0;
                l1 = l1.next;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (remainder == 1){
            cur.next = new ListNode(1);
        }
        return head.next;
    }
}
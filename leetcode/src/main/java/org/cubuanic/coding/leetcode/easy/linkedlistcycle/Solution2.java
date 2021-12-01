package org.cubuanic.coding.leetcode.easy.linkedlistcycle;

class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast && fast != null) {
            slow = slow.next;
            if (fast.next != null) fast = fast.next.next;
            else fast = fast.next;
        }

        return fast != null;
    }
}

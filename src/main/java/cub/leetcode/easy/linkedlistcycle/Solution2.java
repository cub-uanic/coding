package cub.leetcode.easy.linkedlistcycle;

import cub.leetcode.ListNode;

class Solution2 implements Solution {
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

package org.cubuanic.coding.leetcode.easy.palindromelinkedlist;

import org.cubuanic.coding.leetcode.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        ListNode half = null;

        do {
            ListNode curr = slow;
            slow = slow.next;
            fast = fast.next;
            curr.next = half;
            half = curr;
            if (fast == null) {
                slow = new ListNode(half.val, slow);
            } else {
                fast = fast.next;
            }
        } while (fast != null);

        while (slow != null && half != null && slow.val == half.val) {
            slow = slow.next;
            half = half.next;
        }

        return slow == null && half == null;
    }
}

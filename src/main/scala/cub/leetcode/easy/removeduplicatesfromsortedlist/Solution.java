package cub.leetcode.easy.removeduplicatesfromsortedlist;

import cub.leetcode.ListNode;

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) curr.next = curr.next.next;
            else curr = curr.next;
        }
        return head;
    }
}

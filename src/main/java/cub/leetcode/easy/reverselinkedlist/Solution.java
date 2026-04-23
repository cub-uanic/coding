package cub.leetcode.easy.reverselinkedlist;

import cub.leetcode.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode curr = head;
            head = head.next;
            curr.next = result;
            result = curr;
        }
        return result;
    }
}

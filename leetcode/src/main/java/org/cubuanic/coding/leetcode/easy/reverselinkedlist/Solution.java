package org.cubuanic.coding.leetcode.easy.reverselinkedlist;

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

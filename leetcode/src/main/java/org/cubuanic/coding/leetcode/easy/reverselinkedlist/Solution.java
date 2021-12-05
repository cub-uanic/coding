package org.cubuanic.coding.leetcode.easy.reverselinkedlist;

import org.cubuanic.coding.leetcode.ListNode;

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

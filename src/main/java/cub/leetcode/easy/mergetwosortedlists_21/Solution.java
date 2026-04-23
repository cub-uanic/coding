package cub.leetcode.easy.mergetwosortedlists_21;

import cub.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;

        while (list1 != null || list2 != null) {
            while (list1 != null && (list2 == null || list1.val <= list2.val)) {
                current.next = new ListNode(list1.val);
                current = current.next;
                list1 = list1.next;
            }
            while (list2 != null && (list1 == null || list2.val <= list1.val)) {
                current.next = new ListNode(list2.val);
                current = current.next;
                list2 = list2.next;
            }
        }

        return result.next;
    }
}

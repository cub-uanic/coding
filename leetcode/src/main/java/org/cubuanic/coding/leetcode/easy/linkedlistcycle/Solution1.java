package org.cubuanic.coding.leetcode.easy.linkedlistcycle;

import org.cubuanic.coding.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

class Solution1 implements Solution {
    @Override
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        Set<ListNode> seen = new HashSet<>();
        do {
            if (seen.add(head)) head = head.next;
            else return true;
        } while (head != null);

        return false;
    }
}

package org.cubuanic.coding.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static ListNode buildSimpleNodeList(int[] list) {
        ListNode head = null;
        for (int i = list.length - 1; i >= 0; i--) {
            head = new ListNode(list[i], head);
        }
        return head;
    }

    public static ListNode buildCycledNodeList(int[] list, int pos) {
        if (list.length == 0) return null;

        ListNode head = null, tail = null, loop = null, curr = null, prev;
        for (int i = list.length - 1; i >= 0; i--) {
            prev = curr;
            curr = new ListNode(list[i]);
            if (i == 0) head = curr;
            if (i == pos) loop = curr;
            if (i == list.length - 1) tail = curr;
            curr.next = prev;
        }

        if (pos != -1) tail.next = loop;

        return head;
    }

    public static void destroyNodeList(ListNode head) {
        while (head != null && head.next != null) {
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
    }

    public static int[] nodeListToArray(ListNode input) {
        List<Integer> result = new ArrayList<>();
        while (input != null) {
            result.add(input.val);
            input = input.next;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static List<Integer> intArrayToList(int[] expected) {
        return Arrays.stream(expected).boxed().toList();
    }
}

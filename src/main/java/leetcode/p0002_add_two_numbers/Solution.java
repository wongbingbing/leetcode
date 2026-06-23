package leetcode.p0002_add_two_numbers;

import java.util.ArrayList;
import java.util.List;

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
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversedL1 = reverse(l1);
        ListNode reversedL2 = reverse(l2);

        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carryDigit = 0;
        while (reversedL1 != null && reversedL2 != null) {
            int sum = reversedL1.val + reversedL2.val + carryDigit;
            carryDigit = sum / 10;
            int value = sum % 10;

            current.next = new ListNode(value);
            current = current.next;

            reversedL1 = reversedL1.next;
            reversedL2 = reversedL2.next;
        }

        while (reversedL1 != null) {
            int sum = reversedL1.val + carryDigit;
            carryDigit = sum / 10;
            int value = sum % 10;

            current.next = new ListNode(value);
            current = current.next;

            reversedL1 = reversedL1.next;
        }

        while (reversedL2 != null) {
            int sum = reversedL2.val + carryDigit;
            carryDigit = sum / 10;
            int value = sum % 10;

            current.next = new ListNode(value);
            current = current.next;

            reversedL2 = reversedL2.next;
        }

        if (carryDigit != 0) {
            current.next = new ListNode(carryDigit);
            current = current.next;
        }

        return dummy.next;
    }

    public ListNode reverse(ListNode listNode) {
        ListNode current = listNode;
        List<ListNode> nodes = new ArrayList<>();
        while (current != null) {
            nodes.add(current);
            current = current.next;
        }

        ListNode dummy = new ListNode();
        ListNode dummyCurrent = dummy;
        for (int i = nodes.size() - 1; i >= 0; i--) {
            ListNode node = nodes.get(i);
            dummyCurrent.next = new ListNode(node.val);
            dummyCurrent = dummyCurrent.next;
        }

        return dummy.next;
    }
}

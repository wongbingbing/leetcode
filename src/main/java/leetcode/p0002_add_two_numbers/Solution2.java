package leetcode.p0002_add_two_numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution2 {
    // 心得：不要 reverse l1/l2。
    // 链表是“低位在前”（第一个节点就是个位），而加法本来就从低位开始算、进位往高位传，
    // 顺着 next 遍历正好是最舒服的方向——题目已经把数字摆成了最适合做加法的样子。
    // 之所以会想 reverse，是在用“读数字”的习惯（高位在前）思考，而不是“算加法”的方向。
    // 一句话：看到数字想“它是几”就会想 reverse；只关心“从哪头进位”就直接遍历。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        int carryDigit = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carryDigit;
            carryDigit = sum / 10;
            int value = sum % 10;

            current.next = new ListNode(value);
            current = current.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + carryDigit;
            carryDigit = sum / 10;
            int value = sum % 10;

            current.next = new ListNode(value);
            current = current.next;

            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carryDigit;
            carryDigit = sum / 10;
            int value = sum % 10;

            current.next = new ListNode(value);
            current = current.next;

            l2 = l2.next;
        }

        if (carryDigit != 0) {
            current.next = new ListNode(carryDigit);
            current = current.next;
        }

        return dummy.next;
    }
}

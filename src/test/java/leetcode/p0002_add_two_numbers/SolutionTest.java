package leetcode.p0002_add_two_numbers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static ListNode build(int... values) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static List<Integer> toList(ListNode node) {
        List<Integer> result = new ArrayList<>();
        for (ListNode n = node; n != null; n = n.next) {
            result.add(n.val);
        }
        return result;
    }

    @Test
    void example1() {
        assertEquals(List.of(7, 0, 8),
                toList(solution.addTwoNumbers(build(2, 4, 3), build(5, 6, 4))));
    }

    @Test
    void example2() {
        assertEquals(List.of(0),
                toList(solution.addTwoNumbers(build(0), build(0))));
    }

    @Test
    void example3() {
        assertEquals(List.of(8, 9, 9, 9, 0, 0, 0, 1),
                toList(solution.addTwoNumbers(build(9, 9, 9, 9, 9, 9, 9), build(9, 9, 9, 9))));
    }

    @Test
    void example4() {
        assertEquals(List.of(7, 0, 4, 0, 1),
                toList(solution.addTwoNumbers(build(2, 4, 9), build(5, 6, 4, 9))));
    }
}

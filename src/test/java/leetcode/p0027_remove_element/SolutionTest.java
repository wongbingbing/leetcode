package leetcode.p0027_remove_element;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    // 题目说明顺序不重要,沿用 Custom Judge 的做法:
    // 取前 k 个元素排序后,与排序后的期望结果比较。
    private static List<Integer> firstKSorted(int[] nums, int k) {
        int[] head = Arrays.copyOf(nums, k);
        Arrays.sort(head);
        List<Integer> result = new ArrayList<>();
        for (int num : head) {
            result.add(num);
        }
        return result;
    }

    @Test
    void example1() {
        int[] nums = {3, 2, 2, 3};
        int k = solution.removeElement(nums, 3);
        assertEquals(2, k);
        assertEquals(List.of(2, 2), firstKSorted(nums, k));
    }

    @Test
    void example2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int k = solution.removeElement(nums, 2);
        assertEquals(5, k);
        assertEquals(List.of(0, 0, 1, 3, 4), firstKSorted(nums, k));
    }
}

package leetcode.p0088_merge_sorted_array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static List<Integer> toList(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            result.add(num);
        }
        return result;
    }

    @Test
    void example1() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        solution.merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertEquals(List.of(1, 2, 2, 3, 5, 6), toList(nums1));
    }

    @Test
    void example2() {
        int[] nums1 = {1};
        solution.merge(nums1, 1, new int[]{}, 0);
        assertEquals(List.of(1), toList(nums1));
    }

    @Test
    void example3() {
        int[] nums1 = {0};
        solution.merge(nums1, 0, new int[]{1}, 1);
        assertEquals(List.of(1), toList(nums1));
    }
}

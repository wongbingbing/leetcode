package leetcode.p0080_remove_duplicates_from_sorted_array_ii;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    private static List<Integer> firstK(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(nums[i]);
        }
        return result;
    }

    @Test
    void example1() {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = solution.removeDuplicates(nums);
        assertEquals(5, k);
        assertEquals(List.of(1, 1, 2, 2, 3), firstK(nums, k));
    }

    @Test
    void example2() {
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k = solution.removeDuplicates(nums);
        assertEquals(7, k);
        assertEquals(List.of(0, 0, 1, 1, 2, 3, 3), firstK(nums, k));
    }
}

package leetcode.p0189_rotate_array;

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
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        assertEquals(List.of(5, 6, 7, 1, 2, 3, 4), toList(nums));
    }

    @Test
    void example2() {
        int[] nums = {-1, -100, 3, 99};
        solution.rotate(nums, 2);
        assertEquals(List.of(3, 99, -1, -100), toList(nums));
    }
}

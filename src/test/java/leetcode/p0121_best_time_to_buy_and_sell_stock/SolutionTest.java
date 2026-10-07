package leetcode.p0121_best_time_to_buy_and_sell_stock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void example1() {
        assertEquals(5, solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void example2() {
        assertEquals(0, solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}

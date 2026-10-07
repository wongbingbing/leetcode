package leetcode.p0121_best_time_to_buy_and_sell_stock;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        // 双重循环，内层只是在找前面的最小值 → 用一个变量边走边维护，降到 O(n)
        int minPrice = prices[0];
        int maxProfit = -1;
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);

            minPrice = Math.min(minPrice, prices[i]);
        }

        return Math.max(maxProfit, 0);
    }
}

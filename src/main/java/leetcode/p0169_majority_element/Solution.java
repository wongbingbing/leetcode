package leetcode.p0169_majority_element;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (counts.containsKey(num)) {
                counts.compute(num, (k, count) -> count + 1);
            } else {
                counts.put(num, 1);
            }
        }

        int requiredTimes = Math.ceilDiv(nums.length, 2);
        Set<Integer> countsKey = counts.keySet();
        for (Integer key : countsKey) {
            Integer count = counts.get(key);
            if (count >= requiredTimes) {
                return key;
            }
        }

        return -1;
    }
}

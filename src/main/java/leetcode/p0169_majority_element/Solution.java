package leetcode.p0169_majority_element;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            if (counts.containsKey(num)) {
                Integer count = counts.get(num);
                count++;
                counts.put(num, count);
            } else {
                counts.put(num, 1);
            }
        }

        // find max value
        int num = -1;
        int max_count = -1;
        for (Map.Entry<Integer, Integer> integerIntegerEntry : counts.entrySet()) {
            Integer number = integerIntegerEntry.getKey();
            Integer count = integerIntegerEntry.getValue();

            if (count > max_count) {
                num = number;
                max_count = count;
            }
        }

        return num;
    }
}

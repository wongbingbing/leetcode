package leetcode.p0080_remove_duplicates_from_sorted_array_ii;

import java.util.Arrays;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int remaining = nums.length;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;

                if (count > 2) {
                    while(nums[i] == nums[i - 1] && i < remaining) {
                        move(nums, i + 1);
                        remaining--;
                    }

                    count = 1;
                }
            } else {
                count = 1;
            }
        }

        System.out.printf("result -> nums: %s, remaining: %s%n", Arrays.toString(nums), remaining);
        return remaining;
    }

    public void move(int[] nums, int startPoint) {
        System.out.printf("moving nums: %s, start point: %s%n", Arrays.toString(nums), startPoint);
        for (int i = startPoint; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
    }
}

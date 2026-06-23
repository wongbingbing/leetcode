package leetcode.p0080_remove_duplicates_from_sorted_array_ii;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = -1;
        int duplicated = 1;
        for (int quick = 1; quick < nums.length; quick++) {
            if (nums[quick] == nums[quick - 1]) {
                duplicated++;

                if (duplicated == 2) {
                    nums[slow + 1] = nums[quick - 1];
                    nums[slow + 2] = nums[quick];

                    slow += 2;
                }
            } else {
                nums[slow + 1] = nums[quick];
                slow++;
                duplicated = 1;
            }
        }

        return slow;
    }
}

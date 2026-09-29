package leetcode.p0189_rotate_array;

public class Solution {
    public void rotate(int[] nums, int k) {
        int[] rotated_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            rotated_nums[(i + k) % rotated_nums.length] = nums[i];
        }

        System.arraycopy(rotated_nums, 0, nums, 0, nums.length);
    }
}

package leetcode.p0189_rotate_array;

public class Solution {
    public void rotate(int[] nums, int k) {
        int count = 0;
        // 关键点1：在循环内不改变start，采取的方法是额外创建一个变量current来替代start执行循环
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            // 关键点2: 用一个变量来保存之前的的下标的值
            int previous = nums[start];
            do {
                int next = (current + k) % nums.length;

                // 关键点3: 之前的下标的值在替换前需要临时存储
                int tmp = nums[next];
                nums[next] = previous;
                previous = tmp;

                current = next;
                count++;
            } while (current != start);
        }
    }
}

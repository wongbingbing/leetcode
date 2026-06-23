package leetcode.p0088_merge_sorted_array;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0){
            return;
        }

        int i = n - 1;
        int j = m - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            int num2 = nums2[i];
            int num1 = nums1[j];

            if (num2 > num1) {
                nums1[k] = num2;
                i--;
            } else {
                nums1[k] = num1;
                j--;
            }

            k--;
        }

        // no elements in nums1 anymore, but nums2 still has elements, it happens when m < n
        while (i >= 0) {
            nums1[k] = nums2[i];
            i--;
            k--;
        }
    }
}

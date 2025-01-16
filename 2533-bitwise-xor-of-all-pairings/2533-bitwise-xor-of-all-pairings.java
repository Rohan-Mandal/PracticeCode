class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;

        // Compute XOR of nums1 and nums2
        for (int num : nums1) {
            xor1 ^= num;
        }
        for (int num : nums2) {
            xor2 ^= num;
        }

        // Calculate the final result based on the lengths of the arrays
        int result = 0;

        if (nums1.length % 2 == 1) {
            result ^= xor2; // nums2 contributes if nums1.length is odd
        }
        if (nums2.length % 2 == 1) {
            result ^= xor1; // nums1 contributes if nums2.length is odd
        }

        return result;
    }
}

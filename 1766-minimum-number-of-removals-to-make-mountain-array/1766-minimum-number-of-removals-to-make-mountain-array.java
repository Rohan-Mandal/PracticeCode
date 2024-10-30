class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        // Calculate LIS up to each index i (for left side of the peak)
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    left[i] = Math.max(left[i], left[j] + 1);
                }
            }
        }
        
        // Calculate LIS from each index i to the end (for right side of the peak)
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        
        int maxMountainLength = 0;
        
        // Find the maximum mountain length
        for (int i = 1; i < n - 1; i++) {
            if (left[i] > 1 && right[i] > 1) {  // Ensure it's a valid peak
                maxMountainLength = Math.max(maxMountainLength, left[i] + right[i] - 1);
            }
        }
        
        // Minimum removals needed
        return n - maxMountainLength;
    }
}

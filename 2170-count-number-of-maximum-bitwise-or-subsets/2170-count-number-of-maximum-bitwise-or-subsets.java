class Solution {

    public int countMaxOrSubsets(int[] nums) {
        int maxOrValue = 0;
        int maxOrCount = 0;

        // There are 2^n subsets for an array of length n
        int totalSubsets = 1 << nums.length;

        // Iterate through all possible subsets using bit manipulation
        for (int i = 1; i < totalSubsets; i++) {
            int currentOrValue = 0;
            for (int j = 0; j < nums.length; j++) {
                // Check if the j-th bit in i is set; if so, include nums[j] in the subset
                if ((i & (1 << j)) != 0) {
                    currentOrValue |= nums[j];
                }
            }

            // Update maximum OR value and count occurrences of this maximum value
            if (currentOrValue > maxOrValue) {
                maxOrValue = currentOrValue;
                maxOrCount = 1; // Reset the count since we found a new maximum
            } else if (currentOrValue == maxOrValue) {
                maxOrCount++; // Increment the count if current OR equals the max OR value
            }
        }
        return maxOrCount;

    }
}
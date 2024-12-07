class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = getMax(nums);
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDivide(nums, maxOperations, mid)) {
                result = mid; // Update result and try for a smaller penalty
                right = mid - 1;
            } else {
                left = mid + 1; // Increase penalty to satisfy constraints
            }
        }
        return result;
    }

    // Helper method to check if a given penalty can be achieved with maxOperations
    private boolean canDivide(int[] nums, int maxOperations, int penalty) {
        int operations = 0;

        for (int num : nums) {
            if (num > penalty) {
                // Calculate how many splits are needed for this bag
                operations += (num - 1) / penalty;
            }
            if (operations > maxOperations) {
                return false;
            }
        }
        return true;
    }

    // Helper method to find the maximum element in the array
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}

class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] maxRight = new int[nums.length];
        maxRight[nums.length - 1] = nums[nums.length - 1];
   
        for (int i = nums.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], nums[i]);
        }

        int ramp = 0;
        int i = 0;
        int j = 0;

        // Find the maximum width ramp
        while (j < nums.length) {
            while (i < j && nums[i] > maxRight[j]) {
                i++;
            }
            ramp = Math.max(ramp, j - i);
            j++;
        }

        return ramp;
    }
}
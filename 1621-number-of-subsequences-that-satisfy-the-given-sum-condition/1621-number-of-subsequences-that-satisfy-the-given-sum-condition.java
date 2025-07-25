class Solution {
    private static final int M = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int[] power = new int[n];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            power[i] = (power[i - 1] * 2) % M;
        }

        int l = 0, r = n - 1;
        int result = 0;

        while (l <= r) {
            int diff = r - l;
            if (nums[l] + nums[r] <= target) {
                result = (result + power[diff]) % M;
                l++;
            } else {
                r--;
            }
        }
        return result;
    }
}
class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;

        int[][] dp = new int[k][n];
        for(int i = 0; i < k; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = 1;
            }
        }
        int maxLenSub = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                int mod = (nums[i] + nums[j]) % k;
                dp[mod][i] = Math.max(dp[mod][i], 1 + dp[mod][j]);
                maxLenSub = Math.max(maxLenSub, dp[mod][i]);
            }
        }
        return maxLenSub;
    }
}
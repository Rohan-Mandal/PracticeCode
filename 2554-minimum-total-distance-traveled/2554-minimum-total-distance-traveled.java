class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
                // Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        int r = robot.size();
        int f = factory.length;
        long[][] dp = new long[f + 1][r + 1];

        // Initialize DP array with high values
        for (int i = 0; i <= f; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }
        dp[0][0] = 0;

        // Populate DP array
        for (int i = 1; i <= f; i++) {
            for (int j = 0; j <= r; j++) {
                dp[i][j] = dp[i - 1][j]; // Case when the current factory is not used
                int limit = factory[i - 1][1];
                long totalDistance = 0;

                // Try assigning up to `limit` robots to this factory
                for (int k = 1; k <= limit && j - k >= 0; k++) {
                    totalDistance += Math.abs(robot.get(j - k) - factory[i - 1][0]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + totalDistance);
                }
            }
        }

        // The answer is the minimum distance to repair all robots
        return dp[f][r];
    }
}
      
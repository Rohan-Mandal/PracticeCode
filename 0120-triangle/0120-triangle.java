class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        // Appraoch 1: Recursion & memoization
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return dfs(triangle, 0, 0, dp);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col, Integer[][] dp) {
        // base case: last row
        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        // If already computed, return cached value
        if (dp[row][col] != null) {
            return dp[row][col];
        }

        // recursive calls
        int down = dfs(triangle, row + 1, col, dp);
        int downAdjc = dfs(triangle, row + 1, col + 1, dp);
        dp[row][col] = triangle.get(row).get(col) + Math.min(down, downAdjc);

        return dp[row][col];

        // Approach 2:- Bottom-up (In-place)
        // int n = triangle.size();

        // Start from second last row, move upwards
        // for (int row = n - 2; row >= 0; row--) {
        //     for (int col = 0; col < triangle.get(row).size(); col++) {
        //         int up = triangle.get(row + 1).get(col);
        //         int upDiag = triangle.get(row + 1).get(col + 1);
        //         int minVal = triangle.get(row).get(col) + Math.min(up, upDiag);
        //         triangle.get(row).set(col, minVal);
        //     }
        // }
        // return triangle.get(0).get(0);

        // Approach 3: 1D dp array
        // int n = triangle.size();
        // int[] dp = new int[n];

        // // initialize dp with last row
        // for (int i = 0; i < n; i++) {
        //     dp[i] = triangle.get(n - 1).get(i);
        // }

        // // build from bottom up
        // for (int row = n - 2; row >= 0; row--) {
        //     for (int col = 0; col <= row; col++) {
        //         dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
        //     }
        // }

        // return dp[0];
    }
}
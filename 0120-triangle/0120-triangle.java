class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return dfs(triangle, 0, 0, dp);
    }

    private int dfs(List<List<Integer>> triangle, int row, int col, Integer[][] dp){
        // base case: last row
        if(row == triangle.size() - 1){
            return triangle.get(row).get(col);
        }

        // If already computed, return cached value
        if(dp[row][col] != null){
            return dp[row][col];
        }

        // recursive calls
        int down = dfs(triangle, row + 1, col, dp);
        int downAdjc = dfs(triangle, row + 1, col + 1, dp);
        dp[row][col] = triangle.get(row).get(col) + Math.min(down, downAdjc);

        return dp[row][col];
    }
}
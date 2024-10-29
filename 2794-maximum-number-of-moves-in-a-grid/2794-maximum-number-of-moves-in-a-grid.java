class Solution {
    private int[][] grid;
    private int[][] memo;
    private int rows, cols;
    private int[] directions = {-1, 0, 1};  // To move to (row-1, col+1), (row, col+1), and (row+1, col+1)
    
    public int maxMoves(int[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.memo = new int[rows][cols];
        
        int maxMoves = 0;
        
        // Start from each cell in the first column
        for (int i = 0; i < rows; i++) {
            maxMoves = Math.max(maxMoves, dfs(i, 0));
        }
        
        return maxMoves;
    }
    
    private int dfs(int row, int col) {
        // If we have already computed the result for this cell, return it
        if (memo[row][col] != 0) {
            return memo[row][col];
        }
        
        int maxSteps = 0;
        
        // Explore the three possible moves
        for (int dir : directions) {
            int newRow = row + dir;
            int newCol = col + 1;
            
            // Check if the new cell is within bounds and has a greater value than the current cell
            if (newRow >= 0 && newRow < rows && newCol < cols && grid[newRow][newCol] > grid[row][col]) {
                maxSteps = Math.max(maxSteps, 1 + dfs(newRow, newCol));
            }
        }
        
        // Store the result in memo array and return it
        memo[row][col] = maxSteps;
        return maxSteps;
    }
}

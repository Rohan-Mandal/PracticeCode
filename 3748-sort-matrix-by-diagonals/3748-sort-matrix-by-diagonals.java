class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // Bottom-left triangle including the main diagonal
        for(int row = 0; row < n; row++){       
            processDiagonal(grid, row, 0, true); // Start from (row, 0), descending
        }

        // Top-right diagonals
        for(int col = 1; col < n; col++){           // col = 0 already included in main diagonal
            processDiagonal(grid, 0, col, false) ;   // Start from (0, col), ascending
        }
        return grid;
    }

    private void processDiagonal(int[][] grid, int row, int col, boolean descending){
        int n = grid.length;
        
        // We take a list to store diagonal elements
        List<Integer> diagonal = new ArrayList<>();

        int r = row, c = col;
        // Store the elements
        while(r < n && c < n){
            diagonal.add(grid[r][c]);
            r++;
            c++;
        }

        // Sort the elements
        if(descending){
            diagonal.sort(Collections.reverseOrder());
        } else{
            Collections.sort(diagonal);
        }

        // Place the element back to grid
        r = row; c = col; // reset the row and col
        int idx = 0; // to move in the list
        while(r < n && c < n){
            grid[r][c] = diagonal.get(idx++);
            r++;
            c++;
        }
    }
}
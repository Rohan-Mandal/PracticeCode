class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                
                String row = board[i][j] + "_row_" + i;
                String col = board[i][j] + "_col_" + j;
                String box = board[i][j] + "_box_" + (i / 3) + "_" + (j / 3);
                
                if (seen.contains(row) || seen.contains(col) || seen.contains(box)) {
                    return false;
                }
                seen.add(row);
                seen.add(col);
                seen.add(box);
            }
        }
        
        return true;
    }
}

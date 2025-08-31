class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.'){             // empty cell found
                    for(char d = '1'; d <= '9'; d++){
                        if(isValid(board, row, col, d)){
                            board[row][col] = d;  // choose

                            if(solve(board)){
                                return true;   // solved
                            }
                            board[row][col] = '.';  // undo (backtrack)
                        }
                    }
                    return false;           // No valid Number
                }
            }
        }
        return true;        // All cells filled
    }

    private boolean isValid(char[][] board, int row, int col, char num){
        // Checking row and col
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num || board[i][col] == num){
                return false;
            }
        }

        // check 3*3 box
        int start_row = (row / 3) * 3;
        int start_col = (col / 3) * 3;

        for(int r = 0; r < 3; r++){
            for(int c = 0; c < 3; c++){
                if(board[start_row + r][start_col + c] == num){
                    return false;
                }
            }
        }
        return true;
    }
}